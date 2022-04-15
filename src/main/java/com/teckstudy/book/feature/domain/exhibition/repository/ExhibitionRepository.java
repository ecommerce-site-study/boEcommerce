package com.teckstudy.book.feature.domain.exhibition.repository;

import com.teckstudy.book.feature.domain.exhibition.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ExhibitionRepositoryCustom 추후 사용 예정
 */
@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {

}