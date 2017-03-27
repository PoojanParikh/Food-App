/*package com.vnurture.vnurture.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class CustomAdapterFood extends BaseAdapter {

    ArrayList<VegNonVegModel> vegNonVegModels;
    LayoutInflater inflaterFood;
    Context contextFood;

    CustomAdapterFood(Context contextFood, ArrayList<VegNonVegModel> vegNonVegModels){

        this.contextFood=contextFood;
        this.vegNonVegModels=vegNonVegModels;


    }

    @Override
    public int getCount() {
        return vegNonVegModels.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        CustomAdapter.ViewHolder viewHolder = new CustomAdapter.ViewHolder();

        if(view==null){

            inflaterFood = (LayoutInflater) contextFood.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflaterFood.inflate(R.layout.single_row_list_view, viewGroup, false);

            viewHolder.trademarkLayout = (LinearLayout) view.findViewById(R.id.layout_food);

        viewHolder.trademarkLayout.removeAllViews();
        for (int n = 0; n < 2; n++) {

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(80, 80);
            ImageView imageFood = new ImageView(contextFood);
            imageFood.setLayoutParams(params);
            imageFood.setImageBitmap(vegNonVegModels.get(n).getFood());
            Picasso.with(contextFood).load(MainActivity.food[n]).into(viewHolder.venderFood);
//            linearLayout.addView(imageFood);
            viewHolder.trademarkLayout.addView(imageFood);

            }
        }


        //viewHolder.venderFood.setImageBitmap(vegNonVegModels.get(i).getFood());


        return view;
    }
}*/
