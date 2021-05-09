package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author promise
 * @date 2021/5/9 - 17:55
 */
@Controller
public class HelloController {

  @RequestMapping("/hello")
  public String hello() {
    System.out.println("hello...");
    return "success";
  }

}
