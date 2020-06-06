package com.example.sampleapp.ui.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.sampleapp.R;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public int[] imageArray = {
            R.drawable.laptop_1, R.drawable.laptop_3, R.drawable.laptop_4, R.drawable.laptop_5,
            R.drawable.laptop_6, R.drawable.laptop_7, R.drawable.laptop_8, R.drawable.laptop_9, R.drawable.laptop_10
    };

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340, 340));

        return imageView;
    }
}
