package com.teckstudy.book.feature.application.category.dto;

public class SearchCategoryDto {
    private Long categoryId;
    private String displayName;
    private Long parentId;


    public SearchCategoryDto(Long categoryId, String displayName, Long parentId) {
        this.categoryId = categoryId;
        this.displayName = displayName;
        this.parentId = parentId;
    }

}