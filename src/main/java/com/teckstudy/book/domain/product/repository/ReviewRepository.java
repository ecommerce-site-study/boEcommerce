package com.teckstudy.book.domain.product.repository;

import com.teckstudy.book.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
