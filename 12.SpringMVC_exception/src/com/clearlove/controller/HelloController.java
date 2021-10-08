package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author promise
 * @date 2021/10/7 - 17:40
 */
@Controller
public class HelloController {

  @RequestMapping(value = "/hello")
  public String hello() {
    return "success";
  }

}
