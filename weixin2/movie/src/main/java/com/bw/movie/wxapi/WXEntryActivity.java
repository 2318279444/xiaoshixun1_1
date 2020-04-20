package com.bw.movie.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.MainActivity;
import com.bw.movie.R;
import com.bw.movie.flzc.wx.MyApp;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import java.util.HashMap;

import bean.MyBean.WxBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private static final int RETURN_MSG_TYPE_LOGIN = 1;
    private static final int RETURN_MSG_TYPE_SHARE = 2;
    private HashMap<String, Object> map;
    private String sessionId;
    private String code;
    private String cstime;
    private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxentry);

        //如果没回调onResp，八成是这句没有写
        MyApp.mWxApi.handleIntent(getIntent(), this);


        NetUtil.getInstance().Net_WX(MyUrl.Base_WX, WxBean.class, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                WxBean wxBean = gson.fromJson(stra, WxBean.class);
                sessionId = wxBean.getResult().getSessionId();
                String headPic = wxBean.getResult().getUserInfo().getHeadPic();
                String nickName = wxBean.getResult().getUserInfo().getNickName();
                int userId = wxBean.getResult().getUserId();
                Log.e("aaa","wxuserid:"+userId);
                int sexx = wxBean.getResult().getUserInfo().getSex();
                sex = String.valueOf(sexx);
                long lastLoginTime = wxBean.getResult().getUserInfo().getLastLoginTime();
                cstime = String.valueOf(lastLoginTime);
                String email="2318279444@qq.com";
                Log.e("aaa","微信sessionId外"+ sessionId);
                Intent intent = new Intent(WXEntryActivity.this, MainActivity.class);
                intent.putExtra("sessionId",sessionId);
                intent.putExtra("headPic",headPic);
                intent.putExtra("nickName",nickName);
                intent.putExtra("sex", sex);
                intent.putExtra("cstime", cstime);
                intent.putExtra("email",email);
                Log.e("aaa","微信登录sessionId:"+sessionId);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        switch (baseResp.errCode) {

            case BaseResp.ErrCode.ERR_AUTH_DENIED:
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                if (RETURN_MSG_TYPE_SHARE == baseResp.getType()) {
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case BaseResp.ErrCode.ERR_OK:
                switch (baseResp.getType()) {
                    case RETURN_MSG_TYPE_LOGIN:
                        //拿到了微信返回的code,立马再去请求access_token
                        code = ((SendAuth.Resp) baseResp).code;
                        //就在这个地方，用网络库什么的或者自己封的网络api，发请求去咯，注意是get请求
                        map = new HashMap<>();
                        map.put("code", code);

                        Log.e("aaa","code:"+code);


                        break;
                    case RETURN_MSG_TYPE_SHARE:
                        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                }
                break;

        }
    }
}
