package com.bw.zidingyi_huaban;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Bitmap mbmCopy;
    private Canvas mCanvas;
    Button red,green,big;
    private ImageView iv;
    private int mStartX;
    private int mStartY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red=findViewById(R.id.red);
        green=findViewById(R.id.green);
        big=findViewById(R.id.big);
        //加载原图
        Bitmap bmSrc = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        //创建白纸,宽高图片的参数
        mbmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
        //创建画板,参数就是白纸对象
        mCanvas = new Canvas(mbmCopy);
        //创建画笔
        final Paint paint = new Paint();

        //在纸上进行作画
        mCanvas.drawBitmap(bmSrc,new Matrix(),paint);
        //初始化控件
        iv = findViewById(R.id.iv);


        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.RED);
            }
        });


        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.GREEN);
            }
        });
        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setStrokeWidth(10);
            }
        });

        ////////////////////////手势识别器和画笔的结合使用/////////////////////////////
        iv.setOnTouchListener(new View.OnTouchListener() {//用户和屏幕交互的事件,实际就分为三种类型,三种类型分别是?
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){//我们画画,实际就是获取咱们按下的坐标,然后再滑动的时候,不断获取滑动的坐标,把这些坐标绘制起来,就是画画
                    case MotionEvent.ACTION_DOWN://按下时回调
                        //获取用户手指按下的坐标
                        mStartX = (int) event.getX();
                        mStartY = (int) event.getY();
                        Log.i("MainActivity","mStartX: "+mStartX +"  "+"mStartY:"+mStartY);
                        break;
                    case MotionEvent.ACTION_MOVE://手指滑动时,不停的调用
                        int newX = (int) event.getX();
                        int newY = (int) event.getY();
                        Log.i("MainActivity","newX:"+newX +"  "+"newY:"+newY);

                        //通过画板和画笔,使我们的起始坐标和终点坐标连成一条线
                        mCanvas.drawLine(mStartX,mStartY,newX,newY,paint);
                        //我们把起始点中按下的坐标,改为移动坐标,修改我们起始点的坐标就可以解决这个BUG
                        mStartX=newX;
                        mStartY=newY;
                        //设置给我们的ImageVIew
                        iv.setImageBitmap(mbmCopy);
                        break;
                    case MotionEvent.ACTION_UP://手指松开的时候回调
                        break;
                }
                //事件分发,false不处理触摸事件,向上传递,ture
                return true;
            }
        });


    }
}
