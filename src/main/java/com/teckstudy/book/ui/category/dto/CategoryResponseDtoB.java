package com.teckstudy.book.ui.category.dto;

import com.teckstudy.book.application.category.dto.CategoryDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CategoryResponseDtoB {

    private Long categoryId;
    private String displayName;
    private Long parentId;
    private LocalDate createAt;
    private LocalDate modAt;

    public CategoryResponseDtoB(Long categoryId, String displayName, Long parentId, LocalDate createAt, LocalDate modAt) {
        this.categoryId = categoryId;
        this.displayName = displayName;
        this.parentId = parentId;
        this.createAt = createAt;
        this.modAt = modAt;
    }

    public static CategoryResponseDtoB from(CategoryDto category) {
        return new CategoryResponseDtoB(
                category.getCategoryId(),
                category.getDisplayName(),
                category.getParentId(),
                category.getCreateAt(),
                category.getLastModifyAt()
        );
    }
}