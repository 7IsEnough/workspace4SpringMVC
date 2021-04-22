package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

  /**
   * RequestMapping的其他属性
   * method: 限定请求方式
   *    HTTP协议中的所有请求方式：
   *        GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
   *    常见的为GET、POST
   *    method = RequestMethod.POST：只接收这种类型的请求，默认是什么都可以
   *      不是规定的方式就报错：4xx：都是客户端错误
   *        405 - Request method 'GET' not supported
   *
   * params: 规定请求参数
   *  params和headers支持简单的表达式
   *    param1: 表示请求必须包含名为param1的请求参数
   *      eg: params={"username"}
   *        发送请求时必须带上一个名为username的参数；没带都会404
   *    !param1：表示请求不能包含名为param1的请求参数
   *      eg: params={"!username"}
   *        发送请求时必须不携带名为username的参数；带都会404
   *    param1 != value1：表示请求包含名为param1的请求参数，但其值不能为value1
   *      eg: params={"username != 123"}
   *        发送请求时，携带的username值必须不是123(不带username或者username不是123)
   *    {"param1 = value1", "param2"}: 请求必须包含名为param1和param2的两个请求参数，且param1
   *    参数的值必须为value1
   *      eg: params = {"username!=123", "pwd", "!age"}
   *        请求参数必须满足以上规则：
   *        请求的username不能是123，必须有pwd的值，不能有age
   *
   * headers: 规定请求头；也和param一样能写简单的表达式
   *
   *
   * consumes: 只接收内容类型是哪种的请求，规定请求头中的Content-Type
   *
   * produces: 告诉浏览器返回的内容类型是什么，给响应头中加上Content-Type:text/html;charset=utf-8
   */
  @RequestMapping(value = "/handle02", method = RequestMethod.POST)
  public String handle02() {
    System.out.println("handle02...");
    return "success";
  }

  @RequestMapping(value = "/handle03", params = {"username!=123", "pwd", "!age"})
  public String handle03() {
    System.out.println("handle03...");
    return "success";
  }

  /**
   * User-agent: 浏览器信息； 让谷歌能访问，IE不能访问
   *
   * <p>谷歌：User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like
   * Gecko) Chrome/89.0.4389.82 Safari/537.36
   *
   * <p>IE：User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko
   *
   * @return
   */
  @RequestMapping(
      value = "/handle04",
      headers = {
        "User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36"
      })
  public String handle04() {
    System.out.println("handle04..");
    return "success";
  }
}
