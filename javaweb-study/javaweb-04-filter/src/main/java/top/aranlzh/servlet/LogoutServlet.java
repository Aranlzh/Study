package top.aranlzh.servlet;

import top.aranlzh.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object user_session = request.getSession().getAttribute(Constant.USER_SESSION);

        if (user_session!=null){
            request.getSession().removeAttribute(Constant.USER_SESSION);
            // request.getSession().setAttribute(Constant.USER_SESSION,null);
        }

        Object user_role = request.getSession().getAttribute(Constant.USER_ROLE);

        if (user_role!=null){
            // request.getSession().removeAttribute(Constant.USER_ROLE);
            request.getSession().setAttribute(Constant.USER_ROLE,null);
        }

        response.sendRedirect("/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
