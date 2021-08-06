<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>

<%--没登录不给进--%>
<%--<%--%>
<%--    Object user_session = request.getSession().getAttribute("USER_SESSION");--%>
<%--    if (user_session==null){--%>
<%--        pageContext.forward("/login.jsp");--%>
<%--        // response.sendRedirect("/login.jsp");--%>
<%--    }--%>
<%--    Object user_role = request.getSession().getAttribute("USER_ROLE");--%>
<%--    if (user_role==null) {--%>
<%--        pageContext.forward("/login.jsp");--%>
<%--    } else if ("USER".equals(user_role)) {--%>
<%--        response.sendRedirect("/user/main.jsp");--%>
<%--    } else if (!"ADMIN".equals(user_role)) {--%>
<%--        response.sendRedirect("/login.jsp");--%>
<%--    }--%>

<%--%>--%>

管理员界面
<a href="/filter/logout">注销</a>
</body>
</html>
