package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author promise
 * @date 2021/7/4 - 9:48
 */
@Controller
public class HelloController {

  @RequestMapping(value = "/hello")
  public String handle01() {
    return "success";
  }

}
