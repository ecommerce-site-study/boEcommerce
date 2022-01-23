package com.teckstudy.book.domain.exhibition.repository;

import com.teckstudy.book.application.exhibition.dto.ExhibitionDto;
import com.teckstudy.book.application.exhibition.dto.SearchExhibitionDto;
import com.teckstudy.book.domain.exhibition.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * ExhibitionRepositoryCustom 추후 사용 예정
 */
@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Exhibition p SET p.useYn = :#{#searchExhibitionDto.toEntity().useYn}, p.name = :#{#searchExhibitionDto.toEntity().name}, " +
            "p.exhibitionType = :#{#searchExhibitionDto.toEntity().exhibitionType}, p.dateYn = :#{#searchExhibitionDto.toEntity().dateYn}, " +
            "p.image = :#{#searchExhibitionDto.toEntity().image}, p.description = :#{#searchExhibitionDto.toEntity().description}, " +
            "p.url = :#{#searchExhibitionDto.toEntity().url}, p.exhibitionStart = :#{#searchExhibitionDto.toEntity().exhibitionStart}, " +
            "p.exhibitionEnd = :#{#searchExhibitionDto.toEntity().exhibitionEnd}, p.bundleContentCnt = :#{#searchExhibitionDto.toEntity().bundleContentCnt} " +
            "WHERE p.exhibitionId = :id")
    void updateExhibition(@Param("searchExhibitionDto") SearchExhibitionDto searchExhibitionDto, @Param("id") Long id);
}