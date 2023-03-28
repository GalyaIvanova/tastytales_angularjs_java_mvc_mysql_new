package com.tastytales.food.dao;

import com.tastytales.food.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact,Integer> {
}
