package com.clearlove.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author promise
 * @date 2021/10/3 - 15:24
 * 集中处理所有异常
 *
 *
 * 1.集中处理所有异常的类加入到ioc容器中
 * 2.@ControllerAdvice专门处理异常的类
 */
@ControllerAdvice
public class MyGlobalException {

  @ExceptionHandler(value = {ArithmeticException.class})
  public ModelAndView handleException01(NullPointerException exception) {
    System.out.println("全局handleException01...");
    ModelAndView view = new ModelAndView("myerror");
    view.addObject("ex", exception);
    // 视图解析器拼串
    return view;
  }

//  @ExceptionHandler(value = {Exception.class})
//  public ModelAndView handleException02(Exception exception) {
//    System.out.println("全局handleException02...");
//    ModelAndView view = new ModelAndView("myerror");
//    view.addObject("ex", exception);
//    // 视图解析器拼串
//    return view;
//  }

}
