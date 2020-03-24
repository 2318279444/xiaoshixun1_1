package com.bawei.md5;

/*
 *@auther:邓先超
 *@Date: 2020/3/24
 *@Time:14:37
 *@Description:
 **/
public class Api {
    //true代表生产环境 false代表测试环境
    //真实项目,一般在项目没有上线前,为保证项目的安全,使用测试环境开发,为IP地址,当项目上线后,切换为生产环境
    //提示:生产环境一般为公司的域名
    public static boolean isDebug=true;
    public static String testUrl="http://192.168.199.248";
    public static String lineUrl="https://toutiao.28.com";

    public static String baseUrl(){
        return isDebug==true?lineUrl:testUrl;
    }
    public static String url=baseUrl();

    //客户端提供好的加密密钥
    public static String PRIVATE_KEY="2074509615ee2557631024d80fd7a1a2";

//    public static String PRIVATE_KEY="192006250b4c09247ec02edce69f6a2d";

}
