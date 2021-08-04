<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result:</h1>
<p><c:out value="${firstNumber}"></c:out> <c:out value="${operator}"></c:out>
    <c:out value="${secondNumber}"></c:out> =
    <c:out value="${result}"></c:out></p>
</body>
</html>
