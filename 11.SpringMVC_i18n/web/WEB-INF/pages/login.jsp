<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/9/23
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
<%--国际化的区域信息是决定国际化显示的因素--%>
    <fmt:message key="welcomeinfo"/>
</h1>
<form action="">
    <fmt:message key="username"/>：<input/><br/>
    <fmt:message key="password"/>：<input/><br/>
    <input type="submit" value="<fmt:message key="loginBtn"/>">
</form>
<%--如果点击超链接就切换国际化--%>
<a href="toLoginPage?locale=zh_CN">中文</a>
<a href="toLoginPage?locale=en_US">英文</a>
</body>
</html>
