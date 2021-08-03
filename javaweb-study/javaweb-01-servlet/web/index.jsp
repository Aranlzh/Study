<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello World</title>
  </head>
  <body>
  <h1>登录：GET</h1>
  <%--这里提交的路径，需要寻找到项目的路径--%>
  <%--${pageContext.request.contextPath}代表当前的项目--%>
  <div>
    <form action="${pageContext.request.contextPath}/login" method="get">
      用户名：<input type="text" name="username"><br>
      密码：<input type="password" name="password"><br>
      <input type="submit" value="提交">
    </form>
  </div>

  <h1>登录：POST</h1>
  <div>
    <form action="${pageContext.request.contextPath}/login" method="post">
      用户名：<input type="text" name="username"><br>
      密码：<input type="password" name="password"><br>
      设备：
      <input type="checkbox" name="hobby" value="3DS">3DS
      <input type="checkbox" name="hobby" value="Switch">Switch
      <input type="checkbox" name="hobby" value="Xbox">Xbox
      <input type="checkbox" name="hobby" value="PlayStation">PlayStation
      <br>
      <input type="submit" value="提交">
    </form>
  </div>

  </body>
</html>
