package com.teckstudy.book.domain.payment;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.payment.types.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private PaymentType paymentType;

    private LocalDateTime paymentAt;

    private LocalDateTime cancelAt;

}