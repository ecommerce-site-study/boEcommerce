package com.teckstudy.book.feature.domain.favorite.repository;

import com.teckstudy.book.feature.domain.favorite.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
}
