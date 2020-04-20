package com.bw.movie.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.MyApp;
import com.bw.movie.Tz2;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/*
 *@auther:邓先超
 *@Date: 2020/3/30
 *@Time:13:41
 *@Description:
 **/
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private SharedPreferences sp;

    private static final int RETURN_MSG_TYPE_LOGIN = 1;
    private static final int RETURN_MSG_TYPE_SHARE = 2;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_wxentry);
        MyApp.mWxApi.handleIntent(getIntent(),this);

        sp = getSharedPreferences("login.dp", MODE_PRIVATE);
    }
    @Override
    public void onReq(BaseReq baseReq) {
    }
    @Override
    public void onResp(BaseResp baseResp) {
        //登录回调
        switch (baseResp.errCode){
            case BaseResp.ErrCode.ERR_AUTH_DENIED://用户拒绝授权
            case BaseResp.ErrCode.ERR_USER_CANCEL://用户取消
                if (RETURN_MSG_TYPE_SHARE==baseResp.getType()){
                    Toast.makeText(this, "分享失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case BaseResp.ErrCode.ERR_OK:
                switch (baseResp.getType()){
                    case RETURN_MSG_TYPE_LOGIN:
                        //拿到了微信返回的code,立马再去请求access_token
                        code = ((SendAuth.Resp)baseResp).code;
                        if (TextUtils.isEmpty(code)){
                            code =getIntent().getStringExtra("_wxapi_sendauth_resp_token");
                        }
                        Log.i("wx_code", code);
                        //Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                        //就在这个地方，用网络库什么的或者自己封的网络api，发请求去咯，注意是get请求
                        Intent intent = new Intent(this, Tz2.class);
                        startActivity(intent);
                        break;
                    case RETURN_MSG_TYPE_SHARE:
                        Toast.makeText(this, "微信分享成功", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                }
                break;
        }
    }


}
