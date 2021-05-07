package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author promise
 * @date 2021/5/6 - 23:02
 */
@Controller
public class HelloController {

  /**
   * 获取请求参数
   * request.getParameter("")....
   * @return
   */
  @RequestMapping("/hello")
  public String handle01() {
    System.out.println("handle01...");
    return "success";
  }

  /**
   * SpringMVC如何获取请求带来的各种信息
   * 默认方式获取参数：参数默认是必须带的
   *    直接给方法入参上写一个和请求参数名相同的变量。这个变量就来接收请求参数的值
   *    带：有值，没带：null
   * @RequestParam: 获取请求参数的
   *      @RequestParam("user") String username
   *      username = request.getParameter("user")
   *   value: 指定要获取的参数的Key
   *   required: 这个参数是否必须的
   *   defaultValue: 默认值
   *
   * @RequestParam("user")
   * @PathVariable("user")  /book/[{user}(PathVariable)]?[user=admin(RequestParam)]
   *
   * @RequestHeader: 获取请求头中某个key的值
   *    request.getHeader("User-Agent")
   *
   *    @RequestHeader("User-Agent") String userAgent
   *    userAgent = request.getHeader("User-Agent")
   * 如果请求头中没有这个值就会报错；
   *    value: 指定要获取的参数的Key
   *    required: 这个参数是否必须的
   *    defaultValue: 默认值
   *
   * @CookieValue: 获取某个cookie的值
   *    以前的操作获取某个cookie
   *    Cookie[] cookies = request.getCookies();
   *    for(Cookie c: cookies) {
   *      if(c.getName().equals("JSESSIONID")) {
   *       String cv = c.getValue();
   *      }
   *    }
   *
   *    value: 指定要获取的参数的Key
   *    required: 这个参数是否必须的
   *    defaultValue: 默认值
   */
  @RequestMapping("/handle01")
  public String handle02(@RequestParam(value = "user", required = false,
      defaultValue = "你没带") String username,
      @RequestHeader(value = "ahaha", required = false,
          defaultValue = "他也没带") String userAgent,
      @CookieValue(value = "JSESSIONID", required = false) String jid) {
    System.out.println("这个变量的值：" + username);
    System.out.println("请求头中浏览器的信息：" + userAgent);
    System.out.println("cookie中的jid的值：" + jid);
    return "success";
  }

}
