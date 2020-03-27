<%--
  Created by IntelliJ IDEA.
  User: Dwane
  Date: 2020/3/27
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--获取表单键入的用户名，动态呈现-->
<h1>Welcome,<%=request.getParameter("name")%>!</h1>
<h2>enjoy your time!</h2>
</body>
</html>
