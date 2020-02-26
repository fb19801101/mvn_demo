<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/9
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.mvn.service.LoginBeam" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>My JSP 'failure.jsp' starting page</title>
    </head>
    <body>
        Login Failed!<br>
        <%LoginBeam account = (LoginBeam)session.getAttribute("account");%>
        username:<%= account.getUsername()%><br>
        password:<%= account.getPassword()%><br>
        autologin:<%= account.getAutologin()%>
        remberpwd:<%= account.getRemberpwd()%><br>
        basePath:<%=basePath%><br>
        path:<%=path%>
    </body>
</html>