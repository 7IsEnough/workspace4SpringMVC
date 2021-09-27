package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author promise
 * @date 2021/9/25 - 22:24
 */
@Controller
public class ExceptionTestController {

  @RequestMapping("/handle01")
  public String handle01(Integer i) {
    System.out.println("handle01....");
    System.out.println(10 / i);
    return "success";
  }

  /**
   * 告诉SpringMVC这个方法专门处理这个类发生的异常
   * 1.给方法上随便写一个Exception，用来接收发生的异常
   * 2.要携带异常信息，不能给参数位置写Model
   * 3.返回ModelAndView就行了
   */
  @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
  public ModelAndView handleException01(Exception exception) {
    System.out.println("handleException01...");
    ModelAndView view = new ModelAndView("myerror");
    view.addObject("ex", exception);
    // 视图解析器拼串
    return view;
  }
}
