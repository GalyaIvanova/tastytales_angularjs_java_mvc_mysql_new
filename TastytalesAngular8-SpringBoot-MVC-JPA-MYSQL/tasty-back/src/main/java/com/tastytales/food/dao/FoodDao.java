package com.tastytales.food.dao;

import com.tastytales.food.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodDao extends JpaRepository<Food,String> {

}
