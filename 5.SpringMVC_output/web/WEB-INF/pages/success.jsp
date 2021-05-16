<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/5/5
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello</h1>
pageContext: ${pageScope.msg}<br/>
request: ${requestScope.msg}<br/>
session: ${sessionScope.msg}--${sessionScope.haha}<br/>
application: ${applicationScope.msg}<br/>
<%System.out.println("来到页面了...");%>
</body>
</html>
