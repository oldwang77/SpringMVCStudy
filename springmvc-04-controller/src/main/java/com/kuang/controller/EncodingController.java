package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {

    // 表单提交的方式指明了是post，这里只能用postmapping了
    // 貌似用requestmapping也行...
    @PostMapping("/encoding/t1")
    public String encoding(String name, Model model){
        System.out.println(name);
        model.addAttribute("msg",name);
        return "encodingTest";
    }
}
