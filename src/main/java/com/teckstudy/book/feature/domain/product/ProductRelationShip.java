package com.teckstudy.book.feature.domain.product;


import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ProductRelationShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productRelationId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "productOptionId")
    private ProductOption productOptionId;
}
