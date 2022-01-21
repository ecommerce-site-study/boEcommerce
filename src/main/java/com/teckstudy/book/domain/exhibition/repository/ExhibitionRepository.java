package com.teckstudy.book.domain.exhibition.repository;

import com.teckstudy.book.application.exhibition.dto.SearchExhibitionDto;
import com.teckstudy.book.domain.exhibition.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//public interface ExhibitionRepository extends JpaRepository<Exhibition, Long>, ExhibitionRepositoryCustom {
//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE Exhibition p SET p.useYn = :#{#exhibitionRequestDto.useYn}, p.name = :#{#exhibitionRequestDto.name}, " +
//            "p.exhibitionType = :#{#exhibitionRequestDto.exhibitionType}, p.dateYn = :#{#exhibitionRequestDto.dateYn}, " +
//            "p.image = :#{#exhibitionRequestDto.image}, p.description = :#{#exhibitionRequestDto.description}, " +
//            "p.url = :#{#exhibitionRequestDto.url}, p.exhibitionStart = :#{#exhibitionRequestDto.exhibitionStart}, " +
//            "p.exhibitionEnd = :#{#exhibitionRequestDto.exhibition_end}, p.bundleContentCnt = :#{#exhibitionRequestDto.bundleContentCnt} " +
//            "WHERE p.exhibitionId = :id")
//    void updateExhibition(@Param("exhibitionRequestDto") ExhibitionRequestDto exhibitionRequestDto, @Param("id")Long id);
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