package top.aranlzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.aranlzh.pojo.User;

@Controller
public class RestfulController {

    // /add?a=1&b=2
    @RequestMapping("/add")
    public String add(int a, int b, Model model) {
        int res = a+b;
        model.addAttribute("msg","结果为"+res);
        return "result";
    }

    // /add/1/2
    @RequestMapping("/add/{a}/{b}")
    public String add1(@PathVariable("a") int a, @PathVariable("b") int b, Model model) {
        int res = a+b;
        model.addAttribute("msg","结果为"+res);
        return "result";
    }

    //@RequestMapping(value = "/multi/{a}/{b}", method = RequestMethod.GET)
    @GetMapping("/multi/{a}/{b}")
    public String multi(@PathVariable("a") int a, @PathVariable("b") int b, Model model) {
        int res = a*b;
        model.addAttribute("msg","结果为"+res);
        return "result";
    }

    //@RequestMapping(value = "/multi/{a}/{b}", method = RequestMethod.POST)
    @PostMapping("/multi/{a}/{b}")
    public String multi1(@PathVariable("a") int a, @PathVariable("b") int b, Model model) {
        int res = a*b;
        model.addAttribute("msg","结果为"+res);
        return "result";
    }

    // http://localhost:8080/hello?name=aran
    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println(name);
        return "hello";
    }

    // http://localhost:8080/hello?username=aran
    //@RequestParam("username") : username 提交的域的名称
    @RequestMapping("/hello")
    public String hello1(@RequestParam("username") String name){
        System.out.println(name);
        return "hello";
    }


    // http://localhost:8080/mvc04/user?name=aran&id=1&age=15
    @RequestMapping("/user")
    public String user(User user){
        System.out.println(user);
        return "hello";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam("username") String name, ModelMap model){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        model.addAttribute("name",name);
        System.out.println(name);
        return "hello";
    }



}
