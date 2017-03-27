package com.vnurture.vnurture.foodapp;

import android.graphics.Bitmap;

/**
 * Created by VNurtureTechnologies on 30/12/16.
 */

public class FoodModel {

    String name;
    String address;
    String contact;

    Bitmap logo;


    boolean selected = false;



    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Bitmap getLogo() {
        return logo;
    }

    public void setLogo(Bitmap logo) {
        this.logo = logo;
    }







}
