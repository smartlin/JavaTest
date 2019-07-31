package cn.lxh.java.Filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 取得Servlet内置对象
 * Created by starlin
 * on 2015/09/26 18:25.
 */
@WebServlet(name = "ServletDuiXiang")
public class ServletDuiXiang extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sse = request.getSession();//取得Seession对象
        System.out.println("seesion ID:" + sse.getId());
        System.out.println(super.getServletContext().getRealPath("/"));//取得Application 对象
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
