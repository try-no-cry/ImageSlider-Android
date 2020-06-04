package com.example.andorxor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ArrayList<SingleGridCard> images = new ArrayList<SingleGridCard>();
    private GridViewImageAdapter adapter;
    private GridView gridView;
    private int columnWidth;
    // Number of columns of Grid View
    public static final int NUM_OF_COLUMNS = 3;

    // Gridview image padding
    public static final int GRID_PADDING = 8; // in dp

    // SD card image directory
    public static final String PHOTO_ALBUM = "NAT";

    // supported file formats
    public static final List<String> FILE_EXTN = Arrays.asList("jpg", "jpeg",
            "png");

    ArrayList<String > imageCaptions=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView =findViewById(R.id.grid_view);


        // Initilizing Grid View
        InitilizeGridLayout();

        // loading all image paths from SD card
        images.add(new SingleGridCard("https://i.pinimg.com/originals/aa/ce/b9/aaceb9fa55a1721a813ae7dac2af281a.jpg","image1"));
        images.add(new SingleGridCard("https://i.pinimg.com/736x/b3/6f/6f/b36f6f18b54dac9bde5be0e6b1cecb89.jpg","image2"));
        images.add(new SingleGridCard("https://i.ytimg.com/vi/fyQuyvpBweA/maxresdefault.jpg","image2"));
        images.add(new SingleGridCard("https://324503-1138418-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads/2020/04/bdjnadsmxzs41-1-300x257.jpg","image3"));
        images.add(new SingleGridCard("https://dramarthacastronoriegatijuana.files.wordpress.com/2020/03/batman.jpg?w=225","image4"));




        // Gridview adapter
        adapter = new GridViewImageAdapter(MainActivity.this, images,columnWidth);

        // setting grid view adapter
        gridView.setAdapter(adapter);







    }


    private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                GRID_PADDING, r.getDisplayMetrics());

        columnWidth = (int) ((getScreenWidth() - ((NUM_OF_COLUMNS + 1) * padding)) / NUM_OF_COLUMNS);

        gridView.setNumColumns(NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding,
                (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }


    public int getScreenWidth() {
        int columnWidth;
        WindowManager wm = (WindowManager) MainActivity.this
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        final Point point = new Point();
        try {
            display.getSize(point);
        } catch (java.lang.NoSuchMethodError ignore) { // Older device
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        columnWidth = point.x;
        return columnWidth;
    }
}
