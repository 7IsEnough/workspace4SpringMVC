package com.clearlove.controller;

import com.clearlove.bean.Employee;
import com.clearlove.dao.EmployeeDao;
import java.io.FileInputStream;
import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author promise
 * @date 2021/8/2 - 22:47
 */
@Controller
public class AjaxTestController {

  @Autowired
  EmployeeDao employeeDao;

  /**
   * ResponseEntity<String> 响应体中内容的类型
   * @return
   */
//  @ResponseBody
  @RequestMapping(value = "haha")
  public ResponseEntity<String> haha() {
    System.out.println("haha....");
    String body = "<h1>success</h1>";
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("Set-Cookie", "username=hahaha");
    return new ResponseEntity<String>(body, headers, HttpStatus.OK);
  }

  /**
   * 将返回的数据放在响应体中
   * 如果是对象，jackson自动将对象转为json格式
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/getallajax")
  public Collection<Employee> ajaxGetAll() {
    Collection<Employee> all = employeeDao.getAll();
    return all;
  }


  /**
   * @RequestBody ：请求体；获取一个请求的请求体
   * @RequestParam :
   *
   * @ResponseBody : 可以把对象转为Json数据，返回给浏览器
   * @RequestBody ：接收json数据，封装为对象
   *
   * @return
   */
  @RequestMapping(value = "/testRequestBody")
  public String testRequestBody(@RequestBody Employee employee) {
    System.out.println("请求体：" + employee);
    return "success";
  }


  @RequestMapping(value = "/test01")
  public String test01(@RequestBody String str) {
    System.out.println("请求体：" + str);
    return "success";
  }


  /**
   * 如果参数位置写HttpEntity<String> str
   * 比@RequestBody更强，可以拿到请求头
   * @RequestHeader ：只能拿到某个请求头
   *
   * @param str
   * @return
   */
  @RequestMapping(value = "/test02")
  public String test02(HttpEntity<String> str) {
    System.out.println(str);
    return "success";
  }


  /**
   * Spring MVC文件下载
   * @param request
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "haha")
  public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception{
    // 1.得到要下载的文件的流
    // 找到要下载的文件的真实路径
    ServletContext servletContext = request.getServletContext();
    String realPath = servletContext.getRealPath("/scripts/jquery-1.9.1.min.js");
    FileInputStream is = new FileInputStream(realPath);

    byte[] tmp = new byte[is.available()];
    is.read(tmp);
    is.close();

    //2. 将要下载的文件流返回
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Disposition", "attachment;filename=" + "jquery-1.9.1.min.js");
    return new ResponseEntity<byte[]>(tmp, headers, HttpStatus.OK);
  }


}
