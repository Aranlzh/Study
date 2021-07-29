package top.aranlzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 测试前，先把视图解析器注释掉
//    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
//        <property name="prefix" value="/WEB-INF/jsp/"/>
//        <property name="suffix" value=".jsp"/>
//    </bean>

@Controller
public class ResultController {

    @RequestMapping("/t1")
    public String test1(){
        return "/index.jsp";
    }

    @RequestMapping("/t2")
    public String test2(){
        return "forward:/index.jsp";
    }

    // http://localhost:8080/t3 => http://localhost:8080/index.jsp
    @RequestMapping("/t3")
    public String test3(){
        return "redirect:/index.jsp";
    }

}
