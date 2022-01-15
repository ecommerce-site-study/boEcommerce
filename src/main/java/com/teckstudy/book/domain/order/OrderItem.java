package com.teckstudy.book.domain.order;

import com.teckstudy.book.domain.base.Amount;
import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.order.types.OrderStatus;
import com.teckstudy.book.domain.payment.Payment;
import com.teckstudy.book.domain.refund.Refund;
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
