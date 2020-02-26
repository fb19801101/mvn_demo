<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/8
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>IDEA TEST</title>
</head>
<body>
  <%! public class Circle {
    double r;
    Circle(double r) {
      this.r=r;}
    double 求面积() {
      return Math.PI*r*r;}
    double 求周长() {
      return Math.PI*2*r;}
  }%>

  <%! int Hello(int i) {
    return i*10;
    }

    void Test() {
      System.out.print("IDEA TEST");
  }%>

  <h1>logining...</h1>
  <form action="method" method="post">
    username：<input type="text" name="username" value="<%=request.getAttribute("temp_username")%>"/>
    <%=request.getAttribute("msg_username") != null?request.getAttribute("msg_username"):""%><br>
    password：<input type="password" name="password">
    <%=request.getAttribute("msg_password") != null?request.getAttribute("msg_password"):""%><br>
    <input type="submit" name="method" value="LoginGet">
  </form>

  <% String str=request.getParameter("radius");
    double r;
    if(str != null) {
      r=Double.valueOf(str).doubleValue();
    } else {
      r=1;
    }

    request.setAttribute("radius", r);
    Circle circle=new Circle(r); // 创建对象。
  %>

  <p> 请输入圆的半径： <br>
  <form action="input.jsp" method=get name="form1">
    <input type="text" name="radius" id="radius" value=<%=r%>>
    <input type="submit" name="submit" value="计算周长/面积">
  </form>

  <script>
    function setVal() {
      document.getElementById("radius").value;
      document.form1.radius.value = 200;
    }
  </script>

  <p> 圆的面积是： <br>
    <%=circle.求面积()%>
  <p> 圆的周长是： <br>
    <%=circle.求周长()%>
</body>
</html>
