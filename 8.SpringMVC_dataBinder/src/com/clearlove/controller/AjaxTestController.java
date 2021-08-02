package com.clearlove.controller;

import com.clearlove.bean.Employee;
import com.clearlove.dao.EmployeeDao;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
   * @return
   */
  @RequestMapping(value = "/testRequestBody")
  public String testRequestBody(@RequestBody String body) {
    System.out.println("请求体：" + body);
    return "success";
  }

}
