package com.clearlove.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author promise
 * @date 2021/8/24 - 22:01
 * 1. 实现接口HandlerInterceptor
 * 2. 在springMVC配置文件中注册这个拦截器的工作
 *      配置这个拦截器来拦截哪些请求的目标方法
 */
public class MyFirstInterceptor implements HandlerInterceptor {

  /**
   * 目标方法运行之前运行
   * @param httpServletRequest
   * @param httpServletResponse
   * @param o
   * @return
   * @throws Exception
   */
  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object o) throws Exception {
    System.out.println("MyFirstInterceptor...preHandle...");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
      throws Exception {
    System.out.println("MyFirstInterceptor...postHandle...");
  }

  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    System.out.println("MyFirstInterceptor...afterCompletion...");
  }
}
