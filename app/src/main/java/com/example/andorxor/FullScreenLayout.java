package com.example.andorxor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class FullScreenLayout extends AppCompatActivity implements Serializable {
int initialPosition=0;
    ViewPager viewPager;
    private  ArrayList<SingleGridCard > images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_layout);


        initialPosition=getIntent().getIntExtra("position",0);

                viewPager =  findViewById(R.id.viewPager);



        Bundle bundle = getIntent().getExtras();
        images = (ArrayList<SingleGridCard>) bundle.getSerializable("images");

       ImageAdapter adapter=new ImageAdapter(FullScreenLayout.this,images,initialPosition);

        viewPager.setAdapter(adapter);

//        viewPager.setCurrentItem(initialPosition)

        viewPager.post(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(initialPosition);
            }
        });






    }
}
