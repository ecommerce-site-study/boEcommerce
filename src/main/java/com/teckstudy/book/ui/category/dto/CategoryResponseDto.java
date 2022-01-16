package com.teckstudy.book.ui.category.dto;

import com.teckstudy.book.application.category.dto.CategoryDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryResponseDto {

    private Long categoryId;
    private String displayName;
    private Long parentId;

    private CategoryResponseDto(Long categoryId, String displayName, Long parentId) {
        this.categoryId = categoryId;
        this.displayName = displayName;
        this.parentId = parentId;
    }

    public static CategoryResponseDto from(CategoryDto category) {
        return new CategoryResponseDto(
                category.getCategoryId(),
                category.getDisplayName(),
                category.getParentId()
        );
    }
}