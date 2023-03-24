package com.example.final_project;

import android.content.Context;

import androidx.appcompat.widget.AppCompatTextView;

public class UpperTextView extends AppCompatTextView {
    public UpperTextView(Context context) {
        super(context);
        metka = false;
        specBn = -1;

    }

    boolean metka;
    int specBn;
}
