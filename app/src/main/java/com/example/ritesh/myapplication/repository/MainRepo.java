package com.example.ritesh.myapplication.repository;

import com.example.ritesh.myapplication.dao.City;

import java.util.ArrayList;

public class MainRepo {
    private static MainRepo mInstance;

    private MainRepo(){

    }

    public static MainRepo getInstance(){
        if(mInstance == null){
            mInstance = new MainRepo();
            return mInstance;
        }

        return mInstance;
    }

    public ArrayList<City> getCityList(){
        ArrayList<City> list = new ArrayList<>();
        list.add(new City(1,"Delhi"));
        list.add(new City(2,"Noida"));
        list.add(new City(3,"Gurgaon"));
        list.add(new City(4,"Banglore"));
        list.add(new City(5,"Pune"));

        return list;
    }
}
