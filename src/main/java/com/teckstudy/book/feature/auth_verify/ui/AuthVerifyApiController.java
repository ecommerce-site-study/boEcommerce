package com.teckstudy.book.feature.auth_verify.ui;

import com.teckstudy.book.core.lib.common.base.BaseAbstractController;
import com.teckstudy.book.core.lib.common.base.SuccessResponse;
import com.teckstudy.book.core.types.AuthInfoType;
import com.teckstudy.book.feature.auth_verify.application.AuthVerifyService;
import com.teckstudy.book.feature.auth_verify.ui.request.AuthRequest;
import com.teckstudy.book.feature.auth_verify.ui.request.AuthVerifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthVerifyApiController extends BaseAbstractController {

    private final AuthVerifyService authVerifyService;

    // 휴대전화 인증요청 API
    @PostMapping("/{authType}")
    public ResponseEntity<SuccessResponse<Void>> phoneNumberAuth(
            @PathVariable(value = "authType") AuthInfoType type,
            @RequestBody AuthRequest request) {

        request.type(type);
        authVerifyService.createAuthVerify(request);
        return ResponseEntity.ok(SuccessResponse.of(200L, "휴대폰번호 인증", null));
    }

    @PostMapping("/{authType}/verify")
    public ResponseEntity<SuccessResponse<Void>> phoneNumberAuthVerify(
            @PathVariable(value = "authType") AuthInfoType type,
            @RequestBody AuthVerifyRequest request) {

        request.type(type);
        authVerifyService.verify(request);
        return ResponseEntity.ok(SuccessResponse.of(200L, "휴대폰번호 인증", null));
    }
}
