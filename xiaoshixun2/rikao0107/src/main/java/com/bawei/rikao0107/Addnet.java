package com.bawei.rikao0107;

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
    TextView jia,shu,jian;
    public Addnet(Context context) {
        super(context);
    }

    public Addnet(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_addnet, this);
        jia=view.findViewById(R.id.jia);
        shu=view.findViewById(R.id.shu);
        jian=view.findViewById(R.id.jian);

        jia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String string = shu.getText().toString();
                Integer number = Integer.valueOf(string);
                number++;
                jiajianCall.onClick(number);

            }
        });

        jian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String string = shu.getText().toString();
                Integer number = Integer.valueOf(string);
                if(number>1){
                    number--;
                    jiajianCall.onClick(number);
                }else {
                    Toast.makeText(context, "不可以在减了", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    public interface JiajianCall{
        void onClick(int number);
    }

    public JiajianCall jiajianCall;

    public void setJiajianCall(JiajianCall jiajianCall){
        this.jiajianCall=jiajianCall;
    }


    public void setnumber(int number){
        shu.setText(number+"");
    }

}
