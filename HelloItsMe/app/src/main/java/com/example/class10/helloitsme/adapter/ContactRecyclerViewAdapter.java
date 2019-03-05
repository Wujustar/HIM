package com.example.class10.helloitsme.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.class10.helloitsme.R;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;


        view = View.inflate(viewGroup.getContext(), R.layout.contact_recyclerview_contact_items, null);
        viewHolder = new ContactViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private class ContactViewHolder extends RecyclerView.ViewHolder {
        ImageView contact_group, contact_call;
        TextView contact_name, contact_number, contact_time;
        public ContactViewHolder(View view) {
            super(view);

            contact_group = (ImageView) view.findViewById(R.id.contact_group);
            contact_call = (ImageView) view.findViewById(R.id.contact_call);
            contact_name = (TextView) view.findViewById(R.id.contact_name);
            contact_number = (TextView) view.findViewById(R.id.contact_number);
            contact_time = (TextView) view.findViewById(R.id.contact_time);
        }
    }
}
