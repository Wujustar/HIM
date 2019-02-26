package com.example.class10.helloitsme.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.class10.helloitsme.R;

public class NotificatioinChildFragment extends Fragment {
    TextView noti_child_txt;

    public static NotificatioinChildFragment newInstance(String num) {

        Bundle bundle = new Bundle();
        bundle.putString("position", num);

        NotificatioinChildFragment instance = new NotificatioinChildFragment();
        instance.setArguments(bundle);
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child_fragment_notification, container, false);
        noti_child_txt = (TextView) view.findViewById(R.id.noti_child_lnl_txt);
        noti_child_txt.setText(getArguments().getString("position"));

        return view;
    }
}
