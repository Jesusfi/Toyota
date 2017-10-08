package com.example.jesusizquierdo.toyota.rvadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jesusizquierdo.toyota.CarSpecificsActivity;
import com.example.jesusizquierdo.toyota.R;
import com.example.jesusizquierdo.toyota.classes.Package;

import java.util.ArrayList;

/**
 * Created by Jesus Izquierdo on 10/7/2017.
 */

public class PackageRvAdapter extends RecyclerView.Adapter<PackageRvAdapter.MyViewHolder> {
    Context context;
    ArrayList<Package> packages;

    public PackageRvAdapter(Context context, ArrayList<Package> packages){
        this.context = context;
        this.packages = packages;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_package_custom, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Package aPackage = packages.get(position);
        holder.name.setText(aPackage.getName());
        holder.price.setText(aPackage.getPrice());
        holder.descriptionOfPackage.setText(aPackage.getDescription());


    }

    @Override
    public int getItemCount() {
        return packages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, descriptionOfPackage;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_rv_named);
            price = (TextView) itemView.findViewById(R.id.tv_rv_price);
            descriptionOfPackage = (TextView) itemView.findViewById(R.id.tv_rv_package);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Package aPackage = packages.get(getAdapterPosition());
                    ((CarSpecificsActivity)context).setPackages(aPackage.getName());
                }
            });
        }
    }
}
