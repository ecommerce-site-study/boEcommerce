package com.teckstudy.book.domain.refund;

import com.teckstudy.book.domain.OrderItem;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int refund_sn;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_sn")
    private OrderItem orderItem;

    @Column(length = 20, nullable = false)
    private String bank_name;

    @Column(length = 30, nullable = false)
    private String acc_number;

}
