package com.teckstudy.book.domain.member;

import com.teckstudy.book.domain.base.Address;
import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.member.types.Gender;
import com.teckstudy.book.domain.member.types.MemberStatus;
import com.teckstudy.book.domain.review.Review;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;

@Entity
@Getter
@NoArgsConstructor
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

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @OneToOne(mappedBy = "member")
    private AuthInfo authInfo;

    @OneToOne(mappedBy = "member")
    private SocialInfo socialInfo;
}
