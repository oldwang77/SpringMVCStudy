package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//restController：会返回hello字符串
@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test(){return "hello";}
}
