<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--内置对象--%>
<%
    // 通过pageContext取出，通过寻找的方式来
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5"); // 不存在
%>

<%--使用EL表达式输出 ${}--%>
<h1>取出的值为：</h1>
<h3>${name1}</h3> <%--直接打开不显示，通过PageContextDemo01转发进来显示：request--%>
<h3>${name2}</h3> <%--显示：session有效--%>
<h3>${name3}</h3> <%--不显示：pageContext--%>
<h3>${name4}</h3> <%--显示：application有效--%>
<%--不显示--%>
<h3>${name5}</h3>
<%--显示null--%>
<h3><%=name5%></h3>

名字：<%=request.getParameter("name")%>
年龄：<%=request.getParameter("age")%>

</body>
</html>
