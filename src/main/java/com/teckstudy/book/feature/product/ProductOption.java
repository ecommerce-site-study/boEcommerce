package com.teckstudy.book.feature.product;

import com.teckstudy.book.feature.base.Amount;
import com.teckstudy.book.feature.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private Amount amount;

    @Column(length = 10)
    private Long quantity;

    @OneToMany(mappedBy = "productOptionId")
    private List<ProductRelationShip> productRelationShips;
}
