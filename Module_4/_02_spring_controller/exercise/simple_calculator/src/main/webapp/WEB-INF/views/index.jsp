<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<hr>
<h3>
  <c:if test="${result != null}">
    Result : ${result}
  </c:if>
</h3>
</body>
</html>