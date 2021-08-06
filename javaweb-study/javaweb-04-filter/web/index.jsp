<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/8/5
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--${OnlineCount}<br>--%>
  <h1>当前有人<span style="color: red"><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span>在线</h1>
  </body>
</html>
