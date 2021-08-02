<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/2/2021
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <h2>Form input</h2>
  <form action="/calculator" method="post">
    <lable>Product Description</lable>
    <br>
    <input type="text" name="productDescription" placeholder="Description">
    <br>
    <lable>List Price</lable>
    <br>
    <input type="text" name="price" placeholder="price" value="0">
    <br>
    <lable>Discount Percent</lable>
    <br>
    <input type="text" name="discountPercent" placeholder="percent" value="0">
    <br>
    <input type="submit" id="submit" value="calculate">
  </form>
  </body>
</html>
