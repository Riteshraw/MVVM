package com.example.ritesh.myapplication.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.ritesh.myapplication.dao.City;
import com.example.ritesh.myapplication.viewmodel.MainActivityViewModel;
import com.example.ritesh.myapplication.R;
import com.example.ritesh.myapplication.databinding.ActivityMainBinding;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainViewModel;

    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.txt)
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ButterKnife.bind(this);

        mainViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
//        populateSpinner();

        City city = new City(1, "Test");
        binding.setCity(city);

    }

    private void populateSpinner() {
        SpinnerAdapter sAdapter = null;
        spinner.setAdapter(sAdapter);
    }

    private void onCheckChange(){

    }

}
