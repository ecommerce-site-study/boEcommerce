package com.teckstudy.book.feature.board;

import com.teckstudy.book.feature.base.BaseEntity;
import com.teckstudy.book.core.types.YesNoStatus;
import com.teckstudy.book.feature.board.types.CategoryType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private Long memberId;

    private CategoryType categoryType;

    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Enumerated(EnumType.STRING)
    private YesNoStatus topShow;

    @Enumerated(EnumType.STRING)
    private YesNoStatus displayYn;

    private String file_path;

    @OneToMany(mappedBy = "board")
    private List<Answer> answers;

}