package com.bawei.week0111_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Addnet extends LinearLayout {
    TextView jia,jian,shu;

    public Addnet(Context context) {
        super(context);
    }

    public Addnet(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        View view = LayoutInflater.from(context).inflate(R.layout.activity_addnet, this);
        jia=view.findViewById(R.id.jia);
        jian=view.findViewById(R.id.jian);
        shu=view.findViewById(R.id.shu);


        jia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String string = shu.getText().toString();
                Integer number = Integer.valueOf(string);
                number++;
                jiajianqi.onClick(number);
            }
        });



        jian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String string = shu.getText().toString();
                Integer number = Integer.valueOf(string);
                if(number>1){
                    number--;
                    jiajianqi.onClick(number);
                }else {
                    Toast.makeText(context, "不可以在减少了", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    public interface Jiajianqi{
        void onClick(int number);
    }

    public Jiajianqi jiajianqi;

    public void setJiajianqi(Jiajianqi jiajianqi){
        this.jiajianqi=jiajianqi;
    }


    public void setnumber(int number){
        shu.setText(number+"");
    }

}
