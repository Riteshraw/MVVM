package com.example.ritesh.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ritesh.myapplication.R;
import com.example.ritesh.myapplication.dao.City;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomSpinnerAdapter extends ArrayAdapter<City> {
    private final LayoutInflater mInflater;
    private final Context mContext;
    private final List<City> items;
    private final int mResource;

    @BindView(R.id.offer_type_txt)
    TextView offTypeTv;
    @BindView(R.id.max_discount_txt)
    TextView maxDiscTV;
    @BindView(R.id.num_offers_txt)
    TextView numOffersTv;

    public CustomSpinnerAdapter(Context context, int resource, List<City> objects) {
        super(context, resource, objects);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        items = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        final View view = mInflater.inflate(mResource, parent, false);
        ButterKnife.bind(this, view);

        City city = items.get(position);

        offTypeTv.setText("" + city.getId());
        numOffersTv.setText(city.getName());
        maxDiscTV.setText(city.getName());

        return view;
    }
}
