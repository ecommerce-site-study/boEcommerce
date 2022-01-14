package com.teckstudy.book.domain.member;

import com.teckstudy.book.domain.base.types.YesNoStatus;
import com.teckstudy.book.domain.member.types.AuthInfoType;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class AuthInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authInfoId;

    @Column(length = 100)
    private String authInfoCode;

    @Enumerated(EnumType.STRING)
    private YesNoStatus authInfoStatus;

    @Enumerated(EnumType.STRING)
    private AuthInfoType authInfoType;

    @OneToOne(mappedBy = "authInfo")
    @JoinColumn(name = "memberId")
    private Member member;

}
