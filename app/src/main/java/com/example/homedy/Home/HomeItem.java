package com.example.homedy.Home;

import com.example.homedy.R;

import java.util.ArrayList;

public class HomeItem {
    private int image;
    private double rent;
    private String title;
    private String address;
    private int time;
    private int area;

    private static String[] titles = {"Cho thuê phòng chính chủ 20 m2 tại Xuân Thuỷ", "Nhượng lại phòng tại Hồ Tùng Mậu", "Cho thuê trọ phòng siêu mới, siêu đẹp 2,5tr 20m2 Trần Bình","Cho thuê phòng đẹp kk nl đh ngõ 62 phố trần bình mai dịch cầu giấy hà nội","phòng tiện nghi S : 17- 25 - 40m2, ngõ 165 đường Dương Quảng Hàm Cầu Giấy"};
    private static double[] rents = {2.3 , 3, 1.4, 3.3, 2.3, 2};
    private static String[] addresses = {"Đường Dương Quảng Hàm, Phường Mai Dịch, Quận Cầu Giấy", "Đường Mai Dịch, Phường Mai Dịch, Quận Cầu Giấy","Đường Hồ Tùng Mậu, Phường Mai Dịch, Quận Cầu Giấy", "Đường Hồ Tùng Mậu, Phường Mai Dịch, Quận Cầu Giấy","Phố Doãn Kế Thiện, Phường Mai Dịch, Quận Cầu Giấy","Phố Doãn Kế Thiện, Phường Mai Dịch, Quận Cầu Giấy"};
    private static int[] times = {5, 24, 10, 1, 4, 9};
    private static int[] areas = {20, 23, 15, 20, 12, 30};
    private static int[] images ={R.drawable.image1, R.drawable.image2, R.drawable.image3,R.drawable.image4, R.drawable.image5, R.drawable.image6};

    public HomeItem(){}

    public HomeItem(int image, double rent, String title, String address, int time, int area) {
        this.image = image;
        this.rent = rent;
        this.title = title;
        this.address = address;
        this.time = time;
        this.area = area;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public static ArrayList<HomeItem> getExameHome(){
        ArrayList<HomeItem> homeItems = new ArrayList<>();
        for (int i = 0; i < titles.length; i ++){
            HomeItem homeItem = new HomeItem(images[i],rents[i], titles[i], addresses[i], times[i], areas[i]);
            homeItems.add(homeItem);
        }
        return homeItems;
    }
}
