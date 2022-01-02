package com.teckstudy.book.domain.board;

import com.teckstudy.book.domain.Answer;
import com.teckstudy.book.domain.BaseEntity;
import com.teckstudy.book.domain.board.types.Category;
import com.teckstudy.book.domain.enums.YesNoStatus;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private Long memberId;

    private Category category;

    private String name;

    private String subject;

    private String content;

    @Enumerated(EnumType.STRING)
    private YesNoStatus top_show_yn;

    private String file_path;

    @OneToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "board_sn")
    private Answer answer;

}
