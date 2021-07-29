package top.aranlzh.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        // 调用业务层

        // 封装对象，放在ModelAndView中
        mv.addObject("msg","Hello,SpringMVC");
        // 封装要跳转的视图，放在ModelAndView中
        // /WEB-INF/jsp/hello.jsp
        mv.setViewName("hello");

        // 404：jar包lib依赖问题
        // Ctrl+Shift+Alt+S -> Artifacts
        // + lib 文件夹
        // + Library File

        return mv;
    }

}
