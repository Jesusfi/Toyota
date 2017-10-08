package com.example.jesusizquierdo.toyota.rvadapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jesusizquierdo.toyota.CarListActivity;
import com.example.jesusizquierdo.toyota.Nfc;
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
    public void bindCar(final Car car){
        final TextView name = (TextView) itemView.findViewById(R.id.tv_name_firebaseui);
        final TextView engine = (TextView) itemView.findViewById(R.id.tv_engine_firebaseui);
        final TextView carPackage = (TextView) itemView.findViewById(R.id.tvf_package_firebaseui);
        final ImageView carImage = (ImageView) itemView.findViewById(R.id.imageView_for_firebaseui);
        Button shareNFC = (Button) itemView.findViewById(R.id.btn_share_nfc);

        shareNFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,Nfc.class);
                intent.putExtra("get", 1);

                intent.putExtra("model", car.getModel());
                intent.putExtra("engine", car.getConfiguration());
                intent.putExtra("package",car.getCarPackage());
                intent.putExtra("color", car.getColor());


                ((CarListActivity)mContext).startActivity(intent);
                //((CarListActivity)mContext).startActivity(new Intent(mContext, Nfc.class));
            }
        });
        name.setText(car.getModel());
        engine.setText(car.getConfiguration());
        carPackage.setText(car.getCarPackage());
        carImage.setImageResource(car.getColor());
    }

    @Override
    public void onClick(View view) {

    }
}
