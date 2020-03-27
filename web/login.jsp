<%--
  Created by IntelliJ IDEA.
  User: Dwane
  Date: 2020/3/27
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="LoginServlet" method="post">
    用户名：<input type="text" name="name" value=""><br><br>
    密码： <input type="password" name="pwd" value=""><br><br>
    <input type="submit" value="登录" name="login">
    <input type="reset" value="重置"><br>
</form>

<form action="register.jsp">
    <input type="submit" value="注册">
</form>
</body>
</html>
