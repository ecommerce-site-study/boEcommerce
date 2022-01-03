package com.teckstudy.book.domain.product.repository;

import com.teckstudy.book.domain.product.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
}
