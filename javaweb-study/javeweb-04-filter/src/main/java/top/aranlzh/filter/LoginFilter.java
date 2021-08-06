package top.aranlzh.filter;

import top.aranlzh.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("登录鉴权过滤器初始化");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String user_session = (String) request.getSession().getAttribute(Constant.USER_SESSION);
        if (user_session==null){
            System.out.println("USER_SESSION为空");
            response.sendRedirect("/error.jsp");
        } else {
            String user_role = (String) request.getSession().getAttribute(Constant.USER_ROLE);
            String uri = request.getRequestURI();
            if (user_role==null){
                System.out.println("USER_ROLE为空");
                response.sendRedirect("/error.jsp");
            } else if ("ADMIN".equals(user_role)) {
                System.out.println("USER_ROLE为ADMIN");
                if (uri.indexOf("/user/")!=-1){
                    response.sendRedirect("/error.jsp");
                    // response.sendRedirect("/sys/main.jsp");
                }
            } else if ("USER".equals(user_role)) {
                System.out.println("USER_ROLE为USER");
                if (uri.indexOf("/sys/")!=-1){
                    response.sendRedirect("/error.jsp");
                    // response.sendRedirect("/user/main.jsp");
                }
            } else {
                System.out.println("USER_ROLE为其他");
                response.sendRedirect("/login.jsp");
            }
        }

        filterChain.doFilter(request,response);
    }

    public void destroy() {
        System.out.println("登录鉴权过滤器销毁");
    }
}
