package cn.lxh.java;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 *JAVA实现GBK,UTF-8与中文互转
 */
public class EncodeAndDecode {// \ue1e4
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(URLDecoder.decode("%C4%FA%D4%DA2015-09-30+10%3A40%3A29%B5%C7%C2%BC%CF%B5%CD%B3%B5%C4%B6%AF%CC%AC%C3%DC%C2%EB%CE%AA%A3%BA456237%2CIP%A3%BA10.30.2.55", "GBK"));// GBK编码转中文
        System.out.println(URLEncoder.encode("中文国际", "GBK")); // 中文编码转GBK
        System.out.println(URLDecoder.decode("%E4%B8%AD%E6%96%87%E5%9B%BD%E9%99%85", "UTF-8"));// UTF-8编码转中文
        System.out.println(URLEncoder.encode("中文国际", "UTF-8")); // UTF-8编码转中文
    }
}
