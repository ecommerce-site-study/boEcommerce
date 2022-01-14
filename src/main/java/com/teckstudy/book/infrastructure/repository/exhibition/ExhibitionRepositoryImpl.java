//package com.teckstudy.book.infrastructure.repository.exhibition;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.teckstudy.book.domain.exhibition.repository.ExhibitionRepositoryCustom;
//import com.teckstudy.book.ui.exhibition.ContentsTypeResponseDto;
//import com.teckstudy.book.ui.exhibition.ExhibitionResponseDto;
//import com.teckstudy.book.ui.exhibition.QContentsTypeResponseDto;
//import com.teckstudy.book.ui.exhibition.QExhibitionResponseDto;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//import static com.teckstudy.book.domain.exhibition.QContentsType.contentsType;
//import static com.teckstudy.book.domain.exhibition.QExhibition.exhibition;
//
//
//@Repository
//public class ExhibitionRepositoryImpl implements ExhibitionRepositoryCustom {
//
//    private final EntityManager em;
//    private final JPAQueryFactory queryFactory;
//
//    public ExhibitionRepositoryImpl(EntityManager em) {
//        this.em = em;
//        this.queryFactory = new JPAQueryFactory(em);
//    }
//
//    public List<ExhibitionResponseDto> findExhibition(Long id) throws Exception  {
//        return queryFactory
//                .select(new QExhibitionResponseDto(
//                        exhibition.exhibition_sn.as("exhibition_sn")
//                        , exhibition.use_yn.as("product_sn")
//                        , exhibition.name.as("plus_price")
//                        , exhibition.exhibitionType.as("exhibitionType")
//                        , exhibition.date_yn.as("date_yn")
//                        , exhibition.image.as("image")
//                        , exhibition.description.as("description")
//                        , exhibition.url.as("url")
//                        , exhibition.exhibition_start.as("exhibition_start")
//                        , exhibition.exhibition_end.as("exhibition_end")
//                        , exhibition.bundleContentCnt.as("bundleContentCnt")
//                ))
//                .from(exhibition)
//                .where(exhibition.exhibition_sn.eq(id))
//                .fetch();
//    }
//
//    public List<ContentsTypeResponseDto> findContents(Long id) throws Exception  {
//        return queryFactory
//                .select(new QContentsTypeResponseDto(
//                        exhibition.exhibition_sn.as("exhibition_sn")
//                        , contentsType.content_sn.as("content_sn")
//                        , contentsType.contentEnum.as("contentEnum")
//                        , contentsType.contentCnt.as("contentCnt")
//                ))
//                .from(contentsType)
//                .where(contentsType.exhibition.exhibition_sn.eq(id))
//                .fetch();
//    }
//
//}
