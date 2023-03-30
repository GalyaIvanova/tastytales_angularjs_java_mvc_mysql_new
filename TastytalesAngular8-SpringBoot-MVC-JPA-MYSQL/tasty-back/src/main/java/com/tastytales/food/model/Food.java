package com.tastytales.food.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Food {

    @Id
    private String id;
    private String item;
    private int weight;
    private int quantity;
    private String url;
    private String description;
    private String category;
    private String formID;
    private String favoritesID;

    public Food(){}

    public Food(String id, String item,int quantity, String url, String formID, String favoritesID) {
        this.id = id;
        this.item = item;

        this.quantity=quantity;
        this.url=url;
        this.formID=formID;
        this.favoritesID=favoritesID;
    }

    public Food(String id, String item, int quantity, String url, String description, String category, String formID, String favoritesID) {
        this.id=id;
        this.item=item;

        this.quantity=quantity;
        this.url=url;
        this.description=description;
        this.category=category;
        this.formID=formID;
        this.favoritesID=favoritesID;
    }

    public String getFormID() {
        return formID;
    }

    public void setFormID(String formID) {
        this.formID = formID;
    }

    public String getFavoritesID() {
        return favoritesID;
    }

    public void setFavoritesID(String favoritesID) {
        this.favoritesID = favoritesID;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url=url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return weight;
    }

    public void setPrice(int weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id='" + id + '\'' +
                ", item='" + item + '\'' +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", url='" + url + '\'' +
                ", formID='" + formID + '\'' +
                ", favoritesID='" + favoritesID + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category=category;
    }
}
