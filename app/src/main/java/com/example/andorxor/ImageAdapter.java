package com.example.andorxor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class ImageAdapter extends PagerAdapter implements Serializable {

    private Context context;
    private ArrayList<SingleGridCard> images;
    private int initialPosition;
    private boolean mFullyLoaded = false;

    ImageAdapter(Context context,ArrayList<SingleGridCard> images,int initialPosition)
    {
        this.context=context;
        this.images=images;
        this.initialPosition=initialPosition;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        RelativeLayout v= (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.full_screen_image_with_text,null);

        ImageView imageView=v.findViewById(R.id.full_screen_image);
        TextView imageCaption=v.findViewById(R.id.full_screen_text);
        imageCaption.setText(images.get(position).getCaption());

        Glide.with(context).load(images.get(position).getImageUrl()).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        container.addView(v);

        if (!mFullyLoaded && position == getCount() - 1) {
            mFullyLoaded = true;
            // "fully loaded"-code here
            setInitialPosition(initialPosition);

        }


        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((RelativeLayout) object);

    }

    public void setInitialPosition(int initialPosition) {
        this.initialPosition = initialPosition;
    }




}
