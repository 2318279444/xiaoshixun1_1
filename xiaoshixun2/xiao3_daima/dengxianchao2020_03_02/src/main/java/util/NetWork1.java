package util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*
 *@auther:邓先超
 *@Date: 2020/3/27
 *@Time:13:44
 *@Description:
 **/
public class NetWork1 {

    public static boolean getConnection(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = manager.getActiveNetworkInfo();
        if(info!=null){
            return info.isConnected();
        }
        return false;
    }
}
