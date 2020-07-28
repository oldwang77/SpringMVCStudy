package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller         // 走视图解析
@RestController     // 走字符串
public class UserController {

    @RequestMapping("/j1")
    // 只要加了这个注解，就不会通过视图解析器
    // 会直接返回一个字符串，不会再返回页面
    // @ResponseBody
    public String json1() throws JsonProcessingException {

        // jackson,ObjectMapper
        // jsckson提供了ObjectMapper这个类进行解析
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("周杰伦", 20, "男");
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        String str = mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user1 = new User("zhou",20,"man");
        User user2 = new User("wang", 30, "man");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        String userStr = mapper.writeValueAsString(list);
        return userStr;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        return mapper.writeValueAsString(date);
    }

    //使用时间戳的方式将时间格式化
    @RequestMapping("/j3-1")
    public String json31() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        return mapper.writeValueAsString(date + "<==>" + format);
    }

    @RequestMapping("/j4")
    public String json4() {

        User user1 = new User("周杰伦1", 20, "nan");
        User user2 = new User("周杰伦2", 20, "nan");
        User user3 = new User("周杰伦3", 20, "nan");
        User user4 = new User("周杰伦4", 20, "nan");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("*******Java对象  转  JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSoNString(list)==>" + str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>" + str2);

        System.out.println("\n*******JSON字符串  转  Java对象*******");
        User jp_user1 = JSON.parseObject(str2, User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>" + jp_user1);


        System.out.println("\n*******Java对象  转  JSON对象*******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONobject)JSON.toJSON(user2)==>" + jsonObject1.getString("name"));


        System.out.println("\n*******JSON对象  转  Java对象*******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1,User.class)==>" + to_java_user);

        String s = JSON.toJSONString(list);
        return s;
    }
}
