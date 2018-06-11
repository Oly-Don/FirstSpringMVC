package com.oly.set.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/5/31.
 */
public class Base64Util {

    /**
     * base64 编码级别加密，非对称算法
     *
     * @param key
     * @return
     */
    public static String encryptBASE64(String key) {
        byte[] bytes = key.getBytes();
        String encode = new BASE64Encoder().encodeBuffer(bytes);
        return encode;
    }

    /**
     * base64 解密
     * @param key
     * @return
     */
    public static String decryptBASE64(String key) {
        String decrytekey = null;
        try {
            byte[] bytes = key.getBytes();
            bytes = (new BASE64Decoder()).decodeBuffer(key);
            decrytekey = new String(bytes, "gbk");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decrytekey;
    }


}
