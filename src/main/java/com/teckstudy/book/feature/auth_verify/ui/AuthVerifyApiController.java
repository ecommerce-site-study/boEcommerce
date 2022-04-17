package com.teckstudy.book.feature.auth_verify.ui;

import com.teckstudy.book.core.lib.common.base.BaseApiController;
import com.teckstudy.book.core.lib.common.base.SuccessResponse;
import com.teckstudy.book.core.types.AuthInfoType;
import com.teckstudy.book.feature.auth_verify.application.AuthVerifyService;
import com.teckstudy.book.feature.auth_verify.ui.request.AuthRequest;
import com.teckstudy.book.feature.auth_verify.ui.request.AuthVerifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
public class AuthVerifyApiController extends BaseApiController {

    private final AuthVerifyService authVerifyService;

    // 휴대전화 인증요청 API
    @PostMapping("/auth/{authType}")
    public ResponseEntity<SuccessResponse<Void>> phoneNumberAuth(
            @PathVariable(value = "authType") AuthInfoType type,
            @Valid @RequestBody AuthRequest request) {

        authVerifyService.createAuthVerify(type, request);
        return ResponseEntity.ok(SuccessResponse.of("200", "인증", null));
    }

    @PostMapping("/auth/{authType}/verify")
    public ResponseEntity<SuccessResponse<Void>> phoneNumberAuthVerify(
            @PathVariable(value = "authType") AuthInfoType type,
            @Valid @RequestBody AuthVerifyRequest request) {

        authVerifyService.verify(type,request);
        return ResponseEntity.ok(SuccessResponse.of("200", "인증 성공", null));
    }
}
