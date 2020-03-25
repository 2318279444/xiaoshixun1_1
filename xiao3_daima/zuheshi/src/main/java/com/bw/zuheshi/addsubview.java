package com.bw.zuheshi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
 *@auther:邓先超
 *@Date: 2020/3/5
 *@Time:8:55
 *@Description:
 **/
public class addsubview extends FrameLayout {
    //Java中使用,创建对象的时候回调
    public addsubview(@NonNull Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.addview, this);
        View jia = inflate.findViewById(R.id.jia);
        View jian = inflate.findViewById(R.id.jian);
        View shu = inflate.findViewById(R.id.shu);
    }

    //xml中,在自定义控件的时候回调
    public addsubview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //在消灭了中,且定义了style风格中
    public addsubview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
