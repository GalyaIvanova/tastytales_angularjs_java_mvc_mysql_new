package com.tastytales.food.dao;

import com.tastytales.food.model.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesDao extends JpaRepository<Favorites,Integer> {
}
