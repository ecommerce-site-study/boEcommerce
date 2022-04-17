package com.teckstudy.book.feature.exhibition.application;

import com.teckstudy.book.feature.exhibition.application.dto.ExhibitionDto;
import com.teckstudy.book.feature.exhibition.application.dto.SearchExhibitionDto;
import com.teckstudy.book.feature.exhibition.ContentsType;
import com.teckstudy.book.feature.exhibition.Exhibition;
import com.teckstudy.book.feature.exhibition.repository.ContentsTypeRepository;
import com.teckstudy.book.feature.exhibition.repository.ExhibitionRepository;
import com.teckstudy.book.feature.exhibition.types.ContentEnum;
import com.teckstudy.book.core.lib.common.util.BoValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    private final ContentsTypeRepository contentsTypeRepository;

    /**
     * 전시카테고리 조회
     *
     * @param id
     * @return
     */
    // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선됨.
    @Transactional(readOnly = true)
    public ExhibitionDto findById(Long id) {
        Exhibition exhibition = exhibitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("전시카테고리 정보가 없습니다. id=" + id));

        return ExhibitionDto.from(exhibition);
    }

    /**
     * 전시카테고리 등록
     *
     * @param searchExhibitionDto
     * @return
     */
    @Transactional
    public ExhibitionDto exhibitionSave(SearchExhibitionDto searchExhibitionDto) {

        duplicateCheck(searchExhibitionDto);
        Exhibition exhibition = exhibitionRepository.save(searchExhibitionDto.toEntity());

        // 컨텐츠타입 적재
        for (ContentsType contentsTypes : searchExhibitionDto.toEntity().getContentsType()) {
            contentsTypeRepository.save(searchExhibitionDto.toContentsEntity(contentsTypes, exhibition));
        }

        return ExhibitionDto.from(exhibition);
    }


    @Transactional
    public ExhibitionDto exhibitionUpdate(Long id, SearchExhibitionDto searchExhibitionDto) {
        Exhibition exhibition = exhibitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("전시카테고리 정보가 없습니다. id=" + id));

        duplicateCheck(searchExhibitionDto);

        exhibition.updateExhibition(
                searchExhibitionDto.getUseYn(),
                searchExhibitionDto.getName(),
                searchExhibitionDto.getExhibitionType(),
                searchExhibitionDto.getDateYn(),
                searchExhibitionDto.getImage(),
                searchExhibitionDto.getDescription(),
                searchExhibitionDto.getUrl(),
                searchExhibitionDto.getExhibitionStart(),
                searchExhibitionDto.getExhibitionEnd(),
                searchExhibitionDto.getBundleContentCnt()
        );

        exhibition.getContentsType()
                .stream()
                .forEach(v -> {
                    if(!searchExhibitionDto.getContentsList().contains(v.getContentId())) return;
                    Optional<ContentsType> contentsTypeById = searchExhibitionDto.findContentsTypeById(v.getContentId());

                    ContentsType contentsType = searchExhibitionDto.findContentsTypeById(v.getContentId()).get();
                    v.updateContentsType(contentsType.getContentEnum(), contentsType.getContentCnt(), contentsType.getExhibition());
                });


        return ExhibitionDto.from(exhibition);
    }

    /**
     * 벨리데이션 체크
     *
     * @param searchExhibitionDto
     */
    private void duplicateCheck(SearchExhibitionDto searchExhibitionDto) {
        Map<ContentEnum, Integer> contentMap = new LinkedHashMap<>();

        for (ContentsType contentsTypes : searchExhibitionDto.toEntity().getContentsType()) {
            contentMap.put(contentsTypes.getContentEnum(), contentMap.getOrDefault(contentsTypes.getContentEnum(), 0) + 1);
        }

        new BoValidation(searchExhibitionDto, contentMap);
    }
}