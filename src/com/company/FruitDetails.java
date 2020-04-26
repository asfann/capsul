package com.company;

import java.awt.*;

public class FruitDetails {
    private String name;
    private int price;
    Color colorame;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public enum Color{
     red,
     green,
        yellow
    }
    public FruitDetails(String name,int price,Color color){
        System.out.println();
        this.name=name;
        this.price=price;
         colorame = color;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + colorame;
    }
}

















/*

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String get() {
        return ;
    }
}

class User{
    public static void main(String[] args){
    }
}*/
