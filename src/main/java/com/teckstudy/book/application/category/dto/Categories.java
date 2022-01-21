package com.teckstudy.book.application.category.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teckstudy.book.domain.category.Category;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * com.teckstudy.book.application.category.dto
 *      Categories
 * </pre>
 * <p>
 * 1급 컬렉션
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-01-20 오전 12:36
 */

public class Categories {

    private final List<CategoryWrapper.SearchCategory> categories;

    private Categories(List<CategoryWrapper.SearchCategory> categories) {
        this.categories = categories;
    }

    public static Categories from(List<Category> categories) {
        return new Categories(convertWrapper(categories));
    }

    private static List<CategoryWrapper.SearchCategory> convertWrapper(List<Category> categories) {
        return categories
                .stream()
                .map(CategoryWrapper.SearchCategory::from)
                .collect(Collectors.toList());
    }

    public List<CategoryWrapper.SearchCategory> list() {
        return this.categories;
    }

    public List<CategoryWrapper.LayerCategoryDto> layerList() {
        return bundleSubCategories();
    }

    private List<CategoryWrapper.LayerCategoryDto> bundleSubCategories() {
        return this.categories.stream()
                .filter(CategoryWrapper.SearchCategory::isRootParent)
                .map(v ->
                        CategoryWrapper.LayerCategoryDto.bundle(
                                v,
                                this.categories,
                                this.categories
                                        .stream()
                                        .filter(c -> c.getParentId() == v.getCategoryId()
                                        ).collect(Collectors.toList())
                        ))
                .collect(Collectors.toList());
    }
}
