package com.teckstudy.book.ui.exhibition;

import com.teckstudy.book.application.exhibition.ExhibitionService;
import com.teckstudy.book.application.exhibition.dto.ExhibitionDto;
import com.teckstudy.book.lib.common.base.BaseAbstractController;
import com.teckstudy.book.lib.common.base.SuccessResponse;
import com.teckstudy.book.ui.exhibition.dto.ExhibitionRequestDto;
import com.teckstudy.book.ui.exhibition.dto.ExhibitionResponseDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "ExhibitionController v1")
@RequiredArgsConstructor
@RestController
public class ExhibitionController extends BaseAbstractController {

    private final ExhibitionService exhibitionService;

    /**
     * 전시관리 조회
     * @return
     */
    @ApiOperation(value = "전시관리 조회", notes = "전시관리 조회하기")
    @ApiImplicitParam(name = "id", value = "전시관리번호", required = true, paramType = "path", dataType = "long")
    @ApiResponses({
            @ApiResponse(code = 200, message = "전시카테고리 조회 성공"),
            @ApiResponse(code = 400, message = "잘못된 접근"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/api/exhibitions/{id}")
    public ResponseEntity<SuccessResponse> findById (@PathVariable("id") Long id) {

        ExhibitionDto exhibition = exhibitionService.findById(id);

        return ResponseEntity.ok(SuccessResponse.of(200L, "success", ExhibitionResponseDto.from(exhibition)));
    }

    /**
     * 전시관리 등록 및 컨텐츠 타입 등록
     * @return
     */
    @ApiOperation(value = "전시관리 등록", notes = "전시관리 등록 및 컨텐츠 타입 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "전시관리 등록 성공"),
            @ApiResponse(code = 400, message = "잘못된 접근"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/api/exhibitions")
    public ResponseEntity<SuccessResponse> registerExhibition(@RequestBody ExhibitionRequestDto requestDto) {

        ExhibitionDto exhibition = exhibitionService.exhibitionSave(requestDto.toWrapper());

        return ResponseEntity.ok(SuccessResponse.of(201L, "success", ExhibitionResponseDto.from(exhibition)));
    }

    /**
     * 전시관리 & 컨텐츠 타입 수정
     * @return
     */
    @ApiOperation(value = "전시관리 & 컨텐츠 타입 수정", notes = "전시관리 & 컨텐츠 타입 수정")
    @ApiImplicitParam(name = "id", value = "전시관리번호", paramType = "path", dataType = "long", required = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "전시관리 수정 성공"),
            @ApiResponse(code = 400, message = "잘못된 접근"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PatchMapping("/api/exhibitions/{id}")
    public ResponseEntity<SuccessResponse> updateExhibition(@PathVariable("id") Long id, @RequestBody ExhibitionRequestDto requestDto) {

        ExhibitionDto exhibition = exhibitionService.exhibitionUpdate(id, requestDto.toWrapper());
        return ResponseEntity.ok(SuccessResponse.of(200L, "Update Exhibition", ExhibitionResponseDto.from(exhibition)));

    }
}