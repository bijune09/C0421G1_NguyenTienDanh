<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/3/2021
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator">
    <label>First operand</label>
    <input type="text" name="first" value="0" placeholder="0"><br>
    <label>Operator: </label>
    <select name="operator">
        <option value="addition">Addition</option>
        <option value="subtraction">Subtraction</option>
        <option value="multiple">Multiplication</option>
        <option value="div">Division</option>
    </select><br>
    <label>Second operand</label>
    <input type="text" name="second" value="0" placeholder="0"><br>
    <input type="submit" id="submit" value="Calculate">
</form>
</body>
</html>
