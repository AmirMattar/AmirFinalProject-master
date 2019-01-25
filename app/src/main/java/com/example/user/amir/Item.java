package com.example.user.amir;

import java.io.Serializable;

public class Item implements Serializable {
    private int image;
    private String name;

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {

        return image;
    }

    public String getName() {
        return name;
    }

    public Item(int image, String name) {

        this.image = image;
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
