package com.teckstudy.book.feature.auth_verify.infra;

import com.teckstudy.book.feature.auth_verify.domain.AuthVerify;
import com.teckstudy.book.feature.auth_verify.infra.rdb.AuthVerifyQueryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthVerifyRepository extends JpaRepository<AuthVerify, Long>, AuthVerifyQueryCustom {
}
