package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1.告诉SpringMVC这是一个处理器
 * @author promise
 * @date 2021/4/17 - 10:45
 */
@Controller
public class HelloController {

    @RequestMapping("/hello01")
    public String nihao() {
        return "success";
    }

    @RequestMapping("/hello")
    public String handle01() {
    System.out.println("handle01...");
        return "error";
    }

    @RequestMapping("/hello03")
    public String handle02() {
        return "success";
    }
}
