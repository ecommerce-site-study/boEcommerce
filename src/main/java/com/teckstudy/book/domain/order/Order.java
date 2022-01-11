package com.teckstudy.book.domain.order;

import com.teckstudy.book.domain.base.Address;
import com.teckstudy.book.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 주문
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany(mappedBy = "orderItemId")
    private List<OrderItem> orderItems;

    private Long memberId;

    @Embedded
    private Address orderAddress;

    private LocalDateTime orderAt;
}