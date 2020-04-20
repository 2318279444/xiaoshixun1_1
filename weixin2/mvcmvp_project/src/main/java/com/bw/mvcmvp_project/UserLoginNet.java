package com.bw.mvcmvp_project;

import android.os.SystemClock;

public class UserLoginNet {
    /**
     * 做网络请求的封装,把模拟网络请求代码给粘贴过来
     */

    public boolean sendUserLoginINfo(User user){
        //模拟耗时操作
        SystemClock.sleep(2000);

        //对用户输入的信息进行判断
        if ("ycf".equals(user.username) &&"ycf".equals(user.password)){
            //登录成功,谈吐司
            return true;
        }
        else{
            //登录失败,谈吐司
            return false;
        }
    }
}
