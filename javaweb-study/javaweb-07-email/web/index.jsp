<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/8/6
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/sendEmail" method="post" enctype="multipart/form-data">
    <p>收件人：<input type="text" name="username"></p>
    <p>主题：<input type="text" name="title"></p>
    <p>内容：<input type="text" name="content"></p>
<%--    <p>附件：<input type="file" name="file"></p>--%>
    <p><input type="submit" value="提交"> | <input type="reset"></p>
  </form>
  </body>
</html>
