package com.bawei.jiaqizuoye111;

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
                String trim = shu.getText().toString().trim();
                Integer number = Integer.valueOf(trim);
                number++;
                addCallBack.onClick(number);
            }
        });






        jian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String trim = shu.getText().toString().trim();
                Integer number = Integer.valueOf(trim);
                if(number>1){
                    number--;
                    addCallBack.onClick(number);
                }else {
                    Toast.makeText(context, "不可以减了", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    public interface AddCallBack{
        void onClick(int number);
    }

    public AddCallBack addCallBack;

    public void setAddCallBack(AddCallBack addCallBack){
        this.addCallBack=addCallBack;
    }

    public void setnumber(int number){
        shu.setText(number+"");
    }
}
