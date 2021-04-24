<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/4/17
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <!--以前一个servlet：这个servlet配置一个url-pattern(/hello)-->
  <a href="hello">你好</a>
  <h1>RequestMapping测试</h1>
  <a href="handle01">test01-写在方法上的requestMapping</a><br/>
  <a href="haha/handle01">test01-写在方法上的requestMapping</a>
  <h1>测试RequestMapping的属性</h1>
  <a href="haha/handle02">handle02</a><br/>
  <form action="haha/handle02" method="post">
    <input type="submit">
  </form>
  <a href="haha/handle03">handle03-测试params</a><br/>
  <a href="haha/handle04">handle04-测试headers</a><br/>
  <hr/>
  <h1>RequestMapping-Ant风格的URL</h1>
  <a href="antTest01">精确请求地址-antTest01</a><br/>
  </body>
</html>
