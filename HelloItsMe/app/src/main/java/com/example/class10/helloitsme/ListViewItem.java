package com.example.class10.helloitsme;

import android.support.annotation.Nullable;

public class ListViewItem {
    private  int icon;
    private String name;

    public ListViewItem(@Nullable int icon, String name) {

        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }
}

