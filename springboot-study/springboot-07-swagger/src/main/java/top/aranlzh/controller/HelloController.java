package top.aranlzh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试控制器")
@RestController
public class HelloController {

    @GetMapping("hello")
    @ApiOperation("测试接口")
    public String hello(){
        return "hello";
    }

}
