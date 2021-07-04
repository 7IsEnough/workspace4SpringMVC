<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/7/4
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
<h1>员工列表</h1>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>departmentName</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender == 0 ? "女" : "男"}</td>
            <td>${emp.department.departmentName}</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
    </c:forEach>
</table>
<a href="toaddpage">添加员工</a>
</body>
</html>
