package com.teckstudy.book.domain.product.repository;

import com.teckstudy.book.domain.refund.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRepository extends JpaRepository<Refund, Long> {

}
