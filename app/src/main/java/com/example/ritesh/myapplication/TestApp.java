package com.example.ritesh.myapplication;

import android.app.Application;

import com.example.ritesh.myapplication.repository.MainRepo;

public class TestApp extends Application {
    private static TestApp mInstance;

    private TestApp() {
    }

    public static TestApp getInstance() {
        if (mInstance == null) {
            mInstance = new TestApp();;
            return mInstance;
        }

        return mInstance;
    }

    public MainRepo getMainRepoInstance() {
        return MainRepo.getInstance();
    }
}
