<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>

  <%
    String name = "阿然";
  %>
  hello,<%=name%><br>

  <%--JSP表达式
  作用：用来将程序的输出，输出到客户端
  <%= 变量或者表达式%>
  --%>
  <%= new java.util.Date()%><br>
  <%= new Date()%><br>

  <%--jsp脚本片段--%>
  <%
    int sum = 0;
    for (int i = 0; i < 100; i++) {
      sum += i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
  %>

  <%
    int x = 10;
    out.println(x);
  %>
  <p>这是一个JSP文档</p>
  <%
    int y = 10;
    out.println(y);
    out.println(x+y);
  %><br>

  <%--在代码中嵌入HTML元素--%>
  <%
    for (int i = 0; i < 5; i++) {
  %>
    <h1>Hello,World!<%=i%></h1>
  <%
    }
  %>

  <br>

  <%!
    static {
      System.out.println("Loading Servlet!");
    }

    private int globalVar = 0;

    public void functionA() {
      System.out.println("进入了方法functionA");
    }

  %>

  <!--HTML注释-->
  <%--JSP注释--%>

  </body>
</html>
