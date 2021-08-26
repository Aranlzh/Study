package top.aranlzh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.aranlzh.form.LoginForm;

@RestController
@Api(tags = "登录控制器")
public class LoginController {

    @PostMapping("login")
    @ApiOperation("登录接口")
    public Object login(@RequestBody LoginForm loginForm) {
        return null;
    }

}
