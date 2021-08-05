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
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<body>
<%--<form method="post" action="${ctp}/testRequestBody" enctype="multipart/form-data">--%>
<form method="post" action="${ctp}/test02" enctype="multipart/form-data">
    <input name="username" value="tomcat"/>
    <input name="password" value="123456"/>
    <input type="file" name="file"/>
    <input type="submit"/>
</form>
<a href="testRequestBody">ajax发送json数据</a>
</body>
<script type="text/javascript">
    ${"a:first"}.click(function (){
      // 点击发送ajax请求，请求带的数据是json
      // js对象
      var emp = {lastName: "张三", email: "aaa@aa.com", gender: 0};
      var empStr = JSON.stringify(emp);
      $.ajax({
        url:'${ctp}/testRequestBody',
        type:'POST',
        contentType: "application/json",
        data: empStr,
        success: function (data) {
          alert(data);
        }
      });
      return false;
    });
</script>
</html>
