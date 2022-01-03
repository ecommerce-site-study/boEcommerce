package com.teckstudy.book.domain.product;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.member.Member;
import com.teckstudy.book.domain.product.Product;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Long memberId;

    private Long productId;

    @Column(length = 40, nullable = false)
    private String reviewTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String reviewContent;

    @Column(length = 1, nullable = false)
    private int gpa;
}
