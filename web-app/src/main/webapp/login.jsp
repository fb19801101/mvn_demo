<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/9
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'login.jsp' starting page</title>
</head>
<body>
This is my JSP page. <br>
<form action="method" method="post">
    username:<input type="text" name="username" value="jsp"><br>
    password:<input type="password" name="password" value="1"><br>
    autologin:<input type="checkbox" name="autologin" value="true">
    remberpwd:<input type="checkbox" name="remberpwd" value="true"><br>
    <input type="submit" name="method" value="LoginGet">
</form>
</body>
</html>