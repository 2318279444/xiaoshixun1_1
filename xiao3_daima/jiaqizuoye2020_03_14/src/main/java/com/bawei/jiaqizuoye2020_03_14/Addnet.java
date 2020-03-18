package com.bawei.jiaqizuoye2020_03_14;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Addnet extends LinearLayout {

    TextView jia,jian,shu;

    public Addnet(Context context) {
        super(context);
    }

    public Addnet(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_addnet, this);
        jia=view.findViewById(R.id.jia);
        jian=view.findViewById(R.id.jian);
        shu=view.findViewById(R.id.shu);

        jia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s = shu.getText().toString().trim();
                Integer number = Integer.valueOf(s);
                number++;
                addCall.onClick(number);
            }
        });

        jian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s = shu.getText().toString().trim();
                Integer number = Integer.valueOf(s);
                if (number>1){
                    number--;
                    addCall.onClick(number);
                }else {
                    Toast.makeText(context, "不可以再减少了", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public interface AddCall{
        void onClick(int number);
    }

    public AddCall addCall;

    public void setAddCall(AddCall addCall){
        this.addCall=addCall;
    }

    public void setNumber(int number){
        shu.setText(number+"");
    }


}
