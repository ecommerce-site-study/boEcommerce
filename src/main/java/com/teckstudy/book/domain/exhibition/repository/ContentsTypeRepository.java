package com.teckstudy.book.domain.exhibition.repository;

import com.teckstudy.book.domain.exhibition.ContentsType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentsTypeRepository extends JpaRepository<ContentsType, Long> {

//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE ContentsType p SET p.contentEnum = :contentEnum, p.contentCnt = :contentCnt WHERE p.content_sn = :id")
//    void updateContents(@Param("id")Long id, @Param("contentEnum") ContentEnum contentEnum, @Param("contentCnt") int contentCnt);

}