<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/4/2021
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Products</title>
</head>
<body>
<h1>List Products</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="product" items='${requestScope["productList"]}'>
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
            <td><a href="/products?action=view&id=${product.getId()}">Details</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<h2>Find product by name</h2>
<form method="post" action="/products?action=search">
    <input type="text" name="productName" id="productName" placeholder="Product Name">
    <input type="submit" value="Search">
</form>
</body>
</html>
