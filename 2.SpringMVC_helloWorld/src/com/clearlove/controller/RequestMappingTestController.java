package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 为当前类所有的方法的请求地址指定一个基准路径
 * @author promise
 * @date 2021/4/18 - 13:07
 */
@Controller
@RequestMapping("/haha")
public class RequestMappingTestController {

  @RequestMapping("/handle01")
  public String handle01() {
    System.out.println("RequestMappingTestController...handle01");
    return "success";
  }
}
