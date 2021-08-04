package top.aranlzh.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// 保存用户上次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 服务器，告诉你，你来的时间，把这个时间封装成一个信件，你下次带来，我就知道你来了

        // 让浏览器用utf8来解析返回的数据
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        // 告诉servlet用UTF-8转码，而不是用默认的ISO8859
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        // Cookie，服务端从客户端获取
        // 这里返回数组，说明Cookie可能存在多个
        Cookie[] cookies = req.getCookies();

        if (cookies!=null) {
            out.write("你上一次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                // 获取cookie的名字
                if ("lastLoginTime".equals(cookie.getName())) {
                    // 获取cookie中的值
                    long l = Long.parseLong(cookie.getValue());
                    Date lastLoginTime = new Date(l);
                    out.write(lastLoginTime.toLocaleString());
                }
            }
        } else {
            out.write("这是你第一次访问本站");
        }

        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");

        // cookie有效期为24小时
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
