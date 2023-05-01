package com.tastytales.food.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tastytales.food.model.Favorites;
import com.tastytales.food.model.Food;
import com.tastytales.food.model.NewFavorites;
import com.tastytales.food.model.NewFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FavoritesDaoImpl{

    @Autowired
    FavoritesDao favoritesDao;

    @Autowired
    FoodDao foodDao;

    @Value("${fileStorage}")
    private String storagePath;

    public void saveToFavorites(NewFavorites[] newFavoritess){
        favoritesDao.deleteAll();
        favoritesDao.flush();
        Favorites favorites= new Favorites(1,0,0,0,0,0);
        favorites.setQuantity1(newFavoritess[0].getQuantity());
        favorites.setQuantity2(newFavoritess[1].getQuantity());
        favorites.setQuantity3(newFavoritess[2].getQuantity());
        if(newFavoritess.length>3)
            favorites.setQuantity4(newFavoritess[3].getQuantity());
        if(newFavoritess.length>4)
        favorites.setQuantity5(newFavoritess[4].getQuantity());
        if(newFavoritess.length>5)
        favorites.setQuantity6(newFavoritess[6].getQuantity());
        favoritesDao.save(favorites);
    }

    public void updateDB(){
        List<Favorites> favoritess =favoritesDao.findAll();
        Favorites favorites = favoritess.get(1);
        List<Food> foods = foodDao.findAll();
        foods.get(0).setQuantity(foods.get(0).getQuantity()-favorites.getQuantity1());
        foods.get(1).setQuantity(foods.get(1).getQuantity()-favorites.getQuantity2());
        foods.get(2).setQuantity(foods.get(2).getQuantity()-favorites.getQuantity3());
        if(foods.size()>3)
        foods.get(3).setQuantity(foods.get(3).getQuantity()-favorites.getQuantity4());
        if(foods.size()>4)
            foods.get(4).setQuantity(foods.get(4).getQuantity()-favorites.getQuantity5());
        if(foods.size()>5)
            foods.get(5).setQuantity(foods.get(5).getQuantity()-favorites.getQuantity6());
        foodDao.saveAll(foods);
    }

    public List<Favorites> getAllFavorites(){
        return favoritesDao.findAll();
    }

    public void addItems(NewFavorites[] favorites){
        List<Food> foods = foodDao.findAll();
        for(int i=0;i<foods.size();i++){
            foods.get(i).setQuantity(foods.get(i).getQuantity()+favorites[i].getQuantity());
        }
        foodDao.saveAll(foods);
    }

    public boolean addNewItem(MultipartFile file, String newFoodData) throws IOException {
        NewFood newFood = new ObjectMapper().readValue(newFoodData,NewFood.class);
        if(!file.isEmpty())
        if(saveFileToAssets(file))
        {
            foodDao.save(new Food(newFood.getId(),newFood.getName(),newFood.getQuantityAvailable(),"/assets/"+file.getOriginalFilename(),"",""));
            //foodDao.save(new Food(newFood.getId(),newFood.getName(),newFood.getPrice(),newFood.getQuantityAvailable(),"\\"+file.getOriginalFilename(),"",""));
        }
        return true;
    }

    public boolean addNewItemWithUrl(String newFoodData) throws IOException {
        NewFood newFood = new ObjectMapper().readValue(newFoodData,NewFood.class);
        foodDao.save(new Food(newFood.getId(),newFood.getName(),newFood.getQuantityAvailable(),newFood.getFileDataF(),"",""));
        return true;
    }

    private boolean saveFileToAssets(MultipartFile file) throws IOException {
        Path filepath = Paths.get(storagePath, file.getOriginalFilename());
        file.transferTo(filepath);
        return true;
    }

    public int claculateTotal(NewFavorites[] newFavorites){
        int total=0;
        List<Food> foods = foodDao.findAll();

        for(int i=0;i<foods.size();i++)
        {
            total+=foods.get(i).getPrice()*newFavorites[i].getQuantity();
        }
        return total;
    }

    public boolean itemIdAvailable(String itemId) {
        return foodDao.findById(itemId).isPresent();
    }
}
