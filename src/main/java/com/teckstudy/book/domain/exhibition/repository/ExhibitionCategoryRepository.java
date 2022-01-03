package com.teckstudy.book.domain.exhibition.repository;

import com.teckstudy.book.domain.exhibition.ExhibitionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitionCategoryRepository extends JpaRepository<ExhibitionCategory, Long> {
}