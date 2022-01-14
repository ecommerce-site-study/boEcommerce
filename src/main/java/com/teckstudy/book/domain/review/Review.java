package com.teckstudy.book.domain.review;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.member.Member;
import com.teckstudy.book.domain.product.Product;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @OneToOne(mappedBy = "review")
    @JoinColumn(name = "memberId")
    private Member memberId;

    @OneToOne(mappedBy = "review")
    @JoinColumn(name = "productId")
    private Product productId;

    @Column(length = 40, nullable = false)
    private String reviewSub;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String reviewContent;

    @Column(length = 1, nullable = false)
    private int gpa;
}
