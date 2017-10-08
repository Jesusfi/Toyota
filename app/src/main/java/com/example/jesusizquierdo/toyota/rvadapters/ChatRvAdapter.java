package com.example.jesusizquierdo.toyota.rvadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jesusizquierdo.toyota.R;
import com.example.jesusizquierdo.toyota.classes.Messages;

import java.util.ArrayList;

/**
 * Created by Jesus Izquierdo on 10/8/2017.
 */

public class ChatRvAdapter extends RecyclerView.Adapter<ChatRvAdapter.MyViewHolder> {
    ArrayList<Messages> messages;
    Context context;

    public ChatRvAdapter(Context context, ArrayList<Messages> messages){
        this.context = context;
        this.messages = messages;
    }
    @Override
    public ChatRvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_rv_chat, parent, false);
        return new ChatRvAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChatRvAdapter.MyViewHolder holder, int position) {
        Messages messages1 = messages.get(position);
        holder.msg.setText(messages1.getMessage());
        holder.name.setText(messages1.getSender());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,msg;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name_chat);
            msg = (TextView) itemView.findViewById(R.id.tv_message_chat);

        }
    }
}
