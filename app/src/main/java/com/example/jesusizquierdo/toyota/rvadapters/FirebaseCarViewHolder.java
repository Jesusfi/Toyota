package com.example.jesusizquierdo.toyota.rvadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jesusizquierdo.toyota.R;
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
        TextView name = (TextView) itemView.findViewById(R.id.tv_name_firebaseui);
        TextView engine = (TextView) itemView.findViewById(R.id.tv_engine_firebaseui);
        TextView carPackage = (TextView) itemView.findViewById(R.id.tvf_package_firebaseui);
        ImageView carImage = (ImageView) itemView.findViewById(R.id.imageView_for_firebaseui);

        name.setText(car.getModel());
        engine.setText(car.getConfiguration());
        carPackage.setText(car.getCarPackage());
        carImage.setImageResource(car.getColor());
    }

    @Override
    public void onClick(View view) {

    }
}
