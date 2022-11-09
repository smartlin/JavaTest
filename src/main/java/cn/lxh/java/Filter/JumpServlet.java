package cn.lxh.java.Filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet跳转
 * Created by starlin
 * on 2015/09/26 19:34.
 */
@WebServlet(name = "JumpServlet")
public class JumpServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("rinfo","requeset传递属性");
        request.getSession().setAttribute("sinfo","session传递属性");
     //   response.sendRedirect(request.getContextPath() + "/show.jsp"); //客户端跳转
        request.getRequestDispatcher("/show.jsp").forward(request,response);//服务器端跳转，地址栏未发生任何改变
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
