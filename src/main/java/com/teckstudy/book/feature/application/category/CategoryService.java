package com.teckstudy.book.feature.application.category;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teckstudy.book.feature.application.category.dto.Categories;
import com.teckstudy.book.feature.application.category.dto.CategoryWrapper;
import com.teckstudy.book.feature.domain.base.types.YesNoStatus;
import com.teckstudy.book.feature.domain.category.Category;
import com.teckstudy.book.feature.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryValidator categoryValidator;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryWrapper.LayerCategoryDto> searchCategories() throws JsonProcessingException {

        Categories categories = Categories.from(categoryRepository.findAll());
        return  categories.layerList();
    }

    @Transactional
    public CategoryWrapper.PersistCategory addCategory(CategoryWrapper.PersistCategory persistCategory) throws IllegalAccessException {

        // 1 category. Enum 검증 validation 추가 필요
        persistCategory.validate(categoryValidator);

        if(persistCategory.isParentId()) existingParentCategory(persistCategory.getParentId());
        Category save = categoryRepository.save(persistCategory.toEntity());

       return CategoryWrapper.PersistCategory.from(save);
    }

    @Transactional
    public CategoryWrapper.UpdateCategory updateCategory(CategoryWrapper.UpdateCategory updateCategory) throws IllegalAccessException {

        updateCategory.validate(categoryValidator);
        Category category = existingCategory(
                categoryRepository.findCategoryByCategoryId(updateCategory.getCategoryId()),
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
                categoryRepository.findCategoryByCategoryId(categoryId),
                String.format("[%s] 해당 카테고리는 존재하지 않습니다.", categoryId)
        );
        categoryRepository.delete(category);
    }

    private void existingParentCategory(Long parentId) throws IllegalAccessException {
        Optional<Category> categoryById = categoryRepository.findCategoryByCategoryId(parentId);
        existingCategory(categoryById,"존재하지 않는 ParentId 입니다." );
    }

    private Category existingCategory(Optional<Category> category, String msg) throws IllegalAccessException {
        // message 추후 수정 필요
        if(!category.isPresent()) throw new IllegalArgumentException(msg);
        return category.get();
    }

}