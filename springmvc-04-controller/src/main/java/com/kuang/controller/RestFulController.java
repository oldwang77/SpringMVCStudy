package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestFulController {

    // http://localhost:8080/add?a=1&b=2

    // restful风格：http://localhost:8080/add/a/b

    @RequestMapping("/t1")
    public String add1(@RequestParam Integer a, @RequestParam Integer b, Model model) {
        Integer result = a + b;
        model.addAttribute("msg", a + "+" + b + "=" + result);
        return "hello";
    }

    @RequestMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "hello";
    }
}
