package com.teckstudy.book.domain.exhibition.repository;

import com.teckstudy.book.ui.exhibition.ContentsTypeResponseDto;
import com.teckstudy.book.ui.exhibition.ExhibitionResponseDto;

import java.util.List;

public interface ExhibitionRepositoryCustom {
    List<ExhibitionResponseDto> findExhibition(Long id) throws Exception;

    List<ContentsTypeResponseDto> findContents(Long id) throws Exception;
}