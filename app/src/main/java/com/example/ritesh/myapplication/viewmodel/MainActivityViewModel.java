package com.example.ritesh.myapplication.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.ritesh.myapplication.repository.MainRepo;
import com.example.ritesh.myapplication.TestApp;

public class MainActivityViewModel extends AndroidViewModel {
    private final MainRepo mainRepo;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        TestApp testApp = TestApp.getInstance();
        mainRepo = testApp.getMainRepoInstance();
    }

    public void getCityList(){
        mainRepo.getCityList();
    }

}