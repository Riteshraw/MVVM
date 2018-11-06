package com.example.ritesh.myapplication.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ritesh.myapplication.adapter.CustomSpinnerAdapter;
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

        MyClickHandlers handlers = new MyClickHandlers(this);
        mBinding.setHandlers(handlers);

    }

    private void populateSpinner() {
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, R.layout.layout_custom_spinner, mainViewModel.getCityList());
        mBinding.setSpinnerAdapter(adapter);
//        spinner.setAdapter(adapter);
    }

    public class MyClickHandlers {
        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }


        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position != 0) {
                mBinding.setCity(new City(position, "" + position + "\n " + id));
            }
        }

        public void onNothingSelected(AdapterView<?> parent) {

        }

        public void onCheckChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked)
                mBinding.setCity(new City(2, "Checked"));
            else
                mBinding.setCity(new City(0, "UnChecked"));
        }

        public void onSpinnerClick(View view, City city) {
            if (city != null)
                mBinding.setCity(new City(2, "Checked"));
            else
                mBinding.setCity(new City(0, "UnChecked"));
        }

    }

}
