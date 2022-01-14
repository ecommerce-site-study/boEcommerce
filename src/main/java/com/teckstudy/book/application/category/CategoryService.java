package com.teckstudy.book.application.category;

import com.teckstudy.book.domain.category.Category;
import com.teckstudy.book.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDto> findAllDesc() {

        List<Category> categoryList = categoryRepository.findAll();

        return  categoryList.stream()
                .map(CategoryDto::from)
                .collect(Collectors.toList());
    }

}