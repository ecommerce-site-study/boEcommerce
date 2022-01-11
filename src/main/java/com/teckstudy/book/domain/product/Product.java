package com.teckstudy.book.domain.product;

import com.sun.istack.NotNull;
import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.board.types.BookType;
import com.teckstudy.book.domain.product.types.ProductType;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(
        name = "PRODUCT_SEQ_GENERATOR",
        sequenceName = "PRODUCT_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 10000001,
        allocationSize = 1)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PRODUCT_SEQ_GENERATOR")
    private Long productId;

    @Column(length = 30)
    private String name;

    @Enumerated(EnumType.STRING)
    private ProductType option;

    @Column(length = 11)
    @NotNull
    private BigInteger amount;

    @Column(length = 10)
    private Long quantity;

    private Double discountRate;

    private BookType type;

    @OneToMany(mappedBy = "productId")
    private List<ProductRelationShip> productRelationShip;

}
