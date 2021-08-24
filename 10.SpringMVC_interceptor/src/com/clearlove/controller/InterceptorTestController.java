package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author promise
 * @date 2021/8/24 - 21:55
 */
@Controller
public class InterceptorTestController {

  @RequestMapping("/test01")
  public String test01() {
    System.out.println("test01...");
    return "success";
  }


}
