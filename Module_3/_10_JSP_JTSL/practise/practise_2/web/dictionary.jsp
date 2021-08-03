<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/2/2021
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
    <%! Map<String,String> dic = new HashMap<>();%>
    <%
    dic.put("hello","Hello xin chào mọi người đã đến với channel của mình");
    dic.put("Cat","Mèo méo meo mèo meo");
    dic.put("Sea","Biển");

    String search = request.getParameter("search");
    String result = dic.get(search);
    if (result != null){
        out.println("Word: "+search+"<br>");
        out.println("Result: "+result);
    } else {
        out.println("Not found");
    }
    %>
</body>
</html>
