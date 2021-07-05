<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/7/5
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>员工修改页面</h1>
<%--modelAttribute:这个表单中所有内容显示绑定的是请求域中的employee的值--%>
<form:form action="" modelAttribute="employee">
    email:<form:input path="email"/><br/>
    gender:&nbsp;&nbsp;&nbsp;
    男：<form:radiobutton path="gender" value="1"/>&nbsp;&nbsp;&nbsp;
    女：<form:radiobutton path="gender" value="0"/><br/>
    dept:
        <form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"/><br/>
    <input type="submit" value="修改">
</form:form>
</body>
</html>
