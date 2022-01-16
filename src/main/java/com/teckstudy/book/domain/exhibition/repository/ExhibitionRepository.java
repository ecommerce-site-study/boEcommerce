package com.teckstudy.book.domain.exhibition.repository;

import com.teckstudy.book.domain.exhibition.Exhibition;
import com.teckstudy.book.ui.exhibition.dto.ExhibitionRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Long>, ExhibitionRepositoryCustom {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Exhibition p SET p.useYn = :#{#exhibitionRequestDto.useYn}, p.name = :#{#exhibitionRequestDto.name}, " +
            "p.exhibitionType = :#{#exhibitionRequestDto.exhibitionType}, p.dateYn = :#{#exhibitionRequestDto.dateYn}, " +
            "p.image = :#{#exhibitionRequestDto.image}, p.description = :#{#exhibitionRequestDto.description}, " +
            "p.url = :#{#exhibitionRequestDto.url}, p.exhibitionStart = :#{#exhibitionRequestDto.exhibitionStart}, " +
            "p.exhibitionEnd = :#{#exhibitionRequestDto.exhibition_end}, p.bundleContentCnt = :#{#exhibitionRequestDto.bundleContentCnt} " +
            "WHERE p.exhibitionId = :id")
    void updateExhibition(@Param("exhibitionRequestDto") ExhibitionRequestDto exhibitionRequestDto, @Param("id")Long id);
}