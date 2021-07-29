package top.aranlzh.controller;



import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 实现Controller接口，重写方法，甚至不需要
//      <context:component-scan base-package="top.aranlzh.controller"/>
//      <mvc:default-servlet-handler/>
//      <mvc:annotation-driven/>

// 缺点：
// 一个控制器只能写一个方法。多个方法需要多个；定义方式比较麻烦；

public class Test1Controller implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","Test1");
        mv.setViewName("test1");

        return mv;
    }
}
