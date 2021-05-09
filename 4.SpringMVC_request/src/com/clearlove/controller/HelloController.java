package com.clearlove.controller;

import com.clearlove.book.Book;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

  /**
   * 如果我们的请求是一个POJO
   * SpringMVC会自动的为这个POJO赋值
   * 1. 将POJO中的每一个属性，从request参数中尝试获取出来，并封装即可
   * 2. 还可以级联封装：属性的属性
   * @param book
   * @return
   */
  @RequestMapping("/book")
  public String addBook(Book book) {
    System.out.println("我要保存的图书：" + book);
    return "success";
  }

  /**
   * SpringMVC可以直接在参数上写原生API
   *
   * HttpServletRequest
   * HttpServletResponse
   * HttpSession
   *
   * java.security.Principal: https安全协议有关的
   * Locale：国际化有关的区域信息对象
   * InputStream
   *        ServletInputStream inputStream = request.getInputStream();
   * OutputStream
   *        ServletOutputStream outputStream = response.getOutputStream();
   * Reader
   *        BufferedReader reader = request.getReader();
   * Writer
   *        PrintWriter writer = response.getWriter();
   */
  @RequestMapping("/handle03")
  public String handle03(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
    request.setAttribute("reqParam", "我是请求域中的");
    session.setAttribute("sessionParam", "我是session域中的");
    return "success";
  }

}
