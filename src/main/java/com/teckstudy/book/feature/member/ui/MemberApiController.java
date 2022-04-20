package com.teckstudy.book.feature.member.ui;

import com.teckstudy.book.core.lib.common.base.BaseApiController;
import com.teckstudy.book.core.lib.common.base.SuccessResponse;
import com.teckstudy.book.feature.member.application.MemberService;
import com.teckstudy.book.feature.member.ui.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <pre>
 * com.teckstudy.book.ui.authentication
 *      MemberApiController
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-16 오전 12:44
 */

@RestController
@RequiredArgsConstructor
public class MemberApiController extends BaseApiController {

    private final MemberService userService;

    @PostMapping("/users")
    public ResponseEntity<SuccessResponse<Void>> signup(@Valid @RequestBody SignUpRequest request) {

        userService.signUp(request);
        return ResponseEntity.ok(SuccessResponse.of("200", "회원가입", null));
    }
}
