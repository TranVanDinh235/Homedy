package com.example.homedy.Home.RealEstate;

import com.example.homedy.R;

import java.util.ArrayList;
import java.util.List;

public class RealEstate {
    protected String name;
    protected String price;
    protected int year;
    protected String address;
    protected String location;
    protected int image;

    private static String[] names = {"Sailing Club Villas Phu Quoc", "Khu đô thị New Times City", "Best Western Premier Sapphire","Grand World Phú Quốc"};
    private static String[] prices = {"15 Tỷ","Thương Lượng", "1.8 Tỷ", "9 Tỷ"};
    private static String[] addresses = {"Đường Trần Hưng Đạo,, Khu Phố 7, Xã Dương..", "ĐT 747, xã Hội Nghĩa, Thị xã Tân Uyên, tỉnh Bi..","Số 1 Bến Loan, Phường Hồng Gai, Thành phố..", "Bãi Dài, Gành Dầu, Huyện Phú Quốc, Tỉnh Ki.."};
    private static String[] locations ={"123,5km", "15,7km","1,6km","141,6km"};
    private static int[] years = {2018, 2018, 2017, 2019};
    private static int[] images ={R.drawable.image1, R.drawable.image2, R.drawable.image3,R.drawable.image4};

    public RealEstate(){}


    public RealEstate(String name, String price, int year, String location, String address, int image){
        this.name = name;
        this.price = price;
        this.address = address;
        this.location = location;
        this.year = year;
        this.image = image;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address){this.address = address;}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public static List<RealEstate> getRealEstates(){
        List<RealEstate> realEstates = new ArrayList<>();

        for(int i = 0; i < names.length; i ++){
            RealEstate realEstate = new RealEstate(names[i], prices[i], years[i],locations[i],addresses[i],images[i]);
            realEstates.add(i,realEstate);
        }
        return realEstates;
    }

}
