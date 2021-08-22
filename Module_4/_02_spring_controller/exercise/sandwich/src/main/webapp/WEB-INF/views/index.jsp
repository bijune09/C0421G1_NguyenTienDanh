<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/save">
    <input type="checkbox" name="spice" value="Lettuce" id="check1">
    <label for="check1"> Lettuce</label>
    <input type="checkbox" name="spice" value="Tomato" id="check2">
    <label for="check2"> Tomato</label>
    <input type="checkbox" name="spice" value="Mustard" id="check3">
    <label for="check3"> Mustard</label>
    <input type="checkbox" name="spice" value="Sprouts" id="check4">
    <label for="check4"> Sprouts</label>
    <br><br>
    <input type="submit" value="save">
  </form>
  <h3>
    <c:if test="${spice !=null}">
      Sandwich spices : ${spice}
    </c:if>
  </h3>
  </body>
</html>
