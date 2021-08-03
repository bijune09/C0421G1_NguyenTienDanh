<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/3/2021
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result:</h1>
<p><c:out value="${firstNumber}"></c:out> +
    <c:out value="${secondNumber}"></c:out> =
    <c:out value="${result}"></c:out></p>
</body>
</html>
