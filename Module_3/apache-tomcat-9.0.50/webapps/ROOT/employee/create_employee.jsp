<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<html>
<head>
    <title>Create new Employee</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-5">
                <li class="nav-item me-lg-5">
                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item me-lg-5">
                    <a class="nav-link" href="/employees">Employee</a>
                </li>
                <li class="nav-item me-lg-5">
                    <a class="nav-link" href="#">Customer</a>
                </li>
                <li class="nav-item me-lg-5">
                    <a class="nav-link" href="#">Service</a>
                </li>
                <li class="nav-item me-lg-5">
                    <a class="nav-link" href="#">Contract</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light  " type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<h1>Create Form</h1>

<fieldset>
    <legend>Create new employee</legend>
    <form method="post">
<%--        <input type="hidden" name="action" value="create">--%>
        <div class="mb-3">
            <label class="form-label">Name: </label>
            <input type="text" class="form-control" name="nameEmployee">
        </div>
        <div class="mb-3">
            <label class="form-label">Birthday:</label>
            <input type="date" class="form-control" name="birthday">
        </div>
        <div class="mb-3">
            <label class="form-label">ID Card:</label>
            <input type="text" class="form-control" name="idCard">
        </div>
        <div class="mb-3">
            <label class="form-label">Salary:</label>
            <input type="number" class="form-control" name="salary" min="0">
        </div>
        <div class="mb-3">
            <label class="form-label">Phone Number:</label>
            <input type="tel" class="form-control" name="phone">
        </div>
        <div class="mb-3">
            <label class="form-label">Email:</label>
            <input type="email" class="form-control" name="email">
        </div>
        <div class="mb-3">
            <label class="form-label">Address:</label>
            <input type="tel" class="form-control" name="address">
        </div>
        <div class="mb-3">
            <label class="form-label" for="position">Position ID:</label>
<%--            <input type="number" class="form-control" name="positionId">--%>
            <select name="positionId" id="position" class="form-select">
                <c:forEach items="${positionList}" var="position">
                    <option value="${position.getPositionId()}">${position.getPositionName()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label" for="education">Education ID:</label>
<%--            <input type="number" class="form-control" name="educationId">--%>
            <select name="educationId" id="education" class="form-select">
                <c:forEach items="${educationList}" var="education">
                    <option value="${education.getEducationId()}">${education.getEducationName()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label" for="division">Division ID:</label>
<%--            <input type="number" class="form-control" name="divisionId">--%>
            <select name="divisionId" id="division" class="form-select">
                <c:forEach items="${divisionList}" var="division">
                    <option value="${division.getDivisionId()}">${division.getDivisionName()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Username:</label>
            <input type="text" class="form-control" name="username">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</fieldset>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>