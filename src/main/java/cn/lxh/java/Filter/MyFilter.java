package cn.lxh.java.Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 编码过滤
 * Created by starlin
 * on 2015/09/20 12:15.
 */
public class MyFilter implements Filter {
    private String charset;
    public void init(FilterConfig config) throws ServletException {
        System.out.println("********过滤器：" + config.getInitParameter("var"));
        //编码过滤
    //    this.charset = config.getInitParameter("var");//接收web.xml中的一个参数,参数也可能在web.xml中不配置
        if(this.charset ==null || "".equals(this.charset)){
            this.charset = "utf-8";
        }
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("*******执行过滤");
        req.setCharacterEncoding(this.charset);//执行编码过滤
        chain.doFilter(req, resp);//过滤放行
    }

    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
