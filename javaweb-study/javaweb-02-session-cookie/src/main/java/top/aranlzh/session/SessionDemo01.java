package top.aranlzh.session;

import top.aranlzh.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 解决乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 得到Session
        HttpSession session = req.getSession();

        // 给Session中存东西
        // session.setAttribute("name","阿然");
        session.setAttribute("name",new Person("阿然",24));

        // 获取session的ID
        String sessionId = session.getId();
        // 判断session是不是新建的
        if (session.isNew()) {
            resp.getWriter().write("session创建成功，ID："+sessionId);
        } else {
            resp.getWriter().write("session已经在服务器中存在，ID："+sessionId);
        }

        // Session创建的时候做了什么事情
        // Cookie cookie = new Cookie("JSESSIONID",sessionId);
        // resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
