<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2021/7/29
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/hello" method="post">
    <input type="text" name="method">
    <input type="submit">
</form>

</body>
</html>
