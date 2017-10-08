package com.example.jesusizquierdo.toyota.dialogFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jesusizquierdo.toyota.CarListActivity;
import com.example.jesusizquierdo.toyota.Nfc;
import com.example.jesusizquierdo.toyota.R;
import com.example.jesusizquierdo.toyota.classes.Car;

/**
 * Created by Jesus Izquierdo on 10/8/2017.
 */

public class AddCarDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.custom_car_received, null);

        ImageView caImage = (ImageView) v.findViewById(R.id.imageView_for_car_received);
        TextView name = (TextView) v.findViewById(R.id.tv_name_car_received);
        TextView engine = (TextView) v.findViewById(R.id.tv_engine_car_received);
        TextView packages = (TextView) v.findViewById(R.id.tvf_package_car_received);

        Button add = (Button) v.findViewById(R.id.btn_add_from_nfc);

Bundle bundle = getArguments();
String model = bundle.getString("model");
        String engineS = bundle.getString("engine");
        String packagesS = bundle.getString("package");
        int color = bundle.getInt("color");

caImage.setImageResource(color);
        name.setText(model);
        engine.setText(engineS);
        packages.setText(packagesS);
        final Car car = new Car(model,engineS,color,packagesS);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Nfc)getContext()).saveCar(car);
                ((Nfc)getContext()).startActivity(new Intent(getContext(), CarListActivity.class));
                dismiss();
            }
        });


        builder.setView(v);
        return builder.create();

    }
}
