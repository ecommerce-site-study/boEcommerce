package com.teckstudy.book.domain.order;

import com.teckstudy.book.domain.base.Address;
import com.teckstudy.book.domain.base.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 주문
 */
@Entity
@Getter
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    private Long memberId;

    @Embedded
    private Address orderAddress;

    private LocalDateTime orderAt;
}