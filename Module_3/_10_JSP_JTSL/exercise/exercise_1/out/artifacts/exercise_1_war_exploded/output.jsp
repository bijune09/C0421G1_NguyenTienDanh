<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/3/2021
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display Customer List</title>
</head>
<body>
<h1>Customer List</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Dob</th>
        <th>Address</th>
        <th>Img</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.dob}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td>
                <img src="${customer.imgURL}" width="50px" height="50px">
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
