package com.teckstudy.book.feature.category.infra;

import com.teckstudy.book.feature.category.domain.Category;
import com.teckstudy.book.feature.category.domain.CategoryDataprovider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * com.teckstudy.book.feature.category.infra
 *      CategoryDataproviderImpl
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-23 오후 5:44
 */

@Component
@RequiredArgsConstructor
public class CategoryDataproviderImpl implements CategoryDataprovider {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findCategories() {
        return categoryRepository.findCategories();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findCategoryByCategoryId(Long categoryId) {
        return categoryRepository.findCategoryByCategoryId(categoryId);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.deleteCategory(category);
    }
}
