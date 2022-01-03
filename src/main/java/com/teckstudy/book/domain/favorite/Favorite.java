package com.teckstudy.book.domain.favorite;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {

    @EmbeddedId
    private FavoriteId favoriteId;
}