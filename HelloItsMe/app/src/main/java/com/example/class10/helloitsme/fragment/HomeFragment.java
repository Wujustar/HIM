package com.example.class10.helloitsme.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.class10.helloitsme.CallRecyclerViewAdapter;
import com.example.class10.helloitsme.MessageRecyclerViewAdapter;
import com.example.class10.helloitsme.R;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView_call, recyclerView_mesage;
    LinearLayout lnl_call, lnl_message;
    ImageView home_fBtn_my, home_fBtn_call_up, home_fBtn_call_down, home_fBtn_mesage;
    int fBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);




        // ### Call List RecyclerView adapter ###
        recyclerView_call = (RecyclerView) view.findViewById(R.id.home_recyclerView_call);
        CallRecyclerViewAdapter callAdapter = new CallRecyclerViewAdapter();
        recyclerView_call.setAdapter(callAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView_call.setLayoutManager(layoutManager);

        // ### Message List RecyclerView adapter ###
        recyclerView_mesage = (RecyclerView) view.findViewById(R.id.home_recyclerView_message);
        MessageRecyclerViewAdapter messageAdapter = new MessageRecyclerViewAdapter();
        recyclerView_mesage.setAdapter(messageAdapter);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        recyclerView_mesage.setLayoutManager(layoutManager1);

        // ### call and message Recyclerview's ParentLayout ###
        lnl_call = (LinearLayout) view.findViewById(R.id.lnl_call);
        lnl_message = (LinearLayout) view.findViewById(R.id.lnl_message);

        // ### Fold Buttons ###
        home_fBtn_call_up = (ImageView) view.findViewById(R.id.home_fBtn_call_up);
        home_fBtn_call_down = (ImageView) view.findViewById(R.id.home_fBtn_call_down);

        home_fBtn_call_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView_call.setVisibility(View.GONE);
                home_fBtn_call_down.setVisibility(View.VISIBLE);

            }
        });
        home_fBtn_call_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView_call.setVisibility(View.VISIBLE);
                home_fBtn_call_down.setVisibility(View.INVISIBLE);
            }
        });


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("save", 0);
        fBtn = sharedPreferences.getInt("save_fBtn", 0);
        if(fBtn == 1){
            showAll();
        }
        if(fBtn == 2){
            showAll();
            hideMessage();
        }
        if(fBtn == 3){
            showAll();
            hideCall();
        }
    }

    public void showAll(){
        lnl_call.setVisibility(View.VISIBLE);
        lnl_message.setVisibility(View.VISIBLE);
    }

    public void hideCall(){
        lnl_call.setVisibility(View.GONE);
    }

    public void hideMessage(){
        lnl_message.setVisibility(View.GONE);
    }



}
