package com.teckstudy.book.feature.domain.review;

import com.teckstudy.book.feature.domain.base.BaseEntity;

import javax.persistence.*;

@Entity
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Long memberId;

    private Long productId;

    @Column(length = 40, nullable = false)
    private String reviewSub;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String reviewContent;

    @Column(length = 1, nullable = false)
    private int gpa;

    public Long getReviewId() {
        return reviewId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getReviewSub() {
        return reviewSub;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public int getGpa() {
        return gpa;
    }
}
