package com.teckstudy.book.domain;

import com.teckstudy.book.domain.enums.DeleveryStatus;
import com.teckstudy.book.domain.payment.Payment;
import com.teckstudy.book.domain.refund.Refund;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter @Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private Long orderId;

    private Long productId;

    @Column(length = 11)
    private BigInteger amount;

    private BigInteger discountOrderPrice;

    @Enumerated(EnumType.STRING)
    private DeleveryStatus delevery;

//    @Column(length = 100)
//    private String order_address;

    private Payment PaymentId;

    private Refund RefundId;

    private Long count;

}
