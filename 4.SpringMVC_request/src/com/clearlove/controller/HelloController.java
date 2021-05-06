package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author promise
 * @date 2021/5/6 - 23:02
 */
@Controller
public class HelloController {

  @RequestMapping("/hello")
  public String handle01() {
    System.out.println("handle01...");
    return "success";
  }

}
