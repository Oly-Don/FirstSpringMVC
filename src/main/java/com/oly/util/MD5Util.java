package com.oly.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String EncoderByMd5(String str) {
            if (str == null) {
                return null;
            }
            try {
            /*    // 确定计算方法
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                BASE64Encoder base64en = new BASE64Encoder();
                // 加密后的字符串
                return base64en.encode(md5.digest(str.getBytes("utf-8")));*/
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] digest = messageDigest.digest(str.getBytes("utf-8"));
                return new String(byte2Hex(digest));
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
        }
    }

    private static String byte2Hex(byte[] bytedatas)
    {
        char chars[] = "0123456789ABCDEF".toCharArray();
        StringBuffer sbf = new StringBuffer();
        for (byte bytedata : bytedatas)
        {
            sbf.append(chars[(bytedata & 0xF0) >> 4]).append(chars[(bytedata & 0x0F)]);
        }
        return sbf.toString();
    }

}
