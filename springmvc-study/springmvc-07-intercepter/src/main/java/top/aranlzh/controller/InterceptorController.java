package top.aranlzh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Study-master
 *
 * @author Aranlzh
 * @date 2021/7/31 23:14
 * @desc 测试拦截器的控制器
 */
@RestController
public class InterceptorController {

    @RequestMapping("/interceptor")
    public String testFunction() {
        System.out.println("控制器中的方法执行了");
        return "hello";
    }
}
