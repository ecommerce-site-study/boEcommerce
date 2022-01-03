package com.teckstudy.book.domain.product.relationship;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 다대다의 경우 엔티티로 승격시킨다.
 */
@Embeddable
public class ProductRelationId implements Serializable {

    private Long productId;
    private Long productOptionId;
}