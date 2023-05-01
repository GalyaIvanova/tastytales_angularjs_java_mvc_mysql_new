package com.tastytales.food.controller;

import com.tastytales.food.dao.FavoritesDaoImpl;
import com.tastytales.food.model.NewFavorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class FavoritesController {

    @Autowired
    FavoritesDaoImpl favoritesDao;


    @PostMapping("/favorites")
    public int getTotal(@RequestBody NewFavorites[] favorites, Model model){
        favoritesDao.saveToFavorites(favorites);
        return favoritesDao.claculateTotal(favorites);
    }

    @RequestMapping("/changeDB")
    public boolean changeDB(){
        favoritesDao.updateDB();
        return true;
    }

    @PostMapping("/addToFavorites")
    public NewFavorites[] increaseQuantity(@RequestBody NewFavorites[] favorites, Model model){
        favoritesDao.addItems(favorites);
        return favorites;
    }

    @PostMapping("/addNewItem")
    public boolean addNewItem(@RequestParam("file") MultipartFile file, @RequestParam("newFoodItem") String newFoodData) throws IOException {
        return favoritesDao.addNewItem(file,newFoodData);
    }


    @PostMapping("/addNewItemUrl")
    public boolean addNewItemByUrl(@RequestParam("newFoodItem") String newFoodData) throws IOException {
        return favoritesDao.addNewItemWithUrl(newFoodData);
    }

    @PostMapping("/checkItemId")
    public boolean checkItemId(@RequestBody String itemId, Model model){
        return !favoritesDao.itemIdAvailable(itemId);
    }
}
