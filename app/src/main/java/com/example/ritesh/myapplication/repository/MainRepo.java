package com.example.ritesh.myapplication.repository;

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

    public ArrayList<String> getCityList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Delhi");
        list.add("Noida");
        list.add("Gurgaon");
        list.add("Banglore");
        list.add("Pune");

        return list;
    }
}
