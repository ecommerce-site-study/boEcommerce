package com.teckstudy.book.feature.ui.category.dto;

import com.teckstudy.book.feature.application.category.dto.CategoryWrapper;
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
                    .order(category.getOrdering())
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

    @Getter
    public static class PersistCategory {
        private Long categoryId;
        private Long parentId;
        private String displayName;
        private Long ordering;
        private String useYn;
        private String displayYn;

        @Builder
        public PersistCategory(Long categoryId, Long parentId, String displayName, Long ordering, String useYn, String displayYn) {
            this.categoryId = categoryId;
            this.parentId = parentId;
            this.displayName = displayName;
            this.ordering = ordering;
            this.useYn = useYn;
            this.displayYn = displayYn;
        }

        public static PersistCategory from(CategoryWrapper.PersistCategory category) {
            return PersistCategory.builder()
                    .categoryId(category.getCategoryId())
                    .parentId(category.getParentId())
                    .displayName(category.getDisplayName())
                    .ordering(category.getOrdering())
                    .useYn(category.getUseYn())
                    .displayYn(category.getDisplayYn())
                    .build();
        }
    }

    @Getter
    public static class UpdateCategory {

        private Long categoryId;
        private Long parentId;
        private String displayName;
        private Long ordering;
        private String useYn;
        private String displayYn;

        @Builder
        public UpdateCategory(Long categoryId, Long parentId, String displayName, Long ordering, String useYn, String displayYn) {
            this.categoryId = categoryId;
            this.parentId = parentId;
            this.displayName = displayName;
            this.ordering = ordering;
            this.useYn = useYn;
            this.displayYn = displayYn;
        }

        public static UpdateCategory from(CategoryWrapper.UpdateCategory category) {
            return UpdateCategory.builder()
                    .categoryId(category.getCategoryId())
                    .parentId(category.getParentId())
                    .displayName(category.getDisplayName())
                    .ordering(category.getOrdering())
                    .useYn(category.getUseYn())
                    .displayYn(category.getDisplayYn())
                    .build();
        }
    }
}