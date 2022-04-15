package com.teckstudy.book.feature.domain.board.repository;

import com.teckstudy.book.feature.domain.board.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
