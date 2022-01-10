package com.teckstudy.book.domain.favorite;

import lombok.*;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    private Long memberId;
    private Long productId;
}