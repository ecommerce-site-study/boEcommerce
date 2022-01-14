package com.teckstudy.book.domain.payment;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.payment.types.PaymentType;
import com.teckstudy.book.domain.order.OrderItem;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private PaymentType paymentType;

    @OneToOne
    private OrderItem orderItem;

    private LocalDateTime paymentAt;

    private LocalDateTime cancelAt;
}