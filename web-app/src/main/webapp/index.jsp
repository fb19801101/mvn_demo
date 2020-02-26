<%@ page import="com.mvn.service.XTPString" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/8
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>IDEA学习</title>
  </head>
  <body>
    <h1 style="color: red"><%=XTPString.getDescription()%></h1>
    <h2 style="color: blue">信息化管理部</h2>

    <hr>
    <form action="method" method="post">
      method - 0:IndexGet(request, response);<br>
      <a href="input.jsp">method - 1:InputGet(request, response);</a> <br>
      <a href="login.jsp">method - 2:LoginGet(request, response);</a> <br>
      <input type="submit" name="method" value="IndexGet">
      <input type="submit" name="method" value="InputGet">
      <input type="submit" name="method" value="LoginGet">
    </form>
  </body>
</html>