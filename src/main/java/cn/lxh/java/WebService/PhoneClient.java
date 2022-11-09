package cn.lxh.java.WebService;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

/**
 * http请求
 * Created by starlin
 * on 2016/01/06 11:23.
 */
public class PhoneClient {
    public static void main(String[] args) throws IOException {
        //创建浏览器对象
        HttpClient httpClient = new HttpClient();
        //填写数据，发送get或者post请求
//        GetMethod getMethod = new GetMethod("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=13909161860");
//        int code = httpClient.executeMethod(getMethod);
//        System.out.println("状态码：" + code);
//        String result = getMethod.getResponseBodyAsString();
//        System.out.println("返回的结果：" + result);

        //填写数据，发送post请求
        PostMethod postMethod = new PostMethod("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm");
        postMethod.setParameter("tel","13909161860");
        int code = httpClient.executeMethod(postMethod);
        System.out.println("状态码：" + code);
        String result = postMethod.getResponseBodyAsString();
        System.out.println("返回的结果：" + result);
    }
}
