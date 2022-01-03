package com.teckstudy.book.domain.member;

import com.teckstudy.book.domain.base.YesNoStatus;
import com.teckstudy.book.domain.member.types.AuthInfoType;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Builder
@AllArgsConstructor
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

}
