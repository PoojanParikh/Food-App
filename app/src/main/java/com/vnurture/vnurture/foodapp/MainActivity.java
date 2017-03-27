package com.vnurture.vnurture.foodapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<FoodModel> modelFood;
    ArrayList<VegNonVegModel> vnvModelFood;
    boolean allSelected;
    
    ActionBar actionBar;
    
    LinearLayout selectAllLayout;
    CheckBox checkBox_selectAll;
    TextView selectAll_text;
    Menu menu;

    CustomAdapter adapter;

    //CustomAdapterFood adapterFood;

    /*final static String[] name = new String[]{"Domino's", "Pizza Hut", "Hamfoos", "US Pizza", "Mc Donalds", "Subway", "Havmor", "Chocolate Room"};
    final static String[] address = new String[]{"Rajkot", "Vadodara", "Ahmedabad", "Surendranagar", "Limbdi", "Surat", "Bhavnagar", "Gandhinagar"};
    final static String[] contact = new String[]{"9876543210", "9076543218", "9654321807", "9054321876", "9043218765", "8765432109", "7654321098", "8654321097"};*/

    final static int[] logo = new int[]{R.drawable.dominos_logo, R.drawable.pizza_hut_food_logo, R.drawable.hamfoos1, R.drawable.us_pizza, R.drawable.subway_logo_opt, R.drawable.havmor, R.drawable.chocolate_room_opt};

    final static int food[] = new int[]{R.drawable.veg_non_veg_con_01, R.drawable.veg_non_veg_con_02};

    final static Bitmap[] foodScaledImage = new Bitmap[food.length];

    final static Bitmap[] scaledImage = new Bitmap[logo.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // image scaling

        for(int i = 0; i < logo.length ; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),logo[i]);
            scaledImage[i] = scaleImage(bitmap);
        }

        for(int i = 0; i < food.length ; i++) {
            Bitmap bitmapFood = BitmapFactory.decodeResource(getResources(),food[i]);
            foodScaledImage[i] = scaleImage(bitmapFood);
        }
        
        actionBar = getSupportActionBar();
        setDefaultActionBar();

        if(ObjectHolder.foodModelArrayList==null){

            ObjectHolder.foodModelArrayList = new ArrayList<>();

        }
        listView = (ListView) findViewById(R.id.list_view);

        selectAllLayout = (LinearLayout) findViewById(R.id.select_all_layout_view);
        checkBox_selectAll = (CheckBox) findViewById(R.id.selectAll_checkBox);
        selectAll_text = (TextView) findViewById(R.id.selectAll_text);

        modelFood = arrayListMethod();
        vnvModelFood = vnvMethod();
        adapter = new CustomAdapter(this,modelFood,selectAllLayout);

        listView.setAdapter(adapter);




       //adapterFood = new CustomAdapterFood(this,vnvModelFood);




        selectAll_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allSelected){
                    unSelectAll();
                    checkBox_selectAll.setChecked(false);
                }
                else{
                    selectAll();
                    checkBox_selectAll.setChecked(true);
                }
            }
        });
        
        checkBox_selectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    selectAll();
                }
                else{
                    unSelectAll();
                }
            }
        });
        
}

    private void selectAll() {
        if(ObjectHolder.foodModelArrayList.size()>0){

            ObjectHolder.foodModelArrayList.clear();

        }

        for(int i=0;i<modelFood.size();i++){

            modelFood.get(i).setSelected(true);

        }

        adapter = new CustomAdapter(this,modelFood,selectAllLayout);
        listView.setAdapter(adapter);

        ObjectHolder.foodModelArrayList.addAll(modelFood);

        allSelected = true;

    }

    private void unSelectAll(){

        for(int i = 0; i<modelFood.size();i++){

            modelFood.get(i).setSelected(false);

        }

        adapter = new CustomAdapter(this,modelFood,selectAllLayout);
        listView.setAdapter(adapter);

        ObjectHolder.foodModelArrayList.removeAll(modelFood);

        selectAllLayout.setVisibility(View.GONE);

    }

    private void setDefaultActionBar(){

        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private ArrayList<FoodModel> arrayListMethod(){

        ArrayList<FoodModel> arrayListFoodModel = new ArrayList<>();

        FoodModel dominos = new FoodModel();
        dominos.setName("Dominos");
        dominos.setAddress("Ahmedabad");
        dominos.setContact("9876543210");
        //dominos.setFood(R.drawable.veg_non_veg_con_01);
        dominos.setLogo(scaledImage[0]);

        FoodModel pizzaHut = new FoodModel();
        pizzaHut.setName("Pizza Hut");
        pizzaHut.setAddress("Ahmedabad");
        pizzaHut.setContact("9876543210");
        //pizzaHut.setFood(R.drawable.veg_non_veg_con_01);
        pizzaHut.setLogo(scaledImage[1]);

        FoodModel subway = new FoodModel();
        subway.setName("Subway");
        subway.setAddress("Ahmedabad");
        subway.setContact("9876543210");
        //subway.setFood(R.drawable.veg_non_veg_con_01);
        subway.setLogo(scaledImage[2]);

        FoodModel hamfoos = new FoodModel();
        hamfoos.setName("Hamfoos");
        hamfoos.setAddress("Ahmedabad");
        hamfoos.setContact("9876543210");
        //hamfoos.setFood(R.drawable.veg_non_veg_con_01);
        hamfoos.setLogo(scaledImage[3]);

        FoodModel usPizza = new FoodModel();
        usPizza.setName("US Pizza");
        usPizza.setAddress("Ahmedabad");
        usPizza.setContact("9876543210");
        //usPizza.setFood(R.drawable.veg_non_veg_con_01);
        usPizza.setLogo(scaledImage[4]);

        FoodModel havmor = new FoodModel();
        havmor.setName("Havmor");
        havmor.setAddress("Ahmedabad");
        havmor.setContact("9876543210");
        //havmor.setFood(R.drawable.veg_non_veg_con_01);
        havmor.setLogo(scaledImage[5]);

        FoodModel chocolateRoom = new FoodModel();
        chocolateRoom.setName("Chocolate Room");
        chocolateRoom.setAddress("Ahmedabad");
        chocolateRoom.setContact("9876543210");
        //chocolateRoom.setFood(R.drawable.veg_non_veg_con_01);
        chocolateRoom.setLogo(scaledImage[6]);

        arrayListFoodModel.add(dominos);
        arrayListFoodModel.add(pizzaHut);
        arrayListFoodModel.add(subway);
        arrayListFoodModel.add(hamfoos);
        arrayListFoodModel.add(usPizza);
        arrayListFoodModel.add(havmor);
        arrayListFoodModel.add(chocolateRoom);

        return arrayListFoodModel;

    }

    private ArrayList<VegNonVegModel> vnvMethod(){

        ArrayList<VegNonVegModel> vegNonVegModelArrayList = new ArrayList<>();

        VegNonVegModel vegModel = new VegNonVegModel();
        vegModel.setFood(foodScaledImage[0]);

        VegNonVegModel nonVegModel = new VegNonVegModel();
        nonVegModel.setFood(foodScaledImage[1]);


        vegNonVegModelArrayList.add(vegModel);
        vegNonVegModelArrayList.add(nonVegModel);

        return vegNonVegModelArrayList;
    }

    public static Bitmap scaleImage(Bitmap rawBitmap){

        int nh = (int)(rawBitmap.getHeight()*(32.0/rawBitmap.getWidth()));

        return Bitmap.createScaledBitmap(rawBitmap,32,nh,true);
    }


}
