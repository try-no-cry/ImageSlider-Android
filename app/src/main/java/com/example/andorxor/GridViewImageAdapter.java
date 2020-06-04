package com.example.andorxor;

 import android.content.Context;

 import android.content.Intent;
 import android.os.Bundle;
 import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class GridViewImageAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater inflater;
    private ArrayList<SingleGridCard> images;
    private int imageWidth;

    public GridViewImageAdapter(Context context, ArrayList<SingleGridCard> images,
                                int imageWidth) {
        this.context=context;
        this.images = images;
        this.imageWidth = imageWidth;
     }

    @Override
    public int getCount() {
        return this.images.size();
    }

    @Override
    public Object getItem(int position) {
        return this.images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(inflater==null)
        {
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.grid_row_item,null);
        }

        ImageView imageView=convertView.findViewById(R.id.grid_image);
        TextView tv=convertView.findViewById(R.id.grid_text);

        Glide.with(context).load(images.get(position).getImageUrl()).into(imageView);
        tv.setText(images.get(position).getCaption());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,FullScreenLayout.class);
                intent.putExtra("position",position);

                intent.putExtra("images",images);
                context.startActivity(intent);
            }
        });

        return convertView;

    }


    /*
     * Resizing image size
     */
//    public static Bitmap decodeFile(String filePath, int WIDTH, int HIGHT) {
//        try {
//
//            File f = new File(filePath);
//
//            BitmapFactory.Options o = new BitmapFactory.Options();
//            o.inJustDecodeBounds = true;
//            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
//
//            final int REQUIRED_WIDTH = WIDTH;
//            final int REQUIRED_HIGHT = HIGHT;
//            int scale = 1;
//            while (o.outWidth / scale / 2 >= REQUIRED_WIDTH
//                    && o.outHeight / scale / 2 >= REQUIRED_HIGHT)
//                scale *= 2;
//
//            BitmapFactory.Options o2 = new BitmapFactory.Options();
//            o2.inSampleSize = scale;
//            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


}
