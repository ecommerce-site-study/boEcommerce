package com.teckstudy.book.domain.order.repository;

import com.teckstudy.book.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * com.teckstudy.book.domain.order.repository
 *      OrderRepository
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-01-04 오전 2:19
 */

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
