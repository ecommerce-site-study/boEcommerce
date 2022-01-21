package com.teckstudy.book.domain.exhibition.repository;

import com.teckstudy.book.domain.exhibition.ContentsType;
import com.teckstudy.book.domain.exhibition.types.ContentEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentsTypeRepository extends JpaRepository<ContentsType, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE ContentsType p SET p.contentEnum = :contentEnum, p.contentCnt = :contentCnt WHERE p.contentId = :id")
    void updateContents(@Param("id")Long id, @Param("contentEnum") ContentEnum contentEnum, @Param("contentCnt") int contentCnt);

}