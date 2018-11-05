package com.example.ritesh.myapplication.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.ritesh.myapplication.dao.City;
import com.example.ritesh.myapplication.databinding.ActivityMainBinding;
import com.example.ritesh.myapplication.viewmodel.MainActivityViewModel;
import com.example.ritesh.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainViewModel;
    private ActivityMainBinding mBinding;

    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.txt)
    TextView txt;
    @BindView(R.id.chk)
    CheckBox chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ButterKnife.bind(this);

        mainViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        populateSpinner();

//        mBinding.setSpinnerAdapter(city);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void populateSpinner() {
        ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, mainViewModel.getCityList());
        mBinding.setSpinnerAdapter(adapter);
//        spinner.setAdapter(sAdapter);
    }

    public void onCheckChanged(CompoundButton buttonView, boolean isChecked) {
        City city = new City(3, "TEST Selection");
        mBinding.setCity(city);
    }

}
