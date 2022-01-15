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
@SequenceGenerator(
        name = "PRODUCT_OPTION_SEQ_GENERATOR",
        sequenceName = "PRODUCT_OPTION_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 10000001,
        allocationSize = 1)
public class ProductOption extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PRODUCT_OPTION_SEQ_GENERATOR")
    private Long ProductOptionId;

    @Column(length = 100)
    private String name;

    @Column(length = 11)
    @NotNull
    private BigInteger amount;

    @Column(length = 10)
    private Long quantity;

    @OneToMany(mappedBy = "productOptionId")
    private List<ProductRelationShip> productRelationShips;
}
