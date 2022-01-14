package com.teckstudy.book.domain.board;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.base.types.YesNoStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "answer_tb")
@NoArgsConstructor
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private Long memberId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Enumerated(EnumType.STRING)
    private YesNoStatus displayYn;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

}
