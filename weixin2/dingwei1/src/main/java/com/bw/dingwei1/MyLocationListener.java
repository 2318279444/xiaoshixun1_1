package com.bw.dingwei1;

import android.location.Location;
import android.util.Log;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;

/**
 * 功能：MyLocationListener类
 * 作者：闫圣豪
 * 当前日期：2020/4/3
 * 当前时间：17:03
 */
public class MyLocationListener extends BDAbstractLocationListener {
    @Override
    public void onReceiveLocation(BDLocation location) {
        //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
        //以下只列举部分获取地址相关的结果信息
        //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
        String addr = location.getAddrStr();    //获取详细地址信息
        String country = location.getCountry();    //获取国家
        String province = location.getProvince();    //获取省份
        String city = location.getCity();    //获取城市
        String district = location.getDistrict();    //获取区县
        String street = location.getStreet();    //获取街道信息
        String adcode = location.getAdCode();    //获取adcode
        String town = location.getTown();    //获取乡镇信息

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();


        float radius = location.getRadius();
        String coorType = location.getCoorType();
        int locType = location.getLocType();
        Log.i("xxx","获取详细地址信息--"
                +addr+"获取国家--"+country+"获取省份--"
                +province+"获取城市--"+city+"获取区县--"
                +district+"获取街道信息--"+street
                +"获取adcode--"+adcode
                +"获取乡镇信息--"+town);
    }
}
