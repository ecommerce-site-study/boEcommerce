package com.teckstudy.book.domain;

import com.teckstudy.book.domain.enums.YesNoStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private String memberId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    private YesNoStatus displayYn;
}
