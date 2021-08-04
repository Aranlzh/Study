package top.aranlzh.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

// 中文数据传递
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 让浏览器用utf8来解析返回的数据
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        // 告诉servlet用UTF-8转码，而不是用默认的ISO8859
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");


        // Cookie，服务端从客户端获取
        // 这里返回数组，说明Cookie可能存在多个
        Cookie[] cookies = req.getCookies();

        PrintWriter out = resp.getWriter();

        if (cookies!=null) {

            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                // 获取cookie的名字
                if ("name".equals(cookie.getName())) {
                    // 获取cookie中的值
                    String name = cookie.getValue();

                    out.write(name+"，");
                }
            }
            out.write("你好！");
        } else {
            out.write("这是你第一次访问本站");
        }


        Cookie cookie = new Cookie("name", "阿然");
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
