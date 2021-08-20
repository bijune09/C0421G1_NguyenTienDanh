
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert Money</title>
</head>
<body>
<h1>Simple Convert
</h1>
<form action="/convert" method="post">
    <p>USD</p>
    <input type="number" name="usd" placeholder="Input....">
    <input type="submit" value="Convert">
    <h3 style="color: chocolate">Result:${result} VND</h3>
</form>
</body>
</html>
