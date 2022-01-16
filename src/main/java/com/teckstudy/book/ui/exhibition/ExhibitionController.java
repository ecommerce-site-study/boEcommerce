package com.teckstudy.book.ui.exhibition;

import com.teckstudy.book.application.exhibition.ExhibitionService;
import com.teckstudy.book.application.exhibition.dto.ContentsDto;
import com.teckstudy.book.application.exhibition.dto.ExhibitionDto;
import com.teckstudy.book.ui.exhibition.dto.ExhibitionRequestDto;
import com.teckstudy.book.ui.exhibition.dto.ExhibitionResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "ExhibitionController v1")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    /**
     * 전시카테고리 조회
     */
    @ApiOperation(value = "전시카테고리 조회", notes = "전시카테고리 조회하기")
    @ApiImplicitParam(name = "id", value = "전시관리번호", required = true)
    @GetMapping("/api/exhibition/{id}")
    public ResponseEntity<ExhibitionResponseDto> findById (@PathVariable("id") Long id) {

        List<ContentsDto> contents = exhibitionService.findByContents(id);

        ExhibitionDto exhibition = exhibitionService.findById(id);
        exhibition.setContentsList(contents);

        return ResponseEntity.ok().body(ExhibitionResponseDto.builder().build());
    }

    /**
     * 전시카테고리 등록 및 컨텐츠 타입 등록
     */
    @ApiOperation(value = "전시카테고리 등록", notes = "전시카테고리 등록 및 컨텐츠 타입 등록")
    @PostMapping("/api/exhibition/save")
    public ResponseEntity<ExhibitionResponseDto> registerExhibition(@RequestBody ExhibitionRequestDto requestDto) {

        Long exhibitionSn = exhibitionService.exhibitionSave(requestDto);

        List<ContentsDto> contents = exhibitionService.findByContents(exhibitionSn);

        ExhibitionDto exhibitionDto = exhibitionService.findById(exhibitionSn);
        exhibitionDto.setContentsList(contents);

        return ResponseEntity.ok().body(ExhibitionResponseDto.builder().build());
    }

    /**
     * 전시카테고리 & 컨텐츠 타입 수정
     */
    @ApiOperation(value = "전시카테고리 & 컨텐츠 타입 수정", notes = "전시카테고리 & 컨텐츠 타입 수정")
    @ApiImplicitParam(name = "id", value = "전시관리번호", dataType = "long", required = true)
    @PutMapping("/api/exhibition/save/{id}")
    public ResponseEntity<ExhibitionResponseDto> updateExhibition(@PathVariable("id") Long id, @RequestBody ExhibitionRequestDto requestDto) {

        Long exhibitionSn = exhibitionService.exhibitionUpdate(id, requestDto);

        List<ContentsDto> contents = exhibitionService.findByContents(exhibitionSn);

        ExhibitionDto exhibitionDto = exhibitionService.findById(exhibitionSn);
        exhibitionDto.setContentsList(contents);

        return ResponseEntity.ok().body(ExhibitionResponseDto.builder().build());
    }
}