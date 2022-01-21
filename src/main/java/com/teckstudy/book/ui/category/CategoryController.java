package com.teckstudy.book.ui.category;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teckstudy.book.application.category.CategoryService;
import com.teckstudy.book.application.category.dto.CategoryWrapper;
import com.teckstudy.book.lib.common.base.SuccessResponse;
import com.teckstudy.book.ui.category.dto.CategoryRequest;
import com.teckstudy.book.ui.category.dto.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 레이어별로 DTO를 가져감
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/api/categories")
    public ResponseEntity<SuccessResponse<List<CategoryWrapper.LayerCategoryDto>>> searchCategories () throws JsonProcessingException {
        List<CategoryWrapper.LayerCategoryDto> layerCategories = categoryService.searchCategories();


        return ResponseEntity.ok(new SuccessResponse(200L, "success",
                layerCategories.stream().map(CategoryResponse.LayerCategory::from).collect(Collectors.toList())));
    }


    @PostMapping("/api/categories")
    public void registerCategory(@RequestBody CategoryRequest.RegisterCategory category) {

        categoryService.persistCategory(category.toWrapper());

    }


}