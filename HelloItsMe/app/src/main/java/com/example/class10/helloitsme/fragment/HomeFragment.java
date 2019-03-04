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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.class10.helloitsme.CallRecyclerViewAdapter;
import com.example.class10.helloitsme.ItemClickSupport;
import com.example.class10.helloitsme.MessageRecyclerViewAdapter;
import com.example.class10.helloitsme.R;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView_call, recyclerView_message;
    LinearLayout lnl_call_bar, lnl_message_bar;
    RelativeLayout rl_myState;
    ImageView home_fBtn_my_up, home_fBtn_my_down,
            home_fBtn_call_up, home_fBtn_call_down,
            home_fBtn_message_up, home_fBtn_message_down;
    int fBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        lnl_call_bar = (LinearLayout) view.findViewById(R.id.lnl_call_bar);
        lnl_message_bar = (LinearLayout)view.findViewById(R.id.lnl_message_bar);
        recyclerView_call = (RecyclerView) view.findViewById(R.id.home_recyclerView_call);
        recyclerView_message = (RecyclerView) view.findViewById(R.id.home_recyclerView_message);


        //### RecyclerView Click Listener

        ItemClickSupport.addTo(recyclerView_call, R.id.item_click_support_call).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Toast.makeText(v.getContext(), position + "번 숏클릭", Toast.LENGTH_SHORT).show();
            }
        });



        ItemClickSupport.addTo(recyclerView_message, R.id.item_click_support_message).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Toast.makeText(v.getContext(), position + "번 숏클릭", Toast.LENGTH_SHORT).show();
            }
        });



        // ### Call List RecyclerView adapter ###

        CallRecyclerViewAdapter callAdapter = new CallRecyclerViewAdapter();
        recyclerView_call.setAdapter(callAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView_call.setLayoutManager(layoutManager);

        // ### Message List RecyclerView adapter ###

        MessageRecyclerViewAdapter messageAdapter = new MessageRecyclerViewAdapter();
        recyclerView_message.setAdapter(messageAdapter);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        recyclerView_message.setLayoutManager(layoutManager1);

        // ### Call and message Recyclerview's ParentLayout to Show and Hide recyclerView###
//        lnl_call = (LinearLayout) view.findViewById(R.id.lnl_call);
//        lnl_message = (LinearLayout) view.findViewById(R.id.lnl_message);

        // ### Fold Buttons ###
        rl_myState = (RelativeLayout) view.findViewById(R.id.rl_myState);
        home_fBtn_my_up = (ImageView) view.findViewById(R.id.home_fBtn_my_up);
        home_fBtn_my_down = (ImageView) view.findViewById(R.id.home_fBtn_my_down);
        home_fBtn_call_up = (ImageView) view.findViewById(R.id.home_fBtn_call_up);
        home_fBtn_call_down = (ImageView) view.findViewById(R.id.home_fBtn_call_down);
        home_fBtn_message_up = (ImageView) view.findViewById(R.id.home_fBtn_message_up);
        home_fBtn_message_down = (ImageView) view.findViewById(R.id.home_fBtn_message_down);


        foldContent();

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
        lnl_call_bar.setVisibility(View.VISIBLE);
        recyclerView_call.setVisibility(View.VISIBLE);
        lnl_message_bar.setVisibility(View.VISIBLE);
        recyclerView_message.setVisibility(View.VISIBLE);
        home_fBtn_my_down.setVisibility(View.INVISIBLE);
        home_fBtn_call_down.setVisibility(View.INVISIBLE);
        home_fBtn_message_down.setVisibility(View.INVISIBLE);

    }

    public void hideCall(){
        lnl_call_bar.setVisibility(View.GONE);
        recyclerView_call.setVisibility(View.GONE);
        home_fBtn_my_down.setVisibility(View.INVISIBLE);
        home_fBtn_call_down.setVisibility(View.INVISIBLE);
        home_fBtn_message_down.setVisibility(View.INVISIBLE);
    }

    public void hideMessage(){
        lnl_message_bar.setVisibility(View.GONE);
        recyclerView_message.setVisibility(View.GONE);
        home_fBtn_my_down.setVisibility(View.INVISIBLE);
        home_fBtn_call_down.setVisibility(View.INVISIBLE);
        home_fBtn_message_down.setVisibility(View.INVISIBLE);
    }



    public void foldContent(){
        home_fBtn_my_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl_myState.setVisibility(View.GONE);
                home_fBtn_my_down.setVisibility(View.VISIBLE);

            }
        });
        home_fBtn_my_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl_myState.setVisibility(View.VISIBLE);
                home_fBtn_my_down.setVisibility(View.INVISIBLE);
            }
        });

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

        home_fBtn_message_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView_message.setVisibility(View.GONE);
                home_fBtn_message_down.setVisibility(View.VISIBLE);



            }
        });
        home_fBtn_message_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView_message.setVisibility(View.VISIBLE);
                home_fBtn_message_down.setVisibility(View.INVISIBLE);



            }
        });

    }


}
