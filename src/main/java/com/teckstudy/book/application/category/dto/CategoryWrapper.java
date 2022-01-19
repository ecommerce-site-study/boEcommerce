package com.teckstudy.book.application.category.dto;

import com.teckstudy.book.domain.category.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <pre>
 * com.teckstudy.book.application.category.dto
 *      CategoryWrapper
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-01-20 오전 12:32
 */

public class CategoryWrapper {

    @Getter
    @NoArgsConstructor
    public static class CategoryDto {
        private Long categoryId;
        private String displayName;
        private Long parentId;
        private Long order;

        public CategoryDto(Long categoryId, String displayName, Long parentId, Long order) {
            this.categoryId = categoryId;
            this.displayName = displayName;
            this.parentId = parentId;
            this.order = order;
        }

        public static CategoryDto from(Category category) {
            return new CategoryDto(
                    category.categoryId(),
                    category.displayName(),
                    category.parentId(),
                    category.order()
            );
        }

        public boolean isRootParent() {
            return Objects.isNull(parentId);
        }
    }

    @Getter
    @NoArgsConstructor
    public static class LayerCategoryDto {
        private Long categoryId;
        private Long parentId;
        private String displayName;
        private Long order;
        private boolean hasSubCategories;
        private List<LayerCategoryDto> subCategories;

        @Builder
        public LayerCategoryDto(Long categoryId, Long parentId, String displayName, Long order, boolean hasSubCategories, List<LayerCategoryDto> subCategories) {
            this.categoryId = categoryId;
            this.parentId = parentId;
            this.displayName = displayName;
            this.order = order;
            this.hasSubCategories = hasSubCategories;
            this.subCategories = subCategories;
        }


        public static LayerCategoryDto hasNotChildLayerCategory(CategoryDto category) {
            return LayerCategoryDto.builder()
                    .categoryId(category.getCategoryId())
                    .parentId(category.getParentId())
                    .displayName(category.getDisplayName())
                    .order(category.getOrder())
                    .hasSubCategories(false)
                    .subCategories(Collections.emptyList())
                    .build();
        }

        public static LayerCategoryDto hasChildLayerCategory(CategoryDto category, List<LayerCategoryDto> children){
            return LayerCategoryDto.builder()
                    .categoryId(category.getCategoryId())
                    .parentId(category.getParentId())
                    .displayName(category.getDisplayName())
                    .order(category.getOrder())
                    .hasSubCategories(true)
                    .subCategories(children)
                    .build();
        }

        public static LayerCategoryDto bundle(CategoryDto parent, List<CategoryDto> categories, List<CategoryDto> matchCategories) {
            if (matchCategories.size() == 0) return hasNotChildLayerCategory(parent);

            List<LayerCategoryDto> children = matchCategories
                    .stream()
                    .map(v ->
                            bundle(
                                    v,
                                    categories,
                                    categories
                                            .stream()
                                            .filter(c -> c.getParentId() == v.getCategoryId()
                                            ).collect(Collectors.toList())
                            ))
                    .collect(Collectors.toList());
            return hasChildLayerCategory(parent, children);
        }
    }

}
