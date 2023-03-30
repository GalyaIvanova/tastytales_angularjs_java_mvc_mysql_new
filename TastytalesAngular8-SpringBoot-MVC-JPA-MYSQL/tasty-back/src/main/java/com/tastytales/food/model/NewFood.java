package com.tastytales.food.model;

public class NewFood {

   private String id;
   private String name;
   private int weight;
    private String description;
    private String category;
   private int quantityAvailable;
   private String fileDataF;

   public NewFood(){}

    public NewFood(String id, String name, int weight, int quantityAvailable, String fileDataF) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.quantityAvailable = quantityAvailable;
        this.fileDataF = fileDataF;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return weight;
    }

    public void setPrice(int weight) {
        this.weight = weight;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getFileDataF() {
        return fileDataF;
    }

    public void setFileDataF(String fileDataF) {
        this.fileDataF = fileDataF;
    }

    @Override
    public String toString() {
        return "NewFood{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", quantityAvailable=" + quantityAvailable +
                ", fileDataF=" + fileDataF +
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
