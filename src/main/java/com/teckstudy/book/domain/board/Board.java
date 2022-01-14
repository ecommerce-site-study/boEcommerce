package com.teckstudy.book.domain.board;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.board.types.CategoryType;
import com.teckstudy.book.domain.base.types.YesNoStatus;
import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.EAGER;

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

    private String filePath;

    @OneToMany(mappedBy = "board")
    private List<Answer> answers;
}
