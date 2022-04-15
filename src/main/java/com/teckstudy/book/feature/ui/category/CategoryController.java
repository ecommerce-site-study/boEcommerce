package com.teckstudy.book.feature.ui.category;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teckstudy.book.feature.application.category.CategoryService;
import com.teckstudy.book.feature.application.category.dto.CategoryWrapper;
import com.teckstudy.book.feature.lib.common.base.SuccessResponse;
import com.teckstudy.book.feature.lib.common.base.BaseAbstractController;
import com.teckstudy.book.feature.ui.category.dto.CategoryRequest;
import com.teckstudy.book.feature.ui.category.dto.CategoryResponse;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Api(value = "CategoryController v1")
@RestController
@RequiredArgsConstructor
public class CategoryController extends BaseAbstractController {

    private final CategoryService categoryService;

    @ApiOperation(value = "[카테고리] 조회", notes = "[카테고리] 조회하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "카테고리 조회 성공"),
            @ApiResponse(code = 400, message = "잘못된 접근"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/api/categories")
    public ResponseEntity<SuccessResponse<List<CategoryResponse.LayerCategory>>> searchCategories() throws JsonProcessingException {
        List<CategoryWrapper.LayerCategoryDto> layerCategories = categoryService.searchCategories();

        return ResponseEntity.ok(SuccessResponse.of(200L, "success", layerCategories.stream().map(CategoryResponse.LayerCategory::from).collect(Collectors.toList())));
    }

    @ApiOperation(value = "[카테고리] 등록", notes = "[카테고리] 등록하기")
    @ApiResponses({
            @ApiResponse(code = 201, message = "카테고리 등록 성공"),
            @ApiResponse(code = 400, message = "잘못된 접근"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/api/categories")
    public ResponseEntity<SuccessResponse<CategoryResponse.PersistCategory>> registerCategory(@RequestBody CategoryRequest.RegisterCategory categoryRequest) throws IllegalAccessException {
        CategoryWrapper.PersistCategory category = categoryService.addCategory(categoryRequest.toWrapper());

        return ResponseEntity.ok(SuccessResponse.of(201L, "Create Category", CategoryResponse.PersistCategory.from(category)));
    }

    @ApiOperation(value = "[카테고리] 수정", notes = "[카테고리] 수정하기")
    @ApiImplicitParam(name = "categoryId", value = "카테고리 고유 ID", required = true, paramType = "path", dataType = "long")
    @ApiResponses({
            @ApiResponse(code = 200, message = "카테고리 수정 성공"),
            @ApiResponse(code = 400, message = "잘못된 접근"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PatchMapping("/api/categories/{categoryId}")
    public ResponseEntity<SuccessResponse<CategoryResponse.UpdateCategory>> updateCategory(@PathVariable(name = "categoryId") Long categoryId, @RequestBody CategoryRequest.UpdateCategory categoryRequest) throws IllegalAccessException {

        CategoryWrapper.UpdateCategory category = categoryService.updateCategory(categoryRequest.toWrapper(categoryId));

        return ResponseEntity.ok(SuccessResponse.of(200L, "Update Category", CategoryResponse.UpdateCategory.from(category)));
    }


    @ApiOperation(value = "[카테고리] 삭제", notes = "[카테고리] 삭제하기")
    @ApiImplicitParam(name = "categoryId", value = "카테고리 고유 ID", required = true, paramType = "path", dataType = "long")
    @ApiResponses({
            @ApiResponse(code = 200, message = "카테고리 삭제 성공"),
            @ApiResponse(code = 400, message = "잘못된 접근"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @DeleteMapping("/api/categories/{categoryId}")
    public ResponseEntity<SuccessResponse<String>> deleteCategory(@PathVariable(name = "categoryId") Long categoryId) throws IllegalAccessException {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(SuccessResponse.of(200L, "Delete Category", ""));
    }
}