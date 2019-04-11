package com.example.homedy;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
    private boolean gasStove = false;
    private boolean airConditon = false;
    private boolean internet = false;
    private boolean television = false;
    private boolean heaterWater = false;
    private boolean alarmDevice = false;

    private static Utilities newInstance( boolean gasStove, boolean airConditon, boolean internet, boolean television, boolean heaterWater,  boolean alarmDevice){
        Utilities utilities = new Utilities();
        utilities.setAirConditon(airConditon);
        utilities.setAlarmDevice(alarmDevice);
        utilities.setGasStove(gasStove);
        utilities.setHeaterWater(heaterWater);
        utilities.setInternet(internet);
        utilities.setTelevision(television);
        return utilities;
    }


    public boolean isGasStove() {
        return gasStove;
    }

    public void setGasStove(boolean gasStove) {
        this.gasStove = gasStove;
    }

    public boolean isAirConditon() {
        return airConditon;
    }

    public void setAirConditon(boolean airConditon) {
        this.airConditon = airConditon;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isTelevision() {
        return television;
    }

    public void setTelevision(boolean television) {
        this.television = television;
    }

    public boolean isHeaterWater() {
        return heaterWater;
    }

    public void setHeaterWater(boolean heaterWater) {
        this.heaterWater = heaterWater;
    }

    public boolean isAlarmDevice() {
        return alarmDevice;
    }

    public void setAlarmDevice(boolean alarmDevice) {
        this.alarmDevice = alarmDevice;
    }

    public static List<Utilities> getListUtilitiesExample(){
        Utilities utilities1 = newInstance(true, false, true, false, true,true);
        Utilities utilities2 = newInstance(false, true,true, true, false,true);
        Utilities utilities3 = newInstance(false, true, true,false,true,true);
        Utilities utilities4 = newInstance(true,true,true,false,false,true);
        Utilities utilities5 = newInstance(false,true,false,false,false,false);
        List<Utilities> utilitiesList = new ArrayList<>();
        utilitiesList.add(utilities1);
        utilitiesList.add(utilities2);
        utilitiesList.add(utilities3);
        utilitiesList.add(utilities4);
        utilitiesList.add(utilities5);
        return utilitiesList;
    }
}
