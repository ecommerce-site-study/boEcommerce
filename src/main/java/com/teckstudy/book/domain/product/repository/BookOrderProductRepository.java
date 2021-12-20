package com.teckstudy.book.domain.product.repository;

import com.teckstudy.book.domain.BookOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOrderProductRepository extends JpaRepository<BookOrderProduct, Long> {

}
