package com.teckstudy.book.domain.member;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.member.types.Gender;
import com.teckstudy.book.domain.member.types.MemberStatus;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(unique = true)
    private String email;

    @Column(length = 100)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(length = 8)
    private String birthday;

    @Column(length = 11 )
    private String phoneNumber;

//    @Embedded
    private String address;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @OneToOne(mappedBy = "member")
    private AuthInfo authInfo;

    @OneToOne(mappedBy = "member")
    private SocialInfo socialInfo;

    protected Member() {

    }

    public Member(String email, String password, String name,
                  Gender sex, String birthday, String phoneNumber, String address,
                  MemberStatus memberStatus) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.memberStatus = memberStatus;
    }

}