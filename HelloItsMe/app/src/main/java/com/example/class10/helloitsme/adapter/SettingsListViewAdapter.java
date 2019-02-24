package com.example.class10.helloitsme.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.class10.helloitsme.R;
import com.example.class10.helloitsme.SettingsListViewItems;

import java.util.ArrayList;

public class SettingsListViewAdapter extends BaseAdapter {

    private ArrayList<SettingsListViewItems> list = new ArrayList<>();
    public SettingsListViewAdapter(){

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.settings_listview_items, null);

        }
        ImageView settings_listView_iv = (ImageView) convertView.findViewById(R.id.settings_listView_iv);
        TextView settings_listView_title = (TextView) convertView.findViewById(R.id.settings_listView_title);
        TextView settings_listView_txt = (TextView) convertView.findViewById(R.id.settings_listView_txt);

        SettingsListViewItems listViewItems = list.get(position);
        settings_listView_iv.setImageDrawable(listViewItems.getIcon());
        settings_listView_title.setText(listViewItems.getTitle());
        settings_listView_txt.setText(listViewItems.getText());


//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, (position+1)+"번째 리스트가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });


        return convertView;
    }

    public void addData(Drawable icon, String title, String txt){
        SettingsListViewItems items = new SettingsListViewItems();

        items.setIcon(icon);
        items.setTitle(title);
        items.setText(txt);

        list.add(items);


    }
}
