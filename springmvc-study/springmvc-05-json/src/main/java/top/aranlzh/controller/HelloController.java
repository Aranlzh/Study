package top.aranlzh.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.aranlzh.pojo.User;

@Controller
public class HelloController {

    /**
     * @ResponseBody：加了这个注解不会被视图解析器解析，直接返回一个字符串
     */
    @RequestMapping("u1")
    @ResponseBody
    public Object getUser1(){
        User user = new User("阿然", 24, "男");
        return user;
    }

    /**
     * produces：指定响应体返回类型和编码
     */
    @RequestMapping(value = "u2", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object getUser2() throws JsonProcessingException {

        // jackson, ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User("阿然", 24, "男");

        String str = objectMapper.writeValueAsString(user);

        return str;
    }

    /**
     * springmvc配置统一转码UTF-8
     */
    @RequestMapping(value = "u3")
    @ResponseBody
    public Object getUser3() throws JsonProcessingException {

        // jackson, ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User("阿然", 24, "男");

        String str = objectMapper.writeValueAsString(user);

        return str;
    }

    @RequestMapping(value = "u4")
    @ResponseBody
    public Object getUser4() {
        User user = new User("阿然", 24, "男");
        return user.toString();
    }

}
