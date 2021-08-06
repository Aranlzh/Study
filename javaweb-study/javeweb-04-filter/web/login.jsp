<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/filter/login" method="post">
        用户名：<input type="text" name="username"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
