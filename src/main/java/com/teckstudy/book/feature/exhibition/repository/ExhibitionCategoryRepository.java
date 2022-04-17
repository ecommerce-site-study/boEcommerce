package com.teckstudy.book.feature.exhibition.repository;

import com.teckstudy.book.feature.exhibition.ExhibitionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionCategoryRepository extends JpaRepository<ExhibitionCategory, Long> {
}