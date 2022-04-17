package com.teckstudy.book.feature.board.repository;

import com.teckstudy.book.feature.board.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
