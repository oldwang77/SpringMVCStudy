package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    // localhost:8080/hello/h1
    @RequestMapping("/h1")
    public String hello(Model model) {
        // 封装数据
        // 在model中添加的值，可以在jsp页面直接获取
        model.addAttribute("msg", "Hello SpringMVC");
        // 会被视图解析器封装成 /web-inf/jsp/hello.jsp
        return "hello";
    }
}
