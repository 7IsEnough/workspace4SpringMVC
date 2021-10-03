<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/9/25
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <%
    pageContext.setAttribute("ctp", request.getContextPath());
  %>
  <body>
  <a href="${ctp}/handle01?i=0">test01-哈哈</a>
  <a href="${ctp}/handle02?username=admin">handle02</a>
  <a href="${ctp}/handle03">handle03</a>
  <a href="${ctp}/handle04">handle04</a>
  </body>
</html>
