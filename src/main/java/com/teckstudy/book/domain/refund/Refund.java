package com.teckstudy.book.domain.refund;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.enums.RefundStatus;
import com.teckstudy.book.domain.enums.RefundType;
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
public class Refund extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refundId;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "orderItemId")
//    private OrderItem orderId;

    private RefundType refundType;

    private RefundStatus refundStatus;

    private String refundTitle;

    private String refundContent;

    private LocalDateTime requestAt;

}
