package com.bw.rikaoday1_02_21;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class AddLocation extends LinearLayout {
    EditText person,phone,location,dizhi,bm;

    public AddLocation(Context context) {
        super(context);
    }

    public AddLocation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_add_location, this);
        person=view.findViewById(R.id.person);
        phone=view.findViewById(R.id.phone);
        location=view.findViewById(R.id.location);
        dizhi=view.findViewById(R.id.dizhi);
        bm=view.findViewById(R.id.bm);

    }

    public AddLocation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
