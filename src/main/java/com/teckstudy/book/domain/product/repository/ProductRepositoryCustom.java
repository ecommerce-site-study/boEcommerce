package com.teckstudy.book.domain.product.repository;

import com.teckstudy.book.ui.product.ProductsResponseDto;

import java.util.List;

public interface ProductRepositoryCustom {

    List<ProductsResponseDto> findAllDesc(Long id) throws Exception;

}
