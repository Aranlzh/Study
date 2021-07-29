package top.aranlzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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



}
