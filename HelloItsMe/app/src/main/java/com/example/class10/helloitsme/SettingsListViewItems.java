package com.example.class10.helloitsme;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;

public class SettingsListViewItems {
    private Drawable icon;
    private String title;
    private String text;

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Drawable getIcon() {

        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
