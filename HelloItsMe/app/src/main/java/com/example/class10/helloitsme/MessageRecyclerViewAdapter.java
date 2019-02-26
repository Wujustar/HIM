package com.example.class10.helloitsme;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public MessageRecyclerViewAdapter() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;



                view = View.inflate(viewGroup.getContext(), R.layout.home_recyclerview_message_items, null);
                viewHolder = new MessageViewHolder(view);


//            case 1:
//                view = View.inflate(viewGroup.getContext(), R.layout.home_recyclerview_message_items, null);
//                viewHolder = new MessageViewHolder(view);
//                break;



        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    private class MessageViewHolder extends RecyclerView.ViewHolder {
        ImageView message_call;
        TextView message_name, message_content, message_time;
        public MessageViewHolder(View view) {
            super(view);
            message_call = (ImageView) view.findViewById(R.id.message_call);
            message_name = (TextView) view.findViewById(R.id.message_name);
            message_content = (TextView) view.findViewById(R.id.message_content);
            message_time = (TextView) view.findViewById(R.id.call_time);

        }
    }




}






