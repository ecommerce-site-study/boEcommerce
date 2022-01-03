package com.teckstudy.book.domain.payment;

import com.teckstudy.book.domain.OrderItem;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PaymentId;

    @OneToOne(mappedBy = "payInfo",fetch = FetchType.LAZY)
    @JoinColumn(name = "order_sn")
    private OrderItem orderItem;

    private Integer total_price;
}