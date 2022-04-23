package com.teckstudy.book.feature.category.infra;

import com.teckstudy.book.feature.category.domain.Category;
import com.teckstudy.book.feature.category.infra.rdb.CategoryQueryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CategoryQueryCustom, JpaRepository<Category, Long> {
}