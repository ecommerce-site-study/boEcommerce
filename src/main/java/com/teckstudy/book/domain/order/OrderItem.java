package com.teckstudy.book.domain.order;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.order.types.DeliveryStatusType;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * 주문리스트
 */
@Entity
@Getter @Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private Long orderId;

    private Long productId;

    @Column(length = 11)
    private BigInteger amount;

    private BigInteger discountOrderPrice;

    @Enumerated(EnumType.STRING)
    private DeliveryStatusType deliveryStatus;

//    @Column(length = 100)
//    private String order_address;

    private Long paymentId;

    private Long RefundId;

    private Long count;

}
