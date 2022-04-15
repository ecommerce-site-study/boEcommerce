package com.teckstudy.book.feature.domain.order.repository;


import com.teckstudy.book.feature.domain.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}