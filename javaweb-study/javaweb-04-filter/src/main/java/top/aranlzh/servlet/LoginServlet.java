package top.aranlzh.servlet;

import top.aranlzh.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理请求
        String username = request.getParameter("username");

        System.out.println("username:" + username);


        if ("admin".equals(username)) {
            request.getSession().setAttribute(Constant.USER_SESSION, request.getSession().getId());
            request.getSession().setAttribute(Constant.USER_ROLE, "ADMIN");
            response.sendRedirect("/sys/main.jsp");
        } else if ("user".equals(username)) {
            request.getSession().setAttribute(Constant.USER_SESSION, request.getSession().getId());
            request.getSession().setAttribute(Constant.USER_ROLE, "USER");
            response.sendRedirect("/user/main.jsp");
        } else {
            response.sendRedirect("/error.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
