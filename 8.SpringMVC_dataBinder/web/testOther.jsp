<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/8/2
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp", request.getContextPath());
    %>
</head>
<body>
<form method="post" action="${ctp}/testRequestBody" enctype="multipart/form-data">
    <input name="username" value="tomcat"/>
    <input name="password" value="123456"/>
    <input type="file" name="file"/>
    <input type="submit"/>
</form>
</body>
</html>
