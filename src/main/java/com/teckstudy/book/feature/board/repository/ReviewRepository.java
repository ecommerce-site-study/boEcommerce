package com.teckstudy.book.feature.board.repository;

import com.teckstudy.book.feature.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
