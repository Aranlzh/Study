package top.aranlzh.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    // 初始化：web服务器启动的时候调用
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    // filterChain：链
    /*
    1. 过滤中的所有代码，在过滤特定请求的时候会执行（在web.xml中配置）
    2. 必须要让过滤器继续通行
    filterChain.doFilter(servletRequest, servletResponse);
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("doFilter执行前");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("doFilter执行后");
    }

    // 销毁：web服务器关闭的时候调用
    public void destroy() {
        System.out.println("CharacterEncodingFilter");
    }
}
