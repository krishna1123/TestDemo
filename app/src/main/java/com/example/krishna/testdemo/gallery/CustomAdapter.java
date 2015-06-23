package com.example.krishna.testdemo.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.krishna.testdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by krishna on 23/6/15.
 */
public class CustomAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private ArrayList<String> list;

    public CustomAdapter(Context context, ArrayList<String> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.updateView(list.get(position));
        return convertView;
    }

    static class ViewHolder {
        ImageView ivImage;

        ViewHolder(View view) {
            ivImage = (ImageView) view.findViewById(R.id.iv_item);
        }

        void updateView(String path) {

            Picasso.with(ivImage.getContext())
                    .load("file://" + path)
                    .placeholder(R.drawable.weather)
                    .centerInside()
                    .resize(width, height)
                    .into(ivImage);
        }

        void updateView(String path, int rotation) {

            Picasso.with(ivImage.getContext())
                    .load("file://" + path)
                    .rotate(rotation)
                    .placeholder(R.drawable.weather)
                    .centerInside()
                    .resize(width, height)
                    .into(ivImage);
        }

        final int width = 400;
        final int height = 400;
    }
}
