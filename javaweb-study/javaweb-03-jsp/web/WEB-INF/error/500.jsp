<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--指定是不是错误处理页面，可以使用Exception隐含变量--%>
<%@ page isErrorPage="true" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
Error Message <%=exception.getMessage()%>
<img src="../../../image/500.jpg" style="width: 100%" alt="500">
</body>
</html>
