package com.example.class10.helloitsme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.class10.helloitsme.ListViewItem;
import com.example.class10.helloitsme.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

class ListViewAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private  int layout;
    private ArrayList<ListViewItem> data;

    public ListViewAdapter(Context context, int layout, ArrayList<ListViewItem> data) {

        this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {

        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = View.inflate(parent.getContext(), R.layout.settings_listview_items, null);
        }
        ListViewItem listviewitem=data.get(position);

        ImageView icon=(ImageView)convertView.findViewById(R.id.settings_listView_iv);
        icon.setImageResource(listviewitem.getIcon());
        TextView name=(TextView)convertView.findViewById(R.id.settings_listView_txt);
        name.setText(listviewitem.getName());

        return convertView;

    }
}
