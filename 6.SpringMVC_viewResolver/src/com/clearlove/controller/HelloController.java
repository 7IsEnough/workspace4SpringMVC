package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author promise
 * @date 2021/6/9 - 23:30
 */
@Controller
public class HelloController {

  @RequestMapping("/hello")
  public String hello() {
    return "success";
  }

}
