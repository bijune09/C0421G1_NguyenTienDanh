<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/4/2021
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
<form method="post">
    <h3>Do u wanna change you mind?</h3>
    <p>
        <a href="/products">Back to product list</a>
    </p>
    <fieldset>
        <legend>Product Infor</legend>
        <table>
            <tr>
                <td>ID:</td>
                <td>${product.getId()}</td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${product.getName()}</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>${product.getPrice()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" id="submit" value="Remove Product"></td>
            </tr>
        </table>


    </fieldset>
</form>
</body>
</html>
