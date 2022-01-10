package com.teckstudy.book.domain.order;

import com.teckstudy.book.domain.base.Amount;
import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.order.types.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 주문리스트
 */
@Entity
@Getter
@NoArgsConstructor
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private Long orderId;

    private Long productId;

    @Embedded
    private Amount amount;

    @Embedded
    private Amount discountOrderPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private Long paymentId;

//    @OneToMany(mappedBy = "orderId")
//    private Refund refundId;

    private Long count;

    /**
     * 할인율 계산
     * @return
     */
    public int salePercent() {
        return ((amount.intValue() - discountOrderPrice.intValue()) / amount.intValue()) * 100;
    }
}
