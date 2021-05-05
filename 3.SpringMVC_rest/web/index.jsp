<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/5/5
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <!--发起图书的增删改查请求
    请求URL  请求方式  表达含义
    /book/1  GET：    查询1号图书
    /book/1  DELETE： 删除1号图书
    /book/1  PUT：    更新1号图书
    /book    POST：   增加1号图书


    从页面发起PUT、DELETE形式的请求
  -->
  <a href="book/1">查询图书</a><br/>
  <form action="book" method="post">
    <input type="submit" value="添加1号图书"/>
  </form><br/>
  <a href="book/1">删除1号图书</a><br/>
  <a href="book/1">更新1号图书</a><br/>
  </body>
</html>
