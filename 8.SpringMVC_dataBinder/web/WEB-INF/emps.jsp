<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/8/2
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp", request.getContextPath());
    %>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<%=new Date()%>
<a href="${ctp}/getallajax">ajax获取所有员工</a><br/>
<div>

</div>
<script type="text/javascript">
    $("a:first").click(function (){
      //1.发送ajax请求获取所有员工
      $.ajax({
        url: "${ctp}/getallajax",
        type: "GET",
        success: function (data) {
          // console.log(data);
          $.each(data, function (){
            var empInfo = this.lastName + "-->" + this.birth + "-->" + this.gender;
            $("div").append(empInfo + "<br/>");
          });
        }
      })
      return false;
    });
</script>
</body>
</html>
