<%--
  Created by IntelliJ IDEA.
  User: 97694
  Date: 2021/8/14
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<%
  pageContext.setAttribute("ctp", request.getContextPath());
%>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  1. 文件上传
          i.文件上传表单准备：enctype="multipart/form-data"
          ii.导入fileupload包：
              commons-fileupload-1.2.1.jar
              commons-io-2.0.jar
          iii.javaweb:
              new DiskFileItemFactory
              ServletFileUpload upload = new ServletFileUpload(object);

              List<FileItem> items = upload.parseRequest(upload)
              for(FileItem item: items) {
                if(item.isFormField){
                  // 普通项
                } else {
                  // 文件项
                  IOUtils.copy(); //文件保存
                }
              }
          springMVC：只要在springMVC配置文件中，编写一个配置，配置文件上传解析器(MultipartResolver)。
          iiii.文件上传请求处理
              在处理器方法上写一个@RequestParam("headerimg") MultipartFile file，
              封装当前的文件信息，可以直接保存
--%>
  ${msg}
  <form action="${ctp}/upload" method="post" enctype="multipart/form-data">
    用户头像：<input name="headerimg" type="file"> <br/>
    用户头像：<input name="headerimg" type="file"> <br/>
    用户头像：<input name="headerimg" type="file"> <br/>
    用户头像：<input name="headerimg" type="file"> <br/>
    用户名：<input name="username" type="text"> <br/>
    <input type="submit">
  </form>
  </body>
</html>
