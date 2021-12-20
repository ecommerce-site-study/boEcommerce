package com.teckstudy.book.domain.product.repository;

import com.teckstudy.book.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

}
