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

    private final List<CategoryWrapper.CategoryDto> categories;

    private Categories(List<CategoryWrapper.CategoryDto> categories) {
        this.categories = categories;
    }

    public static Categories from(List<Category> categories) {
        return new Categories(convertWrapper(categories));
    }

    private static List<CategoryWrapper.CategoryDto> convertWrapper(List<Category> categories) {
        return categories
                .stream()
                .map(CategoryWrapper.CategoryDto::from)
                .collect(Collectors.toList());
    }

    public static Categories dummy() throws JsonProcessingException {
        String dummyData = "[\n" +
                "  {\n" +
                "    \"categoryId\": 1,\n" +
                "    \"displayName\": \"category1\",\n" +
                "    \"parentId\": null,\n" +
                "    \"order\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"categoryId\": 2,\n" +
                "    \"displayName\": \"category2\",\n" +
                "    \"parentId\": null,\n" +
                "    \"order\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"categoryId\": 3,\n" +
                "    \"displayName\": \"category3\",\n" +
                "    \"parentId\": null\n" +
                "  },\n" +
                "  {\n" +
                "    \"categoryId\": 4,\n" +
                "    \"displayName\": \"category4\",\n" +
                "    \"parentId\": 1,\n" +
                "    \"order\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"categoryId\": 5,\n" +
                "    \"displayName\": \"category5\",\n" +
                "    \"parentId\": 2,\n" +
                "    \"order\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"categoryId\": 6,\n" +
                "    \"displayName\": \"category6\",\n" +
                "    \"parentId\": 4\n" +
                "  },\n" +
                "  {\n" +
                "    \"categoryId\": 7,\n" +
                "    \"displayName\": \"category7\",\n" +
                "    \"parentId\": 4\n" +
                "  }\n" +
                "]";
        ObjectMapper obm = new ObjectMapper();
        List<Category> categoryDtos = obm.readValue(dummyData, new TypeReference<List<Category>>(){} );
        return Categories.from(categoryDtos);
    }

    public List<CategoryWrapper.CategoryDto> list() {
        return this.categories;
    }

    public List<CategoryWrapper.LayerCategoryDto> layerList() {
        return bundleSubCategories();
    }

    private List<CategoryWrapper.LayerCategoryDto> bundleSubCategories() {
        return this.categories.stream()
                .filter(CategoryWrapper.CategoryDto::isRootParent)
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
