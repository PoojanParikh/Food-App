package com.vnurture.vnurture.foodapp;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by VNurtureTechnologies on 30/12/16.
 */

public class CustomAdapter extends BaseAdapter {


    Context context;
    LayoutInflater inflater;
    ArrayList<FoodModel> arrayListFoodModel;
    ArrayList<VegNonVegModel> vegNonVegModels;
    LinearLayout selectAllLayout;


    CustomAdapter(Context context, ArrayList<FoodModel> arrayListFoodModel, LinearLayout selectAllLayout){

        this.context=context;
        this.arrayListFoodModel = arrayListFoodModel;
        this.selectAllLayout = selectAllLayout;

    }

    @Override
    public int getCount() {


        return arrayListFoodModel.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder{

        TextView venderName;
        TextView venderAddress;
        TextView venderContact;

        ImageView venderFood;
        ImageView venderLogo;
        LinearLayout trademarkLayout;
        CheckBox checkBoxOne;

    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();

        if(convertView==null){

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.single_row_list_view, parent, false);

            holder.venderName = (TextView) convertView.findViewById(R.id.textView_food);
            holder.venderAddress = (TextView) convertView.findViewById(R.id.textView_address);
            holder.venderContact = (TextView) convertView.findViewById(R.id.textView_phone);
            holder.venderLogo = (ImageView) convertView.findViewById(R.id.image_logo);
            holder.checkBoxOne = (CheckBox) convertView.findViewById(R.id.checkBox);
            holder.trademarkLayout=(LinearLayout) convertView.findViewById(R.id.layout_food);
            holder.trademarkLayout.removeAllViews();
            for (int n = 0; n < 2; n++) {

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(80, 80);
                ImageView imageFood = new ImageView(context);
                imageFood.setLayoutParams(params);
                imageFood.setImageBitmap(MainActivity.foodScaledImage[n]);
 //               Picasso.with(context).load(MainActivity.food[n]).into(holder.venderFood);
//            linearLayout.addView(imageFood);
                holder.trademarkLayout.addView(imageFood);

            }



            convertView.setTag(holder);

        }

        else{

            holder = (ViewHolder) convertView.getTag();

        }

        holder.venderName.setText(arrayListFoodModel.get(i).getName());
        holder.venderAddress.setText(arrayListFoodModel.get(i).getAddress());
        holder.venderContact.setText(arrayListFoodModel.get(i).getContact());
        holder.venderLogo.setImageBitmap(arrayListFoodModel.get(i).getLogo());
        Picasso.with(context).load(MainActivity.logo[i]).into(holder.venderLogo);

        holder.checkBoxOne.setOnCheckedChangeListener(null);
        holder.checkBoxOne.setChecked(arrayListFoodModel.get(i).isSelected());
        holder.checkBoxOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                arrayListFoodModel.get(i).setSelected(b);

                if(arrayListFoodModel.get(i).isSelected()){
                    ObjectHolder.foodModelArrayList.add(arrayListFoodModel.get(i));
                    Toast.makeText(context, "Selected : " +ObjectHolder.foodModelArrayList.size(), Toast.LENGTH_SHORT).show();
                }
                else{
                    ObjectHolder.foodModelArrayList.remove(arrayListFoodModel.get(i));
                    Toast.makeText(context, "Selected : " +ObjectHolder.foodModelArrayList.size(), Toast.LENGTH_SHORT).show();
                }

                if(ObjectHolder.foodModelArrayList.size()>0){
                    selectAllLayout.setVisibility(View.VISIBLE);
                }
                else{
                    selectAllLayout.setVisibility(View.GONE);
                }

            }
        });

        return convertView;
    }



}
