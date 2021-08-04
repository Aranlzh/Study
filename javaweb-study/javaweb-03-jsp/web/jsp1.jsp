<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="WEB-INF/common/header.jsp"%>
    <h1>网页主体</h1>
    <%@ include file="WEB-INF/common/footer.jsp"%>

    <hr>

    <%--jsp标签
    jsp:include：拼接页面，本质还是三个
    --%>
    <jsp:include page="WEB-INF/common/header.jsp"/>
    <h1>网页主体</h1>
    <jsp:include page="WEB-INF/common/footer.jsp"/>


</body>
</html>
