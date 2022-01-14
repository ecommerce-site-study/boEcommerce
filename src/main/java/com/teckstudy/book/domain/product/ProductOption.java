package com.teckstudy.book.domain.product;

import com.sun.istack.NotNull;
import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.product.ProductRelationShip;
import lombok.*;

import javax.persistence.*;

import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class ProductOption extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductOptionId;

    @Column(length = 100)
    private String name;

    @Column(length = 11)
    @NotNull
    private BigInteger amount;

    @Column(length = 10)
    private Long quantity;

    @OneToMany(mappedBy = "productOption")
    private List<ProductRelationShip> productRelationShips;
}
