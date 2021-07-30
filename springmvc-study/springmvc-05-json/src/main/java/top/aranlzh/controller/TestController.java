package top.aranlzh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aranlzh.pojo.User;
import top.aranlzh.utils.JacksonUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping("u5")
    public Object getUser5(){
        User user = new User("阿然", 24, "男");
        return user;
    }

    @RequestMapping("u6")
    public Object getUser6(){

        List<User> userList = new ArrayList<User>();

        User user = new User("阿然", 24, "男");
        User user1 = new User("阿然1", 24, "男");
        User user2 = new User("阿然2", 24, "男");
        User user3 = new User("阿然3", 24, "男");
        User user4 = new User("阿然4", 24, "男");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return userList;
    }

    @RequestMapping("u7")
    public String getUser7() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        List<User> userList = new ArrayList<User>();

        User user = new User("阿然", 24, "男");
        User user1 = new User("阿然1", 24, "男");
        User user2 = new User("阿然2", 24, "男");
        User user3 = new User("阿然3", 24, "男");
        User user4 = new User("阿然4", 24, "男");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return objectMapper.writeValueAsString(userList);
    }

    @RequestMapping("u8")
    public String getUser8() {

        List<User> userList = new ArrayList<User>();
        User user = new User("阿然", 24, "男");
        User user1 = new User("阿然1", 24, "男");
        User user2 = new User("阿然2", 24, "男");
        User user3 = new User("阿然3", 24, "男");
        User user4 = new User("阿然4", 24, "男");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return JacksonUtils.getJson(userList);
    }

    @RequestMapping("u9")
    public String getUser9() {

        List<User> userList = new ArrayList<User>();
        User user = new User("阿然", 24, "男");
        User user1 = new User("阿然1", 24, "男");
        User user2 = new User("阿然2", 24, "男");
        User user3 = new User("阿然3", 24, "男");
        User user4 = new User("阿然4", 24, "男");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(userList);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1= JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return JSON.toJSONString(userList);
    }



    @RequestMapping("t1")
    public String getTime1() throws JsonProcessingException {
        // ObjectMapper，时间解析后的默认格式为：Timestamp，时间戳
        return new ObjectMapper().writeValueAsString(new Date());
    }


    @RequestMapping("t2")
    public String getTime2() throws JsonProcessingException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return new ObjectMapper().writeValueAsString(sdf.format(date));
    }

    @RequestMapping("t3")
    public String getTime3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        return mapper.writeValueAsString(new Date());
    }

    @RequestMapping("t4")
    public String getTime4()  {
        return JSON.toJSONString(new Date());
    }

    @RequestMapping("t5")
    public String getTime5()  {
        return new Gson().toJson(new Date());
    }

    @RequestMapping("t6")
    public String getTime6()  {
        return JSON.toJSONStringWithDateFormat(new Date(),"yyyy-MM-dd HH:mm:ss");
    }


}
