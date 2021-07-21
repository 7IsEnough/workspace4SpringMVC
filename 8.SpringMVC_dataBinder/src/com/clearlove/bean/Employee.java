package com.clearlove.bean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Employee {

  private Integer id;
  private String lastName;

  private String email;
  // 1 male, 0 female
  private Integer gender;

  // 可以规定页面提交的日期格式
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birth;

  // 假设页面，为了显示方便提交的工资是￥10,000.98
  @NumberFormat(pattern = "#,###,###.####")
  private Double salary;

  private Department department;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public Employee(
      Integer id, String lastName, String email, Integer gender, Department department) {
    super();
    this.id = id;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.department = department;
  }

  public Employee() {}

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", gender=" + gender +
        ", birth=" + birth +
        ", department=" + department +
        '}';
  }
}
