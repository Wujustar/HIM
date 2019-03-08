package com.example.class10.helloitsme.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.class10.helloitsme.MainActivity;
import com.example.class10.helloitsme.R;
import com.example.class10.helloitsme.SearchActivity;
import com.example.class10.helloitsme.TopDialogActivity;

public class ContactFragment extends Fragment {
    ImageView contact_iv_search, contact_iv_logo, contact_iv_menu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        contact_iv_search = (ImageView) view.findViewById(R.id.contact_iv_search);
        contact_iv_logo = (ImageView) view.findViewById(R.id.contact_iv_logo);
        contact_iv_menu = (ImageView) view.findViewById(R.id.contact_iv_menu);

        contact_iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.activity_anim_not_move, R.anim.activity_anim_not_move);
            }
        });

        contact_iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TopDialogActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }


}
