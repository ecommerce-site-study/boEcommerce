package com.teckstudy.book.domain.board.repository;

import com.teckstudy.book.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * com.teckstudy.book.domain.board.repository
 *      BoardRepository
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-01-04 오전 2:12
 */

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
