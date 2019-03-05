package com.example.class10.helloitsme.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.class10.helloitsme.R;

import org.w3c.dom.Text;

public class CallRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    public CallRecyclerViewAdapter() {


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;


        view = View.inflate(viewGroup.getContext(), R.layout.home_recyclerview_call_items, null);
        viewHolder = new CallViewHolder(view);



        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder callViewHolder, int position) {

    }



    @Override
    public int getItemCount() {
        return 10;
    }


    static class CallViewHolder extends RecyclerView.ViewHolder {
        ImageView call_receive, call_call;
        TextView call_name, call_number, call_time;


        public CallViewHolder(View view) {
            super(view);

            call_receive = (ImageView) view.findViewById(R.id.call_receive);
            call_call = (ImageView) view.findViewById(R.id.call_call);
            call_name = (TextView) view.findViewById(R.id.call_name);
            call_number = (TextView) view.findViewById(R.id.call_number);
            call_time = (TextView) view.findViewById(R.id.call_time);
        }


        }
    }









