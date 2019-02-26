package com.example.class10.helloitsme.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.class10.helloitsme.MessageAdapter;
import com.example.class10.helloitsme.R;
import com.example.class10.helloitsme.CallAdapter;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView_call, recyclerView_mesage;
    CardView cardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // ### Call List RecyclerView adapter ###
        recyclerView_call = (RecyclerView) view.findViewById(R.id.home_recyclerView_call);
        CallAdapter callAdapter = new CallAdapter();
        recyclerView_call.setAdapter(callAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView_call.setLayoutManager(layoutManager);

        // ### Message List RecyclerView adapter ###
        recyclerView_mesage = (RecyclerView) view.findViewById(R.id.home_recyclerView_message);
        MessageAdapter messageAdapter = new MessageAdapter();
        recyclerView_mesage.setAdapter(messageAdapter);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        recyclerView_mesage.setLayoutManager(layoutManager1);


        return view;

    }


}
