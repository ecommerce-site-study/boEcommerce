package com.teckstudy.book.feature.payment;

import com.teckstudy.book.feature.base.BaseEntity;
import com.teckstudy.book.feature.order.OrderItem;
import com.teckstudy.book.feature.payment.types.PaymentType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private PaymentType paymentType;

    private LocalDateTime paymentAt;

    private LocalDateTime cancelAt;

    @OneToOne
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    public Long getPaymentId() {
        return paymentId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public LocalDateTime getPaymentAt() {
        return paymentAt;
    }

    public LocalDateTime getCancelAt() {
        return cancelAt;
    }
}