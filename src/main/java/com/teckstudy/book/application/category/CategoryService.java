package com.teckstudy.book.application.category;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teckstudy.book.application.category.dto.Categories;
import com.teckstudy.book.application.category.dto.CategoryWrapper;
import com.teckstudy.book.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryWrapper.LayerCategoryDto> searchCategories() throws JsonProcessingException {

//        Categories categories = Categories.from(categoryRepository.findAll());
        Categories categories = Categories.dummy();

        return  categories.layerList();
    }
}