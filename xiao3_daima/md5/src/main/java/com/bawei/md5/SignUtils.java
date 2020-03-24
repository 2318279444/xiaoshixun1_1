package com.bawei.md5;

/*
 *@auther:邓先超
 *@Date: 2020/3/24
 *@Time:14:37
 *@Description:
 **/

import java.io.IOException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * MD5加密工具类,在网上可以搜索到通用的
 * 把需要加密MD5加密的数据,调用方法,把数据传入其中,得到返回结果就是一样加密好符合服务器要求的数据,直接上传即可
 */
public class SignUtils {
    /**
     * @param params 需要进行加密的集合数据
     * @param key    加密所需的密钥,这个密钥公司已经提供好,粘贴复制过来即可
     * @return       加密后的字符串
     */
    public static String getSignature(Map<String, String> params, String key) throws IOException {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<String, String>(params);
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();

        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder basestring = new StringBuilder();
        int indx = 0;
        for (Map.Entry<String, String> param : entrys) {

            if (param.getValue() != null && !"".equals(param.getValue())) {
                basestring.append(param.getKey()).append("=").append(URLEncoder.encode(param.getValue(),"utf-8"));
            }
            if (indx < (params.size() - 1)) {
                basestring.append("&");
            }
            indx++;
        }

        //basestring.append("&key=" + key);
        basestring.append(key);
        System.out.println("MD5加密前=" + basestring.toString());
        String sign = getMD5(basestring.toString());
        System.out.println("MD5加密后="+sign.toUpperCase().toString());
        return sign.toUpperCase();
    }

    private static final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'};

    public static String getMD5(String inStr) {
        byte[] inStrBytes = inStr.getBytes();
        try {
            MessageDigest MD = MessageDigest.getInstance("MD5");
            MD.update(inStrBytes);
            byte[] mdByte = MD.digest();
            char[] str = new char[mdByte.length * 2];
            int k = 0;
            for (int i = 0; i < mdByte.length; i++) {
                byte temp = mdByte[i];
                str[k++] = hexDigits[temp >>> 4 & 0xf];
                str[k++] = hexDigits[temp & 0xf];
            }
            return new String(str).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
