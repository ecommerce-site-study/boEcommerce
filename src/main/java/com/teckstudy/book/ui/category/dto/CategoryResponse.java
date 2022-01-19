package com.teckstudy.book.ui.category.dto;

import com.teckstudy.book.application.category.dto.CategoryWrapper;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryResponse {


    @Getter
    public static class LayerCategory {
        private Long categoryId;
        private Long parentId;
        private String displayName;
        private Long order;
        private boolean hasSubCategories;
        private List<LayerCategory> subCategories;

        @Builder
        private LayerCategory(Long categoryId, Long parentId, String displayName, Long order, boolean hasSubCategories, List<LayerCategory> subCategories) {
            this.categoryId = categoryId;
            this.parentId = parentId;
            this.displayName = displayName;
            this.order = order;
            this.hasSubCategories = hasSubCategories;
            this.subCategories = subCategories;
        }

        public static LayerCategory from (CategoryWrapper.LayerCategoryDto category) {
            return LayerCategory.builder()
                    .categoryId(category.getCategoryId())
                    .parentId(category.getParentId())
                    .displayName(category.getDisplayName())
                    .order(category.getOrder())
                    .hasSubCategories(category.isHasSubCategories())
                    .subCategories(convertSubCategories(category.getSubCategories()))
                    .build();
        }

        public static List<LayerCategory> convertSubCategories(List<CategoryWrapper.LayerCategoryDto> subCategories) {
            return subCategories.stream()
                    .map(LayerCategory::from)
                    .collect(Collectors.toList());

        }
    }
}