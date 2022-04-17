package com.teckstudy.book.feature.exhibition.repository;

import com.teckstudy.book.feature.exhibition.ContentsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentsTypeRepository extends JpaRepository<ContentsType, Long> {

}