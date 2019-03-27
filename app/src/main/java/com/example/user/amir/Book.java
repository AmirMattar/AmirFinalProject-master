package com.example.user.amir;
import java.io.Serializable;


public class Book implements Serializable{
    private String name;
    private double rating;
    private String summary;
    private int image;
    private boolean isInWishList;

    public Book(String name, double rating, String summary, int image) {
        this.name = name;
        this.rating = rating;
        this.summary = summary;
        this.image = image;
        this.isInWishList = false;
    }
public Book(){

}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isInWishList() {
        return isInWishList;
    }

    public void setInWishList(boolean inWishList) {
        isInWishList = inWishList;
    }
}
//takes info and puts it in the book information page.
