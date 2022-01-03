package com.teckstudy.book.domain.product.repository;

import com.teckstudy.book.domain.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOrderRepository extends JpaRepository<OrderItem, Long> {
}
