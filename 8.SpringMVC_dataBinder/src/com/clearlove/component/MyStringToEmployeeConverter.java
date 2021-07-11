package com.clearlove.component;

import com.clearlove.bean.Employee;
import com.clearlove.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * 两个泛型
 * S：Source
 * T: Target
 * 将s转为t
 * @author promise
 * @date 2021/7/11 - 11:47
 */
public class MyStringToEmployeeConverter implements Converter<String, Employee> {

  @Autowired
  DepartmentDao departmentDao;

  /**
   * 自定义转换规则
   * @param s
   * @return
   */
  @Override
  public Employee convert(String s) {
    System.out.println("页面提交的将要转换的字符串：" + s);
    Employee employee = new Employee();
    if(!StringUtils.isEmpty(s)) {
      String[] split = s.split("-");
      employee.setLastName(split[0]);
      employee.setEmail(split[1]);
      employee.setGender(Integer.parseInt(split[2]));
      employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(split[3])));
    }
    return employee;
  }
}
