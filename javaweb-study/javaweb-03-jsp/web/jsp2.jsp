<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%--定制错误页面--%>
<%--<%@ page errorPage="error/500.jsp" %>--%>

<%--或者使用配置的方法统一配置--%>
<%--<error-page>--%>
<%--    <error-code>500</error-code>--%>
<%--    <location>/error/500.jsp</location>--%>
<%--</error-page>--%>

<head>
    <title>Title</title>
</head>
<body>

<%
    int x=1/0;
%>

</body>
</html>
