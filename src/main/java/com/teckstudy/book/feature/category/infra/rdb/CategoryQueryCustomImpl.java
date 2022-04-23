package com.teckstudy.book.feature.category.infra.rdb;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teckstudy.book.feature.auth_verify.domain.QAuthVerify;
import com.teckstudy.book.feature.category.QCategory;
import com.teckstudy.book.feature.category.domain.Category;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.teckstudy.book.feature.auth_verify.domain.QAuthVerify.authVerify;

/**
 * <pre>
 * com.teckstudy.book.feature.category.infra.rdb
 *      CategoryQueryCustom
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-23 오후 5:46
 */

@RequiredArgsConstructor
public class CategoryQueryCustomImpl implements CategoryQueryCustom {

    private final JPAQueryFactory queryFactory;
    private final QCategory qCategory = QCategory.category;

    @Override
    public List<Category> findCategories() {
        return queryFactory
                .selectFrom(qCategory)
                .fetch();
    }

    @Override
    public Optional<Category> findCategoryByCategoryId(Long categoryId) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(qCategory)
                        .where(qCategory.categoryId.eq(categoryId))
                        .fetchOne()
        );
    }

    @Override
    public void deleteCategory(Category category) {
        queryFactory.delete(qCategory)
                .where(qCategory.eq(category))
                .execute();

    }
}
