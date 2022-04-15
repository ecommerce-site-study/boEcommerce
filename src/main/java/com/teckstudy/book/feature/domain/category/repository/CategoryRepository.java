package com.teckstudy.book.feature.domain.category.repository;

import com.teckstudy.book.feature.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryByCategoryId(Long categoryId);

}