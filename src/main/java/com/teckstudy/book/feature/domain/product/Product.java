package com.teckstudy.book.feature.domain.product;

import com.teckstudy.book.feature.domain.base.Amount;
import com.teckstudy.book.feature.domain.base.BaseEntity;
import com.teckstudy.book.feature.domain.board.types.BookType;
import com.teckstudy.book.feature.domain.product.types.ProductType;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
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
    private ProductType productType;

    private Amount amount;

    @Column(length = 10)
    private Long quantity;

    private Double discountRate;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    @OneToMany(mappedBy = "productId")
    private List<ProductRelationShip> productRelationShips;

}