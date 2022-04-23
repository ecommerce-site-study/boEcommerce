package com.teckstudy.book.feature.category.infra.rdb;

import com.teckstudy.book.feature.category.domain.Category;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * com.teckstudy.book.feature.category.infra.rdb
 *      CategoryQueryCustom
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-23 오후 5:46
 */

public interface CategoryQueryCustom {

    List<Category> findCategories();

    Optional<Category> findCategoryByCategoryId(Long categoryId);

    void deleteCategory(Category category);
}
