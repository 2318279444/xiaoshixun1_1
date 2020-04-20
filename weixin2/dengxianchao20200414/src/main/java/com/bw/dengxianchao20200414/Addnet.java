package com.bw.dengxianchao20200414;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Addnet extends LinearLayout {
    TextView jia,shu,jian;

    public Addnet(Context context) {
        super(context);
    }

    public Addnet(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_addnet, this);
        jia=view.findViewById(R.id.jia);
        shu=view.findViewById(R.id.shu);
        jian=view.findViewById(R.id.jian);

        jia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String shu = Addnet.this.shu.getText().toString().trim();
                Integer number = Integer.valueOf(shu);
                number++;
                addCall.onClick(number);

            }
        });


        jian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String shu = Addnet.this.shu.getText().toString().trim();
                Integer number = Integer.valueOf(shu);
                if(number>1){
                    number--;
                }else {
                    Toast.makeText(context, "不可以减了", Toast.LENGTH_SHORT).show();

                }

                addCall.onClick(number);

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

     public void setnumber(int number){
         shu.setText(number+"");
     }

}
