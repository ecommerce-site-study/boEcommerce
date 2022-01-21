package com.teckstudy.book.ui.category;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teckstudy.book.application.category.CategoryService;
import com.teckstudy.book.application.category.dto.CategoryWrapper;
import com.teckstudy.book.domain.category.Category;
import com.teckstudy.book.lib.common.base.SuccessResponse;
import com.teckstudy.book.ui.category.dto.CategoryRequest;
import com.teckstudy.book.ui.category.dto.CategoryResponse;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<SuccessResponse<List<CategoryResponse.LayerCategory>>> searchCategories() throws JsonProcessingException {
        List<CategoryWrapper.LayerCategoryDto> layerCategories = categoryService.searchCategories();

        return ResponseEntity.ok(SuccessResponse.of(200L, "success", layerCategories.stream().map(CategoryResponse.LayerCategory::from).collect(Collectors.toList())));
    }


    @PostMapping("/api/categories")
    public ResponseEntity<SuccessResponse<CategoryResponse.PersistCategory>> registerCategory(@RequestBody CategoryRequest.RegisterCategory categoryRequest) throws IllegalAccessException {
        CategoryWrapper.PersistCategory category = categoryService.addCategory(categoryRequest.toWrapper());

        return ResponseEntity.ok(SuccessResponse.of(201L, "Create Category", CategoryResponse.PersistCategory.from(category)));
    }

    @PatchMapping("/api/categories/{categoryId}")
    public ResponseEntity<SuccessResponse<CategoryResponse.UpdateCategory>> updateCategory(@PathVariable(name = "categoryId") Long categoryId, @RequestBody CategoryRequest.UpdateCategory categoryRequest) throws IllegalAccessException {

        CategoryWrapper.UpdateCategory category = categoryService.updateCategory(categoryRequest.toWrapper(categoryId));

        return ResponseEntity.ok(SuccessResponse.of(200L, "Update Category", CategoryResponse.UpdateCategory.from(category)));
    }


    @DeleteMapping("/api/categories/{categoryId}")
    public ResponseEntity<SuccessResponse<String>> deleteCategory(@PathVariable(name = "categoryId") Long categoryId) throws IllegalAccessException {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(SuccessResponse.of(200L, "Delete Category", ""));
    }
}