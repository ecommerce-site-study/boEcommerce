package com.teckstudy.book.feature.member.application;

import com.teckstudy.book.core.configuration.security.UserDetailsImpl;
import com.teckstudy.book.core.lib.common.fuction.exception.AuthVerifyException;
import com.teckstudy.book.core.lib.common.fuction.exception.UserException;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerify;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerifyDataprovider;
import com.teckstudy.book.feature.member.application.dto.MemberDto;
import com.teckstudy.book.feature.member.application.mapper.MemberMapper;
import com.teckstudy.book.feature.member.domain.Member;
import com.teckstudy.book.feature.member.domain.MemberDataProvider;
import com.teckstudy.book.core.types.SocialType;
import com.teckstudy.book.feature.oauth2.OAuth2Token;
import com.teckstudy.book.feature.oauth2.account.OAuth2Account;
import com.teckstudy.book.feature.oauth2.account.OAuth2AccountDTO;
import com.teckstudy.book.feature.oauth2.account.OAuth2AccountRepository;
import com.teckstudy.book.feature.oauth2.userInfo.OAuth2UserInfo;
import com.teckstudy.book.feature.member.ui.request.SignUpRequest;
import com.teckstudy.book.feature.member.ui.request.UpdateProfileRequest;
import com.teckstudy.book.feature.role.Role;
import com.teckstudy.book.feature.role.repository.RoleRepository;
import io.jsonwebtoken.lang.Assert;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDataProvider memberDataProvider;
    private final AuthVerifyDataprovider authVerifyDataprovider;
    private final OAuth2AccountRepository oAuth2AccountRepository;
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    // 계층권한
    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public void signUp(SignUpRequest signUpRequest) {
        // 이미 존재하는 email일 경우
        checkDuplicateEmail(signUpRequest.getEmail());

        // 입력바든 휴대폰번호에 대한 값이 인증이 되었는지 여부 확인.
        AuthVerify authVerify = authVerifyDataprovider.certificationAuthVerify(signUpRequest.getAuthIdentity(), signUpRequest.getAuthCode());

        // 존재 하지 않는 정보라면 exception
        checkEmptyAuthVerify(authVerify);

        // 회원가입 객체 생성
        Member member = memberMapper.createDefaultUser(signUpRequest);

        // 회원 정보랑 authVerify 연동
        member.certificate(authVerify);

        memberDataProvider.save(member);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OAuth2AccountDTO> getOAuth2Account(String username) {
        Optional<Member> optionalUser = memberDataProvider.findByUsername(username);
        if (!optionalUser.isPresent() || optionalUser.get().getSocial() == null) return Optional.empty();
        return Optional.of(optionalUser.get().getSocial().toDTO());
    }

    @Override
    public void updateProfile(String username, UpdateProfileRequest updateProfileRequest) {

        Member user = memberDataProvider.findByUsername(username).get();

        //이름이 변경되었는지 체크
        if (!user.getName().equals(updateProfileRequest.getName()))
            user.updateName(updateProfileRequest.getName());

        //이메일이 변경되었는지 체크
        if (!user.getEmail().equals(updateProfileRequest.getEmail())) {
            checkDuplicateEmail(updateProfileRequest.getEmail());
            user.updateEmail(updateProfileRequest.getEmail());
        }
    }


    @Override
    public UserDetails loginOAuth2User(String provider, OAuth2Token oAuth2Token, OAuth2UserInfo memberInfo) {

        Optional<OAuth2Account> optOAuth2Account = oAuth2AccountRepository.findByProviderAndProviderId(provider, memberInfo.getId());
        Member member = null;

        //가입된 계정이 존재할때
        if (optOAuth2Account.isPresent()) {
            OAuth2Account oAuth2Account = optOAuth2Account.get();
            member = oAuth2Account.getMember();
            //토큰 업데이트
            oAuth2Account.updateToken(oAuth2Token.getToken(), oAuth2Token.getRefreshToken(), oAuth2Token.getExpiredAt());
        }
        //가입된 계정이 존재하지 않을때
        else {
            //소셜 계정 정보 생성
            OAuth2Account newAccount = OAuth2Account.builder()
                    .provider(provider)
                    .providerId(memberInfo.getId())
                    .token(oAuth2Token.getToken())
                    .refreshToken(oAuth2Token.getRefreshToken())
                    .tokenExpiredAt(oAuth2Token.getExpiredAt()).build();
            oAuth2AccountRepository.save(newAccount);

            //이메일 정보가 있을때
            if (memberInfo.getEmail() != null) {
                // 같은 이메일을 사용하는 계정이 존재하는지 확인 후 있다면 소셜 계정과 연결시키고 없다면 새로 생성한다
                member = memberDataProvider.findByEmail(memberInfo.getEmail())
                        .orElse(Member.builder()
                                .username(provider + "_" + memberInfo.getId())
                                .name(memberInfo.getName())
                                .email(memberInfo.getEmail())
                                .socialType(SocialType.findSocialType(provider))
                                .build());
            }
            //이메일 정보가 없을때
            else {
                member = Member.builder()
                        .username(provider + "_" + memberInfo.getId())
                        .name(memberInfo.getName())
                        .socialType(SocialType.findSocialType(provider))
                        .build();
            }

            //새로 생성된 유저이면 db에 저장
            if (member.getMemberId() == null)
                memberDataProvider.save(member);

            //연관관계 설정
            member.linkSocial(newAccount);
        }

        return UserDetailsImpl.builder()
                .id(member.getMemberId())
                .username(member.getUsername())
                .name(member.getName())
                .email(member.getEmail())
                .type(member.getSocialType())
                .build();
//                .authorities(member.getAuthorities()).build();
    }

    @Override
    public UserDetails linkOAuth2Account(String username, String provider, OAuth2Token oAuth2Token, OAuth2UserInfo userInfo) {
        Member member = checkRegisteredUser(username);

        //이미 등록된 소셜 계정이라면 연동된 계정이 존재
        Assert.state(oAuth2AccountRepository.existsByProviderAndProviderId(provider, userInfo.getId()) == false, "소셜 계정에 연동된 계정이 이미 존재합니다.");

        //소셜 계정 정보 생성
        OAuth2Account oAuth2Account = OAuth2Account.builder()
                .provider(provider)
                .providerId(userInfo.getId())
                .token(oAuth2Token.getToken())
                .refreshToken(oAuth2Token.getRefreshToken())
                .tokenExpiredAt(oAuth2Token.getExpiredAt())
                .build();
        oAuth2AccountRepository.save(oAuth2Account);

        //연관관계 설정
        member.linkSocial(oAuth2Account);

        return UserDetailsImpl.builder()
                .id(member.getMemberId())
                .username(member.getUsername())
                .name(member.getName())
                .email(member.getEmail())
                .type(member.getSocialType())
                .build();
//                .authorities(member.getAuthorities()).build();
    }

    @Override
    public OAuth2AccountDTO unlinkOAuth2Account(String username) {
        Member member = checkRegisteredUser(username);

        //연관관계 해제
        OAuth2Account oAuth2Account = member.getSocial();
        OAuth2AccountDTO oAuth2AccountDTO = oAuth2Account.toDTO();
        member.unlinkSocial();
        oAuth2AccountRepository.delete(oAuth2Account);

        return oAuth2AccountDTO;
    }

    @Override
    public Optional<OAuth2AccountDTO> withdrawUser(String username) {
        OAuth2AccountDTO oAuth2AccountDTO = null;
        Member member = checkRegisteredUser(username);
        //연동된 소셜 계정이 있다면 계정 정보를 리턴하기 위해 저장
        if (member.getSocial() != null)
            oAuth2AccountDTO = member.getSocial().toDTO();
        memberDataProvider.delete(member);
        return Optional.ofNullable(oAuth2AccountDTO);
    }

    private void checkDuplicateEmail(String email) {
        if (memberDataProvider.existsByEmail(email))
            throw new IllegalArgumentException("사용중인 이메일 입니다.");
    }

    private Member checkRegisteredUser(String username) {
//        Optional<Member> optUser = memberRepository.findByUsername(username);
//        Assert.state(optUser.isPresent(), "가입되지 않은 회원입니다.");
//        return optUser.get();
        return null;
    }

    ///////////////////////////////////////////////////////////////////
    @Transactional
    @Override
    public void createUser(Member member) {

        Role role = roleRepository.findByRoleName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        member.setMemberRoles(roles);
        memberDataProvider.save(member);
    }

    @Transactional
    @Override
    public void modifyUser(MemberDto memberDto) {


        // 존제 한다면 업데이트
        ModelMapper modelMapper = new ModelMapper();
        Member member = modelMapper.map(memberDto, Member.class);

        // todo 존재하는 유저인지 검사 필요
        memberDataProvider.findById(member.getMemberId())
                .orElseThrow(UserException.USER_NOT_FOUND::throwException);

        member.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        // 3번 권한
        if (memberDto.getRoles() != null) {
            Set<Role> roles = new HashSet<>();
            memberDto.getRoles().forEach(role -> {
                Role r = roleRepository.findByRoleName(role);
                roles.add(r);
            });
            member.setMemberRoles(roles);
        }

        // SAVE
        memberDataProvider.save(member);

    }

    @Transactional
    public List<Member> getUsers() {
        return memberDataProvider.findAll();
    }

    @Transactional
    public MemberDto getUser(Long id) {

        Member member = memberDataProvider.findById(id).orElse(new Member());
        ModelMapper modelMapper = new ModelMapper();
        MemberDto memberDto = modelMapper.map(member, MemberDto.class);

        List<String> roles = member.getMemberRoles()
                .stream()
                .map(role -> role.getRoleName())
                .collect(Collectors.toList());

        memberDto.setRoles(roles);
        return memberDto;
    }

    @Override
    public void deleteUser(Long id) {
        memberDataProvider.deleteById(id);
    }

    private void checkEmptyAuthVerify(AuthVerify authVerify) {
        if (Objects.isNull(authVerify)) {
            throw AuthVerifyException.AUTH_VERIFY_NOT_FOUND.throwException();
        }
    }
}
