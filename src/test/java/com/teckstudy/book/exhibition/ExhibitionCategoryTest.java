package com.teckstudy.book.exhibition;

import com.teckstudy.book.entity.Exhibition;
import com.teckstudy.book.entity.ExhibitionCategory;
import com.teckstudy.book.lib.common.util.BoCategoryValidation;
import com.teckstudy.book.lib.common.util.BoValidation;
import com.teckstudy.book.exhibition.repository.ExhibitionCategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@Transactional
public class ExhibitionCategoryTest {

    @Autowired
    ExhibitionCategoryRepository exhibitionCategoryRepository;

    @Test
    @DisplayName("메뉴명은 20자를 넘으면 Exception을 발생시킨다.")
    public void twentyKorCharMenuTest() {
        //given
        String keyWord = "데이터 검증단어 글자수 초과합니다. 20자 넘어감";
        //when

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BoValidation().nameValidation(keyWord));
    }

    @Test
    @DisplayName("최소 1개의 카테고리가 없으면 Exception을 발생시킨다.")
    public void categoryMinTest() {
        //given
        List<String> categories = new ArrayList<>();

        //when

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BoCategoryValidation().categoryValidation(categories));
    }

    @Test
    @DisplayName("카테고리가 10개를 넘어으면 Exception을 발생시킨다.")
    public void categoryMaxTest() {
        //given
        List<String> categories = new ArrayList<>();
        String category = "카테고리명";

        //when
        for (int i = 1; i <= 11; i++) {
            categories.add(category + i);
        }

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BoCategoryValidation().categoryValidation(categories));
    }

    @Test
    @DisplayName("[2B] 카테고리명을 수정하면 카테고리명이 변경된다")
    public void categoryNameUpdateTest() {
        //given
        //when
        //then
    }
    
    @Test
    @DisplayName("[2B] 카테고리명이 1자 미만이거나 20자를 초과하면 에러를 발생")
    public void categoryNameValidationTest() {
        //given
        
        //when
        
        //then
    }

    @Test
    @DisplayName("[2C, 2D] 카테고리 생성시에 메뉴 노출 여부와 메뉴 사용 여부는 'N'으로 설정된다")
    public void creatingCategorySettingShowAndUseIsNTest () {
        //given

        //when

        //then
    }

    @Test
    @DisplayName("[2C, 2D] 메뉴 사용 여부가 ‘N’이면 자동으로 메뉴 노출 여부가 N으로 변경된다.")
    public void categoryUseStatusIsNChangeableShowStatusIsNTest() {
        //given

        //when

        //then
    }

    @Test
    @DisplayName("[2C, 2D] 메뉴 사용 여부가 'Y'라면 메뉴 노출 여부가 'Y' 또는 'N'으로 변경될 수 있다")
    public void categoryUseStatusIsYChangeableShowStatusIsYNTest() {
        //given
        
        //when
        
        //then
    }

    @Test
    @DisplayName("[2E, 2F] 텍스트로 들어올경우 글자수가 1자 미만이거나 20자를 초과하면 에러를 발생한다.")
    public void exposureTypeTextValidationTest() {
        //given

        //when

        //then
    }
    
    @Test
    @DisplayName("이미지로 들어올 경우 파일 사이즈 10MB(변동 가능), 확장자 `JPEG`,`JPG`,`GIF`,`PNG`만 가능")
    public void exposureTypeImageValidationTest() {
        //given
        
        //when
        
        //then
    }

    // todo: 전시코너에 대한 TestCode 작성필요
//    @Test
//    @DisplayName()
//    public void () {
//        //given
//
//        //when
//
//        //then
//    }
}