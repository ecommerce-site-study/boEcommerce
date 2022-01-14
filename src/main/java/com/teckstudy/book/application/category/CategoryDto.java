package com.teckstudy.book.application.category;

import com.teckstudy.book.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CategoryDto {
    private Long categoryId;
    private String displayName;
    private Long parentId;
    private LocalDate createAt;
    private LocalDate lastModifyAt;

    public CategoryDto(Long categoryId, String displayName, Long parentId, LocalDate createAt, LocalDate lastModifyAt) {
        this.categoryId = categoryId;
        this.displayName = displayName;
        this.parentId = parentId;
        this.createAt = createAt;
        this.lastModifyAt = lastModifyAt;
    }

    public static CategoryDto from(Category category) {
        return new CategoryDto(
                category.categoryId(),
                category.displayName(),
                category.parentId(),
                category.getRegDate(),
                category.getModDate()
        );
    }
}
