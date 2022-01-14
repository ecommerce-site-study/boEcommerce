package com.teckstudy.book.domain.product;


import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ProductRelationShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productRelationId;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "product_option_id")
    private ProductOption productOption;

}
