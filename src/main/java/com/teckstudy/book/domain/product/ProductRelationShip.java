package com.teckstudy.book.domain.product;


import com.teckstudy.book.domain.product.relationship.ProductRelationId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor
public class ProductRelationShip {

    @EmbeddedId
    private ProductRelationId productRelationId;
}
