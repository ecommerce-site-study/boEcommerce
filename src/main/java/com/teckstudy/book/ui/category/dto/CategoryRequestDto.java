package com.teckstudy.book.ui.category.dto;

import com.teckstudy.book.application.category.dto.SearchCategoryDto;

public class CategoryRequestDto {

    private Long categoryId;
    private String displayName;
    private Long parentId;


    public SearchCategoryDto toWrapper() {

        return new SearchCategoryDto(this.categoryId, this.displayName, this.parentId);
    }

}