package com.teckstudy.book.domain.refund.repository;

import com.teckstudy.book.domain.refund.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {

}
