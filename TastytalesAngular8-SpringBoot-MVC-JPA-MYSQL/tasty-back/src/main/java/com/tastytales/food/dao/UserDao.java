package com.tastytales.food.dao;

import com.tastytales.food.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,String> {
}
