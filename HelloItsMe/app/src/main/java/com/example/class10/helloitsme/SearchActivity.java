package com.example.class10.helloitsme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.class10.helloitsme.adapter.MyRecyclerViewAdapter;

public class SearchActivity extends AppCompatActivity {
    ImageView search_iv_prev;
    RecyclerView recyclerView_contact;
    private static final int CONTACT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_iv_prev = (ImageView) findViewById(R.id.search_iv_prev);
        search_iv_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        MyRecyclerViewAdapter contactRecyclerViewAdapter = new MyRecyclerViewAdapter(2);
        recyclerView_contact = (RecyclerView) findViewById(R.id.search_recyclerView_contact);
        recyclerView_contact.setAdapter(contactRecyclerViewAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView_contact.setLayoutManager(layoutManager);

        ItemClickSupport.addTo(recyclerView_contact, R.id.item_click_support_contact).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Toast.makeText(SearchActivity.this, position + "번째 숏클릭", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
