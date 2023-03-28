package com.tastytales.food.dao;

import com.tastytales.food.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart,Integer> {
}
