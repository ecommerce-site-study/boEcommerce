package com.teckstudy.book.domain.favorite.repository;

import com.teckstudy.book.domain.favorite.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
}
