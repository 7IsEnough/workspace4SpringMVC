<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/8/24
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <%
      pageContext.setAttribute("ctp", request.getContextPath());
    %>
  </head>
  <body>
    <a href="${ctp}/test01">test01</a>
  </body>
</html>
