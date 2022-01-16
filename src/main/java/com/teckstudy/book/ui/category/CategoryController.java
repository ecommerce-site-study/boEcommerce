package com.teckstudy.book.ui.category;

import com.teckstudy.book.application.category.dto.CategoryDto;
import com.teckstudy.book.application.category.CategoryService;
import com.teckstudy.book.ui.category.dto.CategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 레이어별로 DTO를 가져감
 */
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/api/category")
    public List<CategoryResponseDto> searchCategoriesApple () {
        List<CategoryDto> responseDtoList = categoryService.findAllDesc();

        return responseDtoList.stream()
                .map(CategoryResponseDto::from)
                .collect(Collectors.toList());
    }


//    @GetMapping("/api/B/category")
//    public List<CategoryResponseDtoB> searchCategoriesFaceBook (CategoryRequestDto requestDto) {
//        List<CategoryDto> responseDtoList = categoryService.findAllDesc(requestDto.toWrapper());
//
//        return responseDtoList.stream()
//                .map(CategoryResponseDtoB::from)
//                .collect(Collectors.toList());
//    }

}