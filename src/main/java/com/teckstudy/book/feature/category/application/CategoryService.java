package com.teckstudy.book.feature.category.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teckstudy.book.feature.category.application.dto.Categories;
import com.teckstudy.book.feature.category.application.dto.CategoryWrapper;
import com.teckstudy.book.core.types.YesNoStatus;
import com.teckstudy.book.feature.category.domain.Category;
import com.teckstudy.book.feature.category.domain.CategoryDataprovider;
import com.teckstudy.book.feature.category.infra.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryValidator categoryValidator;
    private final CategoryDataprovider categoryDataprovider;

    @Transactional(readOnly = true)
    public List<CategoryWrapper.LayerCategoryDto> searchCategories() throws JsonProcessingException {

        Categories categories = Categories.from(categoryDataprovider.findCategories());
        return  categories.layerList();
    }

    @Transactional
    public CategoryWrapper.PersistCategory addCategory(CategoryWrapper.PersistCategory persistCategory) throws IllegalAccessException {

        // 1 category. Enum 검증 validation 추가 필요
        persistCategory.validate(categoryValidator);

        if(persistCategory.isParentId()) existingParentCategory(persistCategory.getParentId());
        Category save = categoryDataprovider.save(persistCategory.toEntity());

       return CategoryWrapper.PersistCategory.from(save);
    }

    @Transactional
    public CategoryWrapper.UpdateCategory updateCategory(CategoryWrapper.UpdateCategory updateCategory) throws IllegalAccessException {

        updateCategory.validate(categoryValidator);
        Category category = existingCategory(
                categoryDataprovider.findCategoryByCategoryId(updateCategory.getCategoryId()),
                "존재하지 않는 카테고리입니다."
        );
        category.update(
                updateCategory.getDisplayName(),
                updateCategory.getParentId(),
                updateCategory.getOrdering(),
                YesNoStatus.valueOf(updateCategory.getUseYn()),
                YesNoStatus.valueOf(updateCategory.getDisplayYn())
        );

        return CategoryWrapper.UpdateCategory.from(category);
    }

    @Transactional
    public void deleteCategory(Long categoryId) throws IllegalAccessException {

        Category category = existingCategory(
                categoryDataprovider.findCategoryByCategoryId(categoryId),
                String.format("[%s] 해당 카테고리는 존재하지 않습니다.", categoryId)
        );
        categoryDataprovider.delete(category);
    }

    private void existingParentCategory(Long parentId) throws IllegalAccessException {
        Optional<Category> categoryById = categoryDataprovider.findCategoryByCategoryId(parentId);
        existingCategory(categoryById,"존재하지 않는 ParentId 입니다." );
    }

    private Category existingCategory(Optional<Category> category, String msg) throws IllegalAccessException {
        // message 추후 수정 필요
        if(!category.isPresent()) throw new IllegalArgumentException(msg);
        return category.get();
    }

}