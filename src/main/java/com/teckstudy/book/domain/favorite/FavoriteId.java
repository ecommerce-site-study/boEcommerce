package com.teckstudy.book.domain.favorite;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
public class FavoriteId implements Serializable {

    private Long memberId;
    private Long productId;
}