package top.aranlzh.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener implements HttpSessionListener {

    // 创建session监听
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("创建Session，ID："+httpSessionEvent.getSession().getId());

        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();

        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");

        if (onlineCount==null) {
            onlineCount = new Integer(1);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(++count);
        }

        servletContext.setAttribute("OnlineCount", onlineCount);

    }

    // 销毁session监听

    /*
    1. 手动销毁 getSession().invalidate();
    2. 设置过期时间
     */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("销毁Session，ID："+httpSessionEvent.getSession().getId());

        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();

        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");

        if (onlineCount==null) {
            onlineCount = new Integer(0);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(--count);
        }

        servletContext.setAttribute("OnlineCount", onlineCount);

    }
}
