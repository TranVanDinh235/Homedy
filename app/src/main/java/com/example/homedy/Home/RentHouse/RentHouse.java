package com.example.homedy.Home.RentHouse;

import com.example.homedy.Home.Purchase.Purchase;
import com.example.homedy.R;

import java.util.ArrayList;
import java.util.List;

public class RentHouse extends Purchase {
    protected int time;
    private static String[] names = {"Sailing Club Villas Phu Quoc", "Khu đô thị New Times City", "Best Western Premier Sapphire","Grand World Phú Quốc"};
    private static String[] prices = {"15 Tỷ","Thương Lượng", "1.8 Tỷ", "9 Tỷ"};
    private static String[] addresses = {"Đường Trần Hưng Đạo,, Khu Phố 7, Xã Dương..", "ĐT 747, xã Hội Nghĩa, Thị xã Tân Uyên, tỉnh Bi..","Số 1 Bến Loan, Phường Hồng Gai, Thành phố..", "Bãi Dài, Gành Dầu, Huyện Phú Quốc, Tỉnh Ki.."};
    private static String[] locations ={"123,5km", "15,7km","1,6km","141,6km"};
    private static int[] times = {5, 24, 10, 1};
    private static int[] images ={R.drawable.image1, R.drawable.image2, R.drawable.image3,R.drawable.image4};

    public RentHouse(String name, String price, String address, String location, int time, int image) {
        super(name, price, address, location, time, image);
    }

    public static List<RentHouse> getRenHouses(){
        List<RentHouse> rentHouses = new ArrayList<>();
        for(int i = 0; i < names.length; i ++){
            RentHouse rentHouse = new RentHouse(names[i], prices[i], addresses[i], locations[i], times[i], images[i]);
            rentHouses.add((RentHouse) rentHouse);
        }
        return rentHouses;
    }
}
