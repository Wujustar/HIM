package com.example.class10.helloitsme.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.class10.helloitsme.DeveloperActivity;
import com.example.class10.helloitsme.SearchActivity;
import com.example.class10.helloitsme.SettingsActivity;
import com.example.class10.helloitsme.ItemClickSupport;
import com.example.class10.helloitsme.R;
import com.example.class10.helloitsme.adapter.MyRecyclerViewAdapter;

public class HomeFragment extends Fragment {
    ImageView home_iv_search, home_iv_logo, home_iv_menu;
    View menu_filter_view;
    RecyclerView recyclerView_call, recyclerView_message;
    LinearLayout lnl_call_bar, lnl_message_bar;
    RelativeLayout rl_myState;
    ImageView home_fBtn_my_up, home_fBtn_my_down,
            home_fBtn_call_up, home_fBtn_call_down,
            home_fBtn_message_up, home_fBtn_message_down;
    static final int HOME_CALL = 0;
    static final int HOME_MESSAGE = 1;
    int fBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // ### Control Search Button on Toolbar ###


        home_iv_search = (ImageView) view.findViewById(R.id.home_iv_search);
        home_iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.activity_anim_not_move, R.anim.activity_anim_not_move);
            }
        });

        // ### Control Menu Button on Toolbar (using PopUpMenu) ###
        home_iv_menu = (ImageView) view.findViewById(R.id.home_iv_menu);
        home_iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getContext(), v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.main_menu_display:
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                menu_filter_view = View.inflate(getContext(), R.layout.menu_filter, null);
                                final RadioButton menu_filter_both = (RadioButton) menu_filter_view.findViewById(R.id.menu_filter_both);
                                final RadioButton menu_filter_call = (RadioButton) menu_filter_view.findViewById(R.id.menu_filter_call);
                                final RadioButton menu_filter_message = (RadioButton) menu_filter_view.findViewById(R.id.menu_filter_message);
                                menu_filter_both.setChecked(true);
                                builder.setTitle("화면 편집")
                                        .setView(menu_filter_view)
                                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        })
                                        .setPositiveButton("적용", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                                if(menu_filter_both.isChecked()){
                                                    showAll();
                                                    fBtn = 1;

                                                }else if(menu_filter_call.isChecked()){
                                                    showAll();
                                                    hideMessage();
                                                    fBtn = 2;

                                                }else if(menu_filter_message.isChecked()){
                                                    showAll();
                                                    hideCall();
                                                    fBtn = 3;
                                                }
                                            }
                                        })
                                        .show();
                                break;
                            case R.id.main_menu_developer:
                                Intent intentDev = new Intent(getActivity(), DeveloperActivity.class);
                                startActivity(intentDev);
                                break;
                            case R.id.main_menu_settings:
                                Intent intentSet = new Intent(getActivity(), SettingsActivity.class);
                                startActivity(intentSet);
                                break;
                        }

                        return false;
                    }
                });
                popupMenu.inflate(R.menu.main_menu);
                popupMenu.show();
            }
        });






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

        MyRecyclerViewAdapter callAdapter = new MyRecyclerViewAdapter(0);
        recyclerView_call.setAdapter(callAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView_call.setLayoutManager(layoutManager);

        // ### Message List RecyclerView adapter ###

        MyRecyclerViewAdapter messageAdapter = new MyRecyclerViewAdapter(1);
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
    @Override
    public void onPause() {
        super.onPause();
        Log.d("life", "포즈");
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("save", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("save_fBtn", fBtn);
        editor.commit();

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
