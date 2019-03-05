package com.example.class10.helloitsme.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.class10.helloitsme.R;

public class MessageRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public MessageRecyclerViewAdapter() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;




                view = View.inflate(viewGroup.getContext(), R.layout.home_recyclerview_message_items, null);

                view.setOnClickListener(onClickListener);


//            case 1:
//                view = View.inflate(viewGroup.getContext(), R.layout.home_recyclerview_message_items, null);
//                viewHolder = new MessageViewHolder(view);
//                break;



        return new MessageViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {

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






