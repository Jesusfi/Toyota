package com.example.jesusizquierdo.toyota.rvadapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jesusizquierdo.toyota.R;

import java.util.ArrayList;

/**
 * Created by Jesus Izquierdo on 10/7/2017.
 */

public class ColorRvAdapter extends RecyclerView.Adapter<ColorRvAdapter.ViewHolder> {

    Context context;
    ArrayList<Integer> color;
    public ColorRvAdapter(Context context, ArrayList<Integer> color){
        this.context = context;
        this.color = color;
    }
    @Override
    public ColorRvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_image_builder, parent, false);
        return new ColorRvAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ColorRvAdapter.ViewHolder holder, int position) {
        int intColor = color.get(position);
        holder.car.setImageResource(intColor);
    }

    @Override
    public int getItemCount() {
        return color.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView car;
        public ViewHolder(View itemView) {
            super(itemView);
            car = (ImageView) itemView.findViewById(R.id.imageView_for_rv_color);

        }
    }
}
