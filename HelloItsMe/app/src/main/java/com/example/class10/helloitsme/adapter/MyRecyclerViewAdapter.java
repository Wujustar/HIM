package com.example.class10.helloitsme.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.class10.helloitsme.R;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int viewNum;
    private static final int HOME_CALL = 0;
    private static final int HOME_MESSAGE = 1;
    private static final int CONTACT = 2;

    public MyRecyclerViewAdapter(int viewNum) {
        this.viewNum = viewNum;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (viewNum) {
            case HOME_CALL :
                view = View.inflate(viewGroup.getContext(), R.layout.home_recyclerview_call_items, null);
                return new CallViewHolder(view);

            case HOME_MESSAGE :
                view = View.inflate(viewGroup.getContext(), R.layout.home_recyclerview_message_items, null);
                return new MessageViewHolder(view);

            case CONTACT :
                view = View.inflate(viewGroup.getContext(), R.layout.contact_recyclerview_contact_items, null);
                return new ContactViewHolder(view);

        }


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewNum) {
            case HOME_CALL :


            case HOME_MESSAGE :


        }
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    private static class CallViewHolder extends RecyclerView.ViewHolder {
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

    private static class MessageViewHolder extends RecyclerView.ViewHolder {
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

    private static class ContactViewHolder extends RecyclerView.ViewHolder {
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
