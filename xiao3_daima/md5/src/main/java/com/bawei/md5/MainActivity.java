package com.bawei.md5;

import androidx.appcompat.app.AppCompatActivity;

/** 注意模拟有可能请求不到
 * 使用okhttp,请求需要参数为时间戳,MD5签名的Post请求,才能拿到数据企业级流程
 * 向服务器请求加密数据,本质和Post带参数的格式一样,只是Post所携带的参数需要我们费些心思去处理一下
 *
 * 1.得到客户端加密数据所需要的密钥,一般找后台的哥们要一下即可,这里是Api类中的PRIVATE_KEY
 * 2.一遍加密参数,经MD5工具类处理,方可得到,不同公司的工具类会有不同,所以找服务端的哥们要一下即可,这里就是商机头条 SignUtils 类
 * 3.服务器的接口文档里也标明时间戳是必须有的参数,所以我们通过java工具类得到时间戳
 * 4.这里的服务器为保证数据更安全,所以对数据MD5值有时间限制,一分钟内有效,因此我们生成MD5值,要使用时间戳生成
 * 5.必有的MD5参数和时间戳参数存在了,就使用okhttp的Post请求即可,配置OKhttp的环境,进行请求代码的编写,完成此案例
 *
 * 提示:在参数处理完后,不要先用OKhttp请求,而是先用postMan测试一下
 *
 * 接口文档     http://www.28zhanb.com/showdoc/index.php?s=/41&page_id=480
 密码sjtt666
 */
public class MainActivity extends AppCompatActivity {

    //需要加密参数方可以请求的Json数据网址,有有效时长
//    private String categoryUrl ="https://toutiao.28.com/App/Business/category_list";

    private String categoryUrl = "https://toutiao.28.com/App/BusinessOpportunity/banner_list";

    //B.需要传多个参数,登录这一块的网址
    //private String categoryUrl ="https://toutiao.28.com/App/Public/login";

//    //MD5签名后的字符串
//    private String sign;
//    private TextView mTextView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        mTextView =(TextView) findViewById(R.id.textView);
//    }
//
//    public void md5Date(View view) {
//        //获取时间戳,并转化为服务器规定的字符串格式
//        long time = new Date().getTime();
//
////        long time = new Date().getTime() / 1000;
//        String shiJianCuo = String.valueOf(time);
//
//        //使用一个集合,传入服务器规定的格式,以及所需数据
//        HashMap<String, String> map = new HashMap<>();
//
//
//        //B.如果后续还需要什么产生都放入该集合中,比如请求登录所需的参数
///*        map.put("mobile", "13681462126");
//        map.put("password", "1270304478");
//        map.put("type","login");*/
//
//        //服务器规定的键,一个单词都不能错
//        map.put("timestamp", shiJianCuo);
//
//
//        //使用MD5工具类,加密数据
//        try {
//
//            sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);
//            //在参数处理完后,不要先用OKhttp请求,而是先用postMan测试一下
//            Log.d("ycf", "shiJianCuo    :"+shiJianCuo);
//            Log.d("ycf", sign);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //加密所需参数没有问题后(先用PostMan测试),使用okhttpPost请求数据
//        //1.0 创建okhttpClinet
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
//
//        //设置Post请求的请求体,这里的键是服务器规定的格式,一个单词都不能错,如果不清楚看接口文档或问后台
//        FormBody formBody = new FormBody.Builder()
//                .add("timestamp", shiJianCuo).add("sign", sign)
//                .build();
//
//        //设置请求的网址
//        final Request request = new Request.Builder()
//                .post(formBody)
//                .url(categoryUrl)
//                .build();
//
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                //打印出从服务器请求的数据
//                final String date= response.body().string();
//                Log.d("ycf",date);
//                System.out.println("从服务器获取的数据"+date);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mTextView.setText(date);
//                    }
//                });
//            }
//        });
//
//    }
}
