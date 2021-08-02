<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/2/2021
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Product: <%=request.getAttribute("product")%></h2>
<h2>Discount amount<%=request.getAttribute("discountAmount")%></h2>
<h2>Discount Price <%=request.getAttribute("discountPrice")%></h2>
</body>
</html>
