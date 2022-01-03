package com.teckstudy.book.domain.favorite.repository;

import com.teckstudy.book.domain.favorite.Favorite;
import com.teckstudy.book.domain.favorite.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteId> {
}
