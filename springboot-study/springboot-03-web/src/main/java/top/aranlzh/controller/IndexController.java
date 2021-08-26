package top.aranlzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

// 在template目录下的所有页面，只能通过controller来跳转
// 需要模板引擎的支持
@Controller
public class IndexController {

    @RequestMapping("/indexPage")
    public String index(Model model){
        model.addAttribute("msg","<h1>Hello,template</h1>");

        model.addAttribute("users", Arrays.asList("aaa","bbb","ccc"));



        return "index";
    }

}
