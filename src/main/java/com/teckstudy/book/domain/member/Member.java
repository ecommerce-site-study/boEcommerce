package com.teckstudy.book.domain.member;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.member.types.Gender;
import com.teckstudy.book.domain.member.types.MemberStatus;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
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
    private Gender sex;

    @Column(length = 20)
    private String birthday;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 100)
    private String address;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @OneToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_sn")
    private AuthInfo authInfo;

    @OneToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_sn")
    private SocialInfo socialInfo;

}
