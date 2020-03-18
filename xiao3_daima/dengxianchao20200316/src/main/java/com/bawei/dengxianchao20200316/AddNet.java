package com.bawei.dengxianchao20200316;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AddNet extends LinearLayout {
    TextView jia,shu,jian;

    public AddNet(Context context) {
        super(context);
    }

    public AddNet(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_add_net, this);
        jia=view.findViewById(R.id.jia);
        shu=view.findViewById(R.id.shu);
        jian=view.findViewById(R.id.jian);

        jia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s = shu.getText().toString().trim();
                Integer number = Integer.valueOf(s);
                number++;
                toAddCall.onClick(number);
            }
        });


        jian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s = shu.getText().toString().trim();
                Integer number = Integer.valueOf(s);
                if(number>1){
                    number++;
                    toAddCall.onClick(number);
                }else {
                    Toast.makeText(context, "不可以减少了", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }


    public interface ToAddCall{
        void onClick(int number);
    }

    public ToAddCall toAddCall;

    public void setToAddCall(ToAddCall toAddCall){
        this.toAddCall=toAddCall;
    }

    public void setnumber(int number){
        shu.setText(number+"");
    }


}
