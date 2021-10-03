package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
   * 4.如果有多个@ExceptionHandler都能处理这个异常，精确优先
   * 5.全局异常处理与本类同时存在，本类优先
   */
//  @ExceptionHandler(value = {ArithmeticException.class})
//  public ModelAndView handleException01(Exception exception) {
//    System.out.println("本类handleException01...");
//    ModelAndView view = new ModelAndView("myerror");
//    view.addObject("ex", exception);
//    // 视图解析器拼串
//    return view;
//  }

  @RequestMapping(value = "/handle02")
  public String handle02(@RequestParam("username") String username) {
    if (!"admin".equals(username)) {
      System.out.println("登录失败");
      throw new UserNameNotFoundException();
    }
    return "success";
  }


  @RequestMapping(value = "/handle03", method = RequestMethod.POST)
  public String handle03(@RequestParam("username") String username) {
    if (!"admin".equals(username)) {
      System.out.println("登录失败");
      throw new UserNameNotFoundException();
    }
    return "success";
  }

  @RequestMapping(value = "/handle04")
  public String handle04() {
    System.out.println("handle04...");
    String str = null;
    System.out.println(str.toString());
    return "success";
  }




}
