<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>if测试</h4>
<form action="jsptag.jsp" method="get">
    <%--
    EL表达式获取表单中的数据
    ${param.参数名}
    --%>
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="登录">
</form>
<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="管理员欢迎您！"/><br>
</c:if>
<c:out value="isAdmin:${isAdmin}"/>
<hr>

<h4>set、choose、when测试</h4>
<c:set var="score" value="85"/>
<c:out value="你的成绩为：${score}"/><br>
<c:choose>
    <c:when test="${score>=90}">优</c:when>
    <c:when test="${score>=80}">良</c:when>
    <c:when test="${score>=70}">中</c:when>
    <c:when test="${score>=60}">及格</c:when>
    <c:when test="${score<60}">差</c:when>
</c:choose>
<hr>

<h4>for测试</h4>
<%
    List<String> people = new ArrayList<>();
    people.add("张三");
    people.add("李四");
    people.add("王五");
    people.add("赵六");
    request.setAttribute("list",people);
%>

<%--
var 每一次遍历出来的变量名
items 要遍历的对象
begin 开始
end 结束
step 步长

--%>
<c:forEach var="people" items="${list}">
    <c:out value="${people}"/><br>
</c:forEach>
<br>
<c:forEach begin="0" end="4" step="2" var="people" items="${list}">
    <c:out value="${people}"/><br>
</c:forEach>

</body>
</html>
