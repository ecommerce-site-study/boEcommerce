package com.teckstudy.book.feature.domain.exhibition.repository;

import com.teckstudy.book.feature.domain.exhibition.ExhibitionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionCategoryRepository extends JpaRepository<ExhibitionCategory, Long> {
}