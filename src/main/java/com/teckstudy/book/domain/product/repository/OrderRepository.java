package com.teckstudy.book.domain.product.repository;


import com.teckstudy.book.domain.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<BookOrder, Long> {
}
