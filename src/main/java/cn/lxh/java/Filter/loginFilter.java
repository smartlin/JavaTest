package cn.lxh.java.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证过滤
 * Created by starlin
 * on 2015/09/26 22:20.
 */
@WebFilter(filterName = "loginFilter")
public class loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //seession属于http范畴，所以必须找到HttpServletRequest接口对象
        HttpServletRequest request = (HttpServletRequest) req;//向下转型
        HttpSession seesion =  request.getSession();//取得seesion
        chain.doFilter(req, resp);

    }


    public void destroy() {
    }
}
