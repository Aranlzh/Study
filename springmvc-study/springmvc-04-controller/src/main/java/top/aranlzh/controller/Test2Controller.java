package top.aranlzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller 代表这个类会被spring接管
// 被这个注解注解的类中的所有方法，如果返回值是String，并且有具体页面可以跳转，就会被视图解析器解析

@Controller
public class Test2Controller {

    @RequestMapping("test2")
    public String test2(Model model) {
        model.addAttribute("msg","Test2");
        return "test2";
    }

    @RequestMapping("test3")
    public String test3(Model model) {
        model.addAttribute("msg","Test3");
        return "test2";
    }
}
