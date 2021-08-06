<%@ page import="top.aranlzh.pojo.Peopole" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

1号：<br>
<jsp:useBean id="people" class="top.aranlzh.pojo.Peopole" scope="page"/>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="name" value="1号"/>
<jsp:setProperty name="people" property="age" value="24"/>
<jsp:setProperty name="people" property="address" value="深圳"/>
id：<jsp:getProperty name="people" property="id"/><br>
姓名：<jsp:getProperty name="people" property="name"/><br>
年龄：<jsp:getProperty name="people" property="age"/><br>
地址：<jsp:getProperty name="people" property="address"/><br>

2号：<br>
<%
    Peopole p = new Peopole();
    p.setId(2);
    p.setName("2号");
    p.setAge(25);
    p.setAddress("深圳");
%>
id：<%=p.getId()%><br>
姓名：<%=p.getName()%><br>
年龄：<%=p.getAge()%><br>
地址：<%=p.getAddress()%><br>

</body>
</html>
