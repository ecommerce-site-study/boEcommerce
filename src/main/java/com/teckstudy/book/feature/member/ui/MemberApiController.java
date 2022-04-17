package com.teckstudy.book.feature.member.ui;

import com.teckstudy.book.feature.member.application.MemberService;
import com.teckstudy.book.core.lib.common.base.SuccessResponse;
import com.teckstudy.book.core.lib.common.base.BaseAbstractController;
import com.teckstudy.book.feature.member.ui.request.PhoneNumberAuthRequest;
import com.teckstudy.book.feature.member.ui.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <pre>
 * com.teckstudy.book.ui.authentication
 *      MemberApiController
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-16 오전 12:44
 */

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class MemberApiController extends BaseAbstractController {

    private final MemberService userService;

    @PostMapping
    public ResponseEntity<SuccessResponse<Void>> signup(@Valid @RequestBody SignUpRequest request) {

        userService.signUp(request);
        return ResponseEntity.ok(SuccessResponse.of(200L, "회원가입", null));
    }


    // 휴대전화 인증요청 API
    @PostMapping("/phone/auth")
    public ResponseEntity<SuccessResponse<Void>> phoneNumberAuth(@RequestBody PhoneNumberAuthRequest request) {




        return ResponseEntity.ok(SuccessResponse.of(200L, "휴대폰번호 인증", null));
    }

    @PostMapping("/phone/auth/verify")
    public ResponseEntity<SuccessResponse<Void>> phoneNumberAuthVerify() {
        return ResponseEntity.ok(SuccessResponse.of(200L, "휴대폰번호 인증", null));
    }
}
