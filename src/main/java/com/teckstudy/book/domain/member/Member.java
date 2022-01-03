package com.teckstudy.book.domain.member;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.member.types.GenderType;
import com.teckstudy.book.domain.member.types.MemberStatusType;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String memberId;

    @Column(unique = true)
    private String email;

    @Column(length = 30, nullable = true)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private GenderType sex;

    @Column(length = 20)
    private String birthday;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 100)
    private String address;

    @Enumerated(EnumType.STRING)
    private MemberStatusType memberStatusType;

    @OneToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_sn")
    private AuthInfo authInfo;

    @OneToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_sn")
    private SocialInfo socialInfo;

}
