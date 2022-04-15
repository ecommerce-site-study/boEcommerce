package com.teckstudy.book.feature.domain.board;

import com.teckstudy.book.feature.domain.base.BaseEntity;
import com.teckstudy.book.feature.domain.base.types.YesNoStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private String memberId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Enumerated(EnumType.STRING)
    private YesNoStatus displayYn;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;
}