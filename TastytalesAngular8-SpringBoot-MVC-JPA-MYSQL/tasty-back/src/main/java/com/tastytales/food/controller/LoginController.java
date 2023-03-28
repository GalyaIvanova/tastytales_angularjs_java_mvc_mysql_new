package com.tastytales.food.controller;

import com.tastytales.food.dao.UserDaoImpl;
import com.tastytales.food.model.Login;
import com.tastytales.food.model.User;
import com.tastytales.food.utility.StrongAES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private UserDaoImpl userDao;


    @RequestMapping("/login")
    public Login showLogin() {
        return new Login();
    }

    @PostMapping("/login")
    public User loginProcess(@RequestBody Login login, Model model) {
        User user = null;
        user = userDao.validateUser(login);
        if(user!=null)
        user.setPassword(null);
        return user;
    }

    @RequestMapping("/xx")
    private String xx(){
        return new StrongAES().encrypt("");
    }

}
