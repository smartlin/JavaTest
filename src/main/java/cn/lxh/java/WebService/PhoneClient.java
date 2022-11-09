package cn.lxh.java.WebService;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

/**
 * http����
 * Created by starlin
 * on 2016/01/06 11:23.
 */
public class PhoneClient {
    public static void main(String[] args) throws IOException {
        //�������������
        HttpClient httpClient = new HttpClient();
        //��д���ݣ�����get����post����
//        GetMethod getMethod = new GetMethod("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=13909161860");
//        int code = httpClient.executeMethod(getMethod);
//        System.out.println("״̬�룺" + code);
//        String result = getMethod.getResponseBodyAsString();
//        System.out.println("���صĽ����" + result);

        //��д���ݣ�����post����
        PostMethod postMethod = new PostMethod("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm");
        postMethod.setParameter("tel","13909161860");
        int code = httpClient.executeMethod(postMethod);
        System.out.println("״̬�룺" + code);
        String result = postMethod.getResponseBodyAsString();
        System.out.println("���صĽ����" + result);
    }
}
