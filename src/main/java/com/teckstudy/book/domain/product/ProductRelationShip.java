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
    private Product productId;

    @ManyToOne
    private ProductOption productOptionId;
}
