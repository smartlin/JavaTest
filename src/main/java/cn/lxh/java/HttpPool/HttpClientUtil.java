package cn.lxh.java.HttpPool;

import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * HttpClient������
 * 
 * @return
 * @author SHANHY
 * @create 2015��12��18��
 */
public class HttpClientUtil {

    static final int timeOut = 10 * 1000;

    private static CloseableHttpClient httpClient = null;

    private final static Object syncLock = new Object();

    private static void config(HttpRequestBase httpRequestBase) {
        // ����Header��
        // httpRequestBase.setHeader("User-Agent", "Mozilla/5.0");
        // httpRequestBase
        // .setHeader("Accept",
        // "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        // httpRequestBase.setHeader("Accept-Language",
        // "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");// "en-US,en;q=0.5");
        // httpRequestBase.setHeader("Accept-Charset",
        // "ISO-8859-1,utf-8,gbk,gb2312;q=0.7,*;q=0.7");

        // ��������ĳ�ʱ����
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(timeOut)
                .setConnectTimeout(timeOut).setSocketTimeout(timeOut).build();
        httpRequestBase.setConfig(requestConfig);
    }

    /**
     * ��ȡHttpClient����
     * 
     * @return
     * @author SHANHY
     * @create 2015��12��18��
     */
    public static CloseableHttpClient getHttpClient(String url) {
        String hostname = url.split("/")[2];
        int port = 80;
        if (hostname.contains(":")) {
            String[] arr = hostname.split(":");
            hostname = arr[0];
            port = Integer.parseInt(arr[1]);
        }
        if (httpClient == null) {
            synchronized (syncLock) {
                if (httpClient == null) {
                    httpClient = createHttpClient(200, 40, 100, hostname, port);
                }
            }
        }
        return httpClient;
    }

    /**
     * ����HttpClient����
     * 
     * @return
     * @author SHANHY
     * @create 2015��12��18��
     */
    public static CloseableHttpClient createHttpClient(int maxTotal,
            int maxPerRoute, int maxRoute, String hostname, int port) {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory
                .getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory
                .getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder
                .<ConnectionSocketFactory> create().register("http", plainsf)
                .register("https", sslsf).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
                registry);
        // ���������������
        cm.setMaxTotal(maxTotal);
        // ��ÿ��·�ɻ�������������
        cm.setDefaultMaxPerRoute(maxPerRoute);
        HttpHost httpHost = new HttpHost(hostname, port);
        // ��Ŀ���������������������
        cm.setMaxPerRoute(new HttpRoute(httpHost), maxRoute);

        // �������Դ���
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception,
                    int executionCount, HttpContext context) {
                if (executionCount >= 5) {// ����Ѿ�������5�Σ��ͷ���
                    return false;
                }
                if (exception instanceof NoHttpResponseException) {// ������������������ӣ���ô������
                    return true;
                }
                if (exception instanceof SSLHandshakeException) {// ��Ҫ����SSL�����쳣
                    return false;
                }
                if (exception instanceof InterruptedIOException) {// ��ʱ
                    return false;
                }
                if (exception instanceof UnknownHostException) {// Ŀ����������ɴ�
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {// ���ӱ��ܾ�
                    return false;
                }
                if (exception instanceof SSLException) {// SSL�����쳣
                    return false;
                }

                HttpClientContext clientContext = HttpClientContext
                        .adapt(context);
                HttpRequest request = clientContext.getRequest();
                // ����������ݵȵģ����ٴγ���
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setRetryHandler(httpRequestRetryHandler).build();

        return httpClient;
    }

    private static void setPostParams(HttpPost httpost,
            Map<String, Object> params) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
        }
        try {
            httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * POST����URL��ȡ����
     * 
     * @param url
     * @return
     * @author SHANHY
     * @throws IOException 
     * @create 2015��12��18��
     */
    public static String post(String url, Map<String, Object> params) throws IOException {
        HttpPost httppost = new HttpPost(url);
        config(httppost);
        setPostParams(httppost, params);
        CloseableHttpResponse response = null;
        try {
            response = getHttpClient(url).execute(httppost,
                    HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            return result;
        } catch (Exception e) {
//          e.printStackTrace();
            throw e;
        } finally {
            try {
                if (response != null)
                    response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * GET����URL��ȡ����
     * 
     * @param url
     * @return
     * @author SHANHY
     * @create 2015��12��18��
     */
    public static String get(String url) {
        HttpGet httpget = new HttpGet(url);
        config(httpget);
        CloseableHttpResponse response = null;
        try {
            response = getHttpClient(url).execute(httpget,
                    HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null)
                    response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // URL�б�����
        String[] urisToGet = {
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",

                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",

                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",

                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",

                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",

                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497",
                "http://blog.csdn.net/catoop/article/details/38849497" };

        long start = System.currentTimeMillis();
        try {
            int pagecount = urisToGet.length;
            ExecutorService executors = Executors.newFixedThreadPool(pagecount);
            CountDownLatch countDownLatch = new CountDownLatch(pagecount);
            for (int i = 0; i < pagecount; i++) {
                HttpGet httpget = new HttpGet(urisToGet[i]);
                config(httpget);
                // �����߳�ץȡ
                executors.execute(new GetRunnable(urisToGet[i], countDownLatch));
            }
            countDownLatch.await();
            executors.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("�߳�" + Thread.currentThread().getName() + ","
                    + System.currentTimeMillis() + ", �����߳�����ɣ���ʼ������һ����");
        }

        long end = System.currentTimeMillis();
        System.out.println("consume -> " + (end - start));
    }

    static class GetRunnable implements Runnable {
        private CountDownLatch countDownLatch;
        private String url;

        public GetRunnable(String url, CountDownLatch countDownLatch) {
            this.url = url;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("=======================>"+HttpClientUtil.get(url));
            } finally {
                countDownLatch.countDown();
            }
        }
    }



}
