package com.tastytales.food;

import com.tastytales.food.model.Favorites;
import com.tastytales.food.model.Food;
import com.tastytales.food.dao.FavoritesDaoImpl;
import com.tastytales.food.dao.FoodDaoImpl;
import com.tastytales.food.dao.UserDao;
import com.tastytales.food.dao.UserDaoImpl;
import com.tastytales.food.model.Login;
import com.tastytales.food.model.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XwiggyApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    UserDaoImpl userDaoImpl;

    @Autowired
    FoodDaoImpl foodDao;

    @Autowired
    FavoritesDaoImpl favoritesDao;
    @Ignore
    @Test
    public void contextLoads() {
        Login login = new Login();
        login.setUsername("amank");
        login.setPassword("abcd1234");

        User user = userDaoImpl.validateUser(login);
        Assert.assertEquals("Aman",user.getFirstname());
        Assert.assertEquals("Kumar",user.getLastname());
        Assert.assertEquals("aman@gmail.com",user.getEmail());
        Assert.assertEquals(9585418,user.getPhone());
    }
    @Ignore
    @Test
    public void checkFoodTable(){
        Food food = new Food();
        food.setId("abc");
        Food food1 = foodDao.validateFoodInfo(food.getId());
        Assert.assertEquals("Coffee",food1.getItem());
        Assert.assertEquals(50,food1.getPrice());
    }
    @Ignore
    @Test
    public void checkFavoritesDb(){
        List<Favorites> favoritess = favoritesDao.getAllFavorites();
        Favorites zero = favoritess.get(0);
        Assert.assertEquals(0,zero.getQuantity1());
        Assert.assertEquals(0,zero.getQuantity2());
        Assert.assertEquals(0,zero.getQuantity3());
    }

    /*Test*/


}
