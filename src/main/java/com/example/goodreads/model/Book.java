package com.example.goodreads.model;

public class Book{
    private int id;
    private String name;
    private int price;
    private String type;
    private String purchaseDate;

    public Book(int id, String name, int price, String type, String purchaseDate){
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.purchaseDate = purchaseDate;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    public void setDate(String purchaseDate){
        this.purchaseDate = purchaseDate;
    }
    public String getDate(){
        return this.purchaseDate;
    }
}