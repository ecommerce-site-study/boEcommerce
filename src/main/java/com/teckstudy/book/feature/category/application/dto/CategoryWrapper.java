package com.teckstudy.book.feature.category.application.dto;

import com.teckstudy.book.feature.category.application.CategoryValidator;
import com.teckstudy.book.core.types.YesNoStatus;
import com.teckstudy.book.feature.category.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public static class SearchCategory {
        private Long categoryId;
        private String displayName;
        private Long parentId;
        private Long ordering;
        private String useYn;
        private String displayYn;

        @Builder
        public SearchCategory(Long categoryId, String displayName, Long parentId, Long ordering, String useYn, String displayYn) {
            this.categoryId = categoryId;
            this.displayName = displayName;
            this.parentId = parentId;
            this.ordering = ordering;
            this.useYn = useYn;
            this.displayYn = displayYn;
        }

        public static SearchCategory from(Category category) {
            return SearchCategory.builder()
                    .categoryId(category.categoryId())
                    .displayName(category.displayName())
                    .parentId(category.parentId())
                    .ordering(category.ordering())
                    .useYn(category.useYn())
                    .displayYn(category.displayYn())
                    .build();
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
        private Long ordering;
        private boolean hasSubCategories;
        private List<LayerCategoryDto> subCategories;

        @Builder
        public LayerCategoryDto(Long categoryId, Long parentId, String displayName, Long ordering, boolean hasSubCategories, List<LayerCategoryDto> subCategories) {
            this.categoryId = categoryId;
            this.parentId = parentId;
            this.displayName = displayName;
            this.ordering = ordering;
            this.hasSubCategories = hasSubCategories;
            this.subCategories = subCategories;
        }


        public static LayerCategoryDto hasNotChildLayerCategory(SearchCategory category) {
            return LayerCategoryDto.builder()
                    .categoryId(category.getCategoryId())
                    .parentId(category.getParentId())
                    .displayName(category.getDisplayName())
                    .ordering(category.getOrdering())
                    .hasSubCategories(false)
                    .subCategories(Collections.emptyList())
                    .build();
        }

        public static LayerCategoryDto hasChildLayerCategory(SearchCategory category, List<LayerCategoryDto> children){
            return LayerCategoryDto.builder()
                    .categoryId(category.getCategoryId())
                    .parentId(category.getParentId())
                    .displayName(category.getDisplayName())
                    .ordering(category.getOrdering())
                    .hasSubCategories(true)
                    .subCategories(children)
                    .build();
        }

        public static LayerCategoryDto bundle(SearchCategory parent, List<SearchCategory> categories, List<SearchCategory> matchCategories) {
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


    @Getter
    @NoArgsConstructor
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

        public static PersistCategory from(Category category) {
            return PersistCategory.builder()
                    .categoryId(category.categoryId())
                    .parentId(category.parentId())
                    .displayName(category.displayName())
                    .ordering(category.ordering())
                    .useYn(category.useYn())
                    .displayYn(category.displayYn())
                    .build();
        }

        public Category toEntity() {
            return Category.newCategory(
                    this.displayName,
                    this.parentId,
                    this.ordering,
                    YesNoStatus.valueOf(this.useYn),
                    YesNoStatus.valueOf(this.displayYn)
            );
        }

        public boolean isParentId() {
            return Objects.nonNull(parentId);
        }

        public void validate(CategoryValidator validator) {
            validator.validate(this);
        }
    }

    @Getter
    @NoArgsConstructor
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

        public static UpdateCategory from(Category category) {
            return UpdateCategory.builder()
                    .categoryId(category.categoryId())
                    .parentId(category.parentId())
                    .displayName(category.displayName())
                    .ordering(category.ordering())
                    .useYn(category.useYn())
                    .displayYn(category.displayYn())
                    .build();
        }

        public void validate(CategoryValidator validator) {
            validator.validate(this);
        }
    }
}
