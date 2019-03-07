package com.example.class10.helloitsme.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.class10.helloitsme.R;

public class NotificatioinChildFragment1 extends Fragment {
    TextView noti_child_txt;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child_fragment_notification, container, false);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("phase", "자식1 프레그먼트 스타트");
    }
}
