package com.teckstudy.book.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pay_sn;

    @OneToOne(mappedBy = "payInfo",fetch = FetchType.LAZY)
    @JoinColumn(name = "order_sn")
    private OrderItem orderItem;

    private Integer total_price;

}
