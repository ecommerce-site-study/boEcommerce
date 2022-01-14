package com.teckstudy.book.domain.product;

import com.sun.istack.NotNull;
import com.teckstudy.book.domain.base.Amount;
import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.board.Board;
import com.teckstudy.book.domain.board.types.BookType;
import com.teckstudy.book.domain.product.types.ProductType;
import com.teckstudy.book.domain.review.Review;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    private Amount amount;

    private Long quantity;

    private Double discountRate;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    @OneToMany(mappedBy = "product")
    private List<ProductRelationShip> productRelationShips;

}
