package com.teckstudy.book.domain.board.repository;

import com.teckstudy.book.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
