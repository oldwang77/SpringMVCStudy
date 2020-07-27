package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 代表这个类被Spring接管
// 被注解的这个类中的所有方法，如果返回值是String，并且有具体页面可以跳转，那么
// 就会被视图解析起解析
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","hello world");
        return "hello";
    }
}
