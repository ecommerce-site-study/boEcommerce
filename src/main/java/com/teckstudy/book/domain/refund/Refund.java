package com.teckstudy.book.domain.refund;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.order.OrderItem;
import com.teckstudy.book.domain.order.types.OrderStatus;
import com.teckstudy.book.domain.refund.types.RefundType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Refund extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refundId;

    private RefundType refundType;

    private OrderStatus refundStatus;

    private String refundTitle;

    private String refundContent;

    private LocalDateTime requestAt;

}
