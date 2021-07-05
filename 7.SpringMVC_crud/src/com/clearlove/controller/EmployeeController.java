package com.clearlove.controller;

import com.clearlove.bean.Department;
import com.clearlove.bean.Employee;
import com.clearlove.dao.DepartmentDao;
import com.clearlove.dao.EmployeeDao;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author promise
 * @date 2021/7/4 - 10:19
 */
@Controller
public class EmployeeController {

  @Autowired
  EmployeeDao employeeDao;

  @Autowired
  DepartmentDao departmentDao;

  @RequestMapping("/emps")
  public String getEmps(Model model) {
    Collection<Employee> all = employeeDao.getAll();
    model.addAttribute("emps", all);
    return "list";
  }

  /**
   * 去员工添加页面，去页面之前需要查出所有部门信息，进行展示的
   * @return
   */
  @RequestMapping("toaddpage")
  public String toAddPage(Model model) {
    // 先查出所有部门，放在请求域中
    model.addAttribute("depts", departmentDao.getDepartments());
    model.addAttribute("employee", new Employee());
    // 去添加页面
    return "add";
  }

  @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
  public String getEmp(@PathVariable Integer id, Model model) {
    // 1.查出员工信息
    Employee employee = employeeDao.get(id);
    // 2.放在请求域中
    model.addAttribute("employee", employee);
    // 3.继续查出部门信息
    Collection<Department> departments = departmentDao.getDepartments();
    model.addAttribute("depts", departments);
    return "edit";
  }

  /**
   * 保存员工
   * @param employee
   * @return
   */
  @RequestMapping(value = "/emp", method = RequestMethod.POST)
  public String addEmp(Employee employee) {
    System.out.println("要添加的员工：" + employee);
    employeeDao.save(employee);
    // 返回列表页面；重定向到查询所有员工的请求
    return "redirect:/emps";
  }

}
