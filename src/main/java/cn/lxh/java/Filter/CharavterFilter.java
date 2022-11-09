package cn.lxh.java.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 字符过滤
 * Created by starlin
 * on 2015/09/26 23:05.
 */
@WebFilter(filterName = "CharavterFilter")
public class CharavterFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String msg = req.getParameter("username");
        if(msg.contains("林")){
            System.out.println("用户名存在非法字符");
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
