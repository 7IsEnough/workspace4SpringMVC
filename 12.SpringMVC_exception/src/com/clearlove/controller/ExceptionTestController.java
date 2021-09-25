package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author promise
 * @date 2021/9/25 - 22:24
 */
@Controller
public class ExceptionTestController {

  @RequestMapping("/handle01")
  public String handle01(Integer i) {
    System.out.println("handle01....");
    System.out.println(10/i);
    return "success";
  }

}
