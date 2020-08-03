package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//RestController：注解@RestController标记在类上,表示该类处理http请求,并且返回json数据
@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test(){return "hello";}

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>"+name);
        if("kuangshen".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        ArrayList<User> users = new ArrayList<User>();
        // 添加数据
        users.add(new User("kuangshen",1,"nan"));
        users.add(new User("xiaoming",2,"woman"));
        users.add(new User("zhangsan",3,"gril"));
        return users;
    }
}
