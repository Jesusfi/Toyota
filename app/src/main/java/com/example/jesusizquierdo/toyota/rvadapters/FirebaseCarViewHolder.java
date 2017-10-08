package com.example.jesusizquierdo.toyota.rvadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jesusizquierdo.toyota.classes.Car;

/**
 * Created by Jesus Izquierdo on 10/7/2017.
 */

public class FirebaseCarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    View mView;
    Context mContext;

    public FirebaseCarViewHolder(View itemView) {
        super(itemView);
        this.mContext = itemView.getContext();
        this.mView = itemView;
        itemView.setOnClickListener(this);
    }
    public void bindCar(Car car){

    }

    @Override
    public void onClick(View view) {

    }
}
