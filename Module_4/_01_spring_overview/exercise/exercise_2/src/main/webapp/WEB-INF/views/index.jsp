<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
  </head>
  <body>
  <h1>Simple dictionary</h1>
  <form action="/dictionary" method="post">
    <input type="text" name="word" placeholder="Input....">
    <input type="submit" value="Search">
  </form>
  <h3>
    <c:if test="${result!= null}">
      Result: ${result}
    </c:if>
    <c:if test="${result==null}">
      Not Found!!!
    </c:if>
  </h3>
  </body>
</html>
