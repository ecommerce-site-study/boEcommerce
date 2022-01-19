package com.teckstudy.book.domain.refund;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.order.OrderItem;
import com.teckstudy.book.domain.order.types.OrderStatus;
import com.teckstudy.book.domain.refund.types.RefundType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Refund extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refundId;

    private RefundType refundType;

    private OrderStatus refundStatus;

    private String refundTitle;

    private String refundContent;

    private LocalDateTime requestAt;

    @OneToOne
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    public Long getRefundId() {
        return refundId;
    }

    public RefundType getRefundType() {
        return refundType;
    }

    public OrderStatus getRefundStatus() {
        return refundStatus;
    }

    public String getRefundTitle() {
        return refundTitle;
    }

    public String getRefundContent() {
        return refundContent;
    }

    public LocalDateTime getRequestAt() {
        return requestAt;
    }
}
