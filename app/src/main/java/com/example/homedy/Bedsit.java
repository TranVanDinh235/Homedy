package com.example.homedy;

import java.sql.Time;

public class Bedsit {
    private String title;
    private String description;
    private int rent;
    private int[] image;
    private Address address;
    private Time time;
    private Utilities utilities;

    public static Bedsit newInstance(String title, String description, int rent, int[] image, Address address, Time time, Utilities utilities){
        Bedsit bedsit = new Bedsit();
        bedsit.setTitle(title);
        bedsit.setDescription(description);
        bedsit.setRent(rent);
        bedsit.setImage(image);
        bedsit.setAddress(address);
        bedsit.setTime(time);
        bedsit.setUtilities(utilities);
        return bedsit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int[] getImage() {
        return image;
    }

    public void setImage(int[] image) {
        this.image = image;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Utilities getUtilities() {
        return utilities;
    }

    public void setUtilities(Utilities utilities) {
        this.utilities = utilities;
    }


}
