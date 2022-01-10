package com.teckstudy.book.domain.order.repository;


import com.teckstudy.book.domain.order.Order;
import com.teckstudy.book.domain.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
