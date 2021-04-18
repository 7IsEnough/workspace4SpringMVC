package com.clearlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1.告诉SpringMVC这是一个处理器
 * @author promise
 * @date 2021/4/17 - 10:45
 *
 * HelloWorld细节：
 * 1.运行流程
 *      1).客户端点击链接会发送http://localhost:8080/2.SpringMVC_helloWorld/hello请求
 *      2).来到tomcat服务器：
 *      3).SpringMVC的前端控制器收到所有请求，
 *      4).来看请求地址和@RequestMapping标注的哪个匹配，来找到到底使用哪个类的哪个方法来处理
 *      5).前端控制器找到了目标处理器和目标方法，直接利用反射执行目标方法
 *      6).方法执行完成以后会有一个返回值；SpringMVC认为这个返回值就是要去的页面地址
 *      7).拿到方法返回值以后，用视图解析器进行拼串得到完整的页面地址
 *      8).拿到页面地址，前端控制器帮我们转发到页面
 *
 * 2.@RequestMapping
 *      告诉SpringMVC；这个方法用来处理什么请求
 *      这个/是可以省略的，即使省略了，也是默认从当前项目下开始
 *      习惯加上比较好
 *      RequestMapping的使用：?
 * 3.如果不指定配置文件的位置?
 *      /WEB-INF/springDispatcherServlet-servlet.xml
 *      如果不指定也会默认去找一个文件
 *   就在web应用的/WEB-INF/下创建一个名叫 前端控制器名-servlet
 */
@Controller
public class HelloController {

    @RequestMapping("/hello01")
    public String nihao() {
        return "success";
    }

    @RequestMapping("/hello")
    public String handle01() {
    System.out.println("handle01...");
        return "error";
    }

    @RequestMapping("/hello03")
    public String handle02() {
        return "success";
    }
}
