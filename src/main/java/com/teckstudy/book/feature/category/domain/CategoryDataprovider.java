package com.teckstudy.book.feature.category.domain;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * com.teckstudy.book.feature.category.domain
 *      CategoryDataprovider
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-23 오후 5:44
 */

public interface CategoryDataprovider {

    public List<Category> findCategories() ;

    Category save(Category toEntity);

    Optional<Category> findCategoryByCategoryId(Long categoryId);

    void delete(Category category);
}
