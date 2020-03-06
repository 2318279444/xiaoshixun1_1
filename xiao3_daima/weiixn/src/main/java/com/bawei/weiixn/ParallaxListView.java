package com.bawei.weiixn;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ListView;

/*
 *@auther:邓先超
 *@Date: 2020/3/6
 *@Time:13:43
 *@Description:
 **/
public class ParallaxListView extends ListView {
    //在Java代码中使用回调
    public ParallaxListView(Context context) {
        super(context);
    }

    //在XML中使用回调
    public ParallaxListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //在XML中使用且带有样式的时候会进行回调
    public ParallaxListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ImageView iv_header;

    public void setIv_header(ImageView iv_header){
        this.iv_header =iv_header;
    }

    /**
     *滑动ListView到两端,进行滑动,才会被回调
     * @param deltaY:顶部下拉-,上拉为+
     * @param isTouchEvent:是否用户触摸拉动,true就是表示用户手指拉动,false带来的值,是惯性带来的
     * @return
     */
    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

//        System.out.println("deltaY:"+deltaY+"  "+"isTouchEvent"+isTouchEvent);

        //顶部下拉,用户触摸的操作才执行,而且是用户主动触摸不是惯性带来的下拉
        if(deltaY <0 && isTouchEvent){//"&"和"&&"区别
            //deleY是负值,我们要改为绝对值,累加到我们iv_header的高度上
            int newHeight = iv_header.getHeight() + Math.abs(deltaY);

            //把新的高度值负值给控件,改变控件的高度
            iv_header.getLayoutParams().height=newHeight;
            iv_header.requestLayout();

        }

        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }
}
