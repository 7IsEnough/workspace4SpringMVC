<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/7/4
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>员工添加</h1>
<%--表单标签
    通过SpringMVC的表单标签可以实现将模型数据中的属性和HTML表单元素相绑定，
    以实现表单数据更便捷编辑和表单值的回显
    1.SpringMVC认为，表单数据中的每一项最终都是要回显的
        path指定的是一个属性；这个属性时从隐含模型(请求域中取出的某个对象的属性)
        path指定的每一个属性；请求域中必须有一个对象，拥有这个属性
            这个对象就是请求域中的command
        modelAttribute=""
        1) 以前表单标签会从请求域中获取一个command对象；把这个对象中的每一个属性对应的显示出来
        2) 可以告诉SpringMVC不要去取command的值，已经放了一个modelAttribute指定的值
           取对象时用的key就用modelAttribute指定的
--%>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<form:form action="${ctp}/emp" modelAttribute="employee" method="post">
    <%--path就是原来input标签的name项：需要写
        path：
            1.当作原生的name项
            2.自动回显隐含模型中某个对象对应的这个属性的值
    --%>
    lastName:<form:input path="lastName"/><br/>
    email:<form:input path="email"/><br/>
    gender:<br/>
        男：<form:radiobutton path="gender" value="1"/><br/>
        女：<form:radiobutton path="gender" value="0"/><br/>
    dept:
        <%--
            items:指定要遍历的集合，自动遍历，遍历出的元素是一个department对象
            itemLabel："属性"，指定遍历出的这个对象的哪个属性是作为option标签体的值
            itemValue："属性"，指定遍历出的这个对象的哪个属性是作为要提交的value值
            --%>
        <form:select path="department.id" items="${depts}"
                     itemLabel="departmentName" itemValue="id"></form:select><br/>
    <input type="submit" value="保存">
</form:form>

<!--(Employee)-->
<%--<form action="">--%>
<%--    lastName: <input type="text" name="lastName"><br/>--%>
<%--    email: <input type="text" name="email"><br/>--%>
<%--    gender: <br/>--%>
<%--        男：<input type="radio" name="gender" value="1"><br/>--%>
<%--        女：<input type="radio" name="gender" value="0"><br/>--%>
<%--    dept:--%>
<%--        <select name="department.id">--%>
<%--            <c:forEach items="${depts}" var="deptItem">--%>
<%--                &lt;%&ndash;标签体中的是在页面的提示选项信息，value才是真正提交的值&ndash;%&gt;--%>
<%--                <option value="${deptItem.id}">${deptItem.departmentName}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>
</body>
</html>
