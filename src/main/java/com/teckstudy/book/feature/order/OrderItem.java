package com.teckstudy.book.feature.order;

import com.teckstudy.book.feature.base.Amount;
import com.teckstudy.book.feature.base.BaseEntity;
import com.teckstudy.book.feature.order.types.OrderStatus;
import com.teckstudy.book.feature.payment.Payment;
import com.teckstudy.book.feature.refund.Refund;
import lombok.Getter;

import javax.persistence.*;

/**
 * 주문리스트
 */
@Entity
@Getter
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private Long productId;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name="price", column = @Column(name = "amount"))
    })
    private Amount amount;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name="price", column = @Column(name = "discountOrderPrice"))
    })
    private Amount discountOrderPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders order;

    @OneToOne(mappedBy = "orderItem")
    private Payment payment;

    @OneToOne(mappedBy = "orderItem")
    private Refund refund;

    private Long count;

    /**
     * 할인율 계산
     * @return
     */
    public int salePercent() {
        return ((amount.intValue() - discountOrderPrice.intValue()) / amount.intValue()) * 100;
    }
}
