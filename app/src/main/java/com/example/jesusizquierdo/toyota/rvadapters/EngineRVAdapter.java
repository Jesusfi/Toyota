package com.example.jesusizquierdo.toyota.rvadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jesusizquierdo.toyota.R;
import com.example.jesusizquierdo.toyota.classes.Engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus Izquierdo on 10/7/2017.
 */

public class EngineRVAdapter extends RecyclerView.Adapter<EngineRVAdapter.ViewHolder> {

    Context context;
    ArrayList<Engine> engines;
    public EngineRVAdapter (Context context, ArrayList<Engine> engines) {
        this.context = context;
        this.engines = engines;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_car_engine, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Engine engine = engines.get(position);
        holder.engineName.setText(engine.getName());
        holder.info1.setText(engine.getInfo1());
        holder.info2.setText(engine.getInfo2());
        holder.info3.setText(engine.getInfo3());
    }

    @Override
    public int getItemCount() {
        return engines.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView engineName, info1, info2, info3;
        public ViewHolder(View itemView) {
            super(itemView);
            engineName = (TextView) itemView.findViewById(R.id.tv_engine_name);
            info1 = (TextView) itemView.findViewById(R.id.tv_info1);
            info2 = (TextView) itemView.findViewById(R.id.tv_info2);
            info3 = (TextView) itemView.findViewById(R.id.tv_info3);
        }
    }
}
