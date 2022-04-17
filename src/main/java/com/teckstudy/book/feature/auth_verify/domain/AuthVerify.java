package com.teckstudy.book.feature.auth_verify.domain;

import com.teckstudy.book.core.types.AuthInfoType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <pre>
 * com.teckstudy.book.core.domain.auth_verify
 *      AuthVerify
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-16 오전 1:36
 */

@Entity
public class AuthVerify {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AuthInfoType authType;

    private String authKey;
    private String authValue;
}
