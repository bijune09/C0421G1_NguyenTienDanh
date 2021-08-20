<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body{
            width: auto;!important;
            overflow-x: hidden;!important;
        }
    </style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div class="container-fluid m-1">
    <div class="row">
        <div class="col-lg-3">
            <jsp:include page="/side_column.jsp"></jsp:include>
        </div>
        <div class="col-lg-9">
            <h3>Edit Employee</h3>
            <form method="post">
                <div class="mb-3">
                    <label class="form-label">Name: </label>
                    <input type="text" class="form-control" name="name" value="${employee.name}">
                    <p class="text-warning">${msgName}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label">Birthday:</label>
                    <input type="date" class="form-control" name="birthday" value="${employee.birthday}">
                </div>
                <div class="mb-3">
                    <label class="form-label">ID Card:</label>
                    <input type="text" class="form-control" name="idCard" value="${employee.idCard}">
                    <p class="text-warning">${msgIdCard}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label">Salary:</label>
                    <input type="number" class="form-control" name="salary" value="${employee.salary}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone Number:</label>
                    <input type="tel" class="form-control" name="phone" value="${employee.phone}">
                    <p class="text-warning">${msgPhone}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label">Email:</label>
                    <input type="email" class="form-control" name="email" value="${employee.email}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address:</label>
                    <input type="tel" class="form-control" name="address" value="${employee.address}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Position ID:</label>
                    <label class="form-label" for="position">Position ID:</label>
                    <select name="positionId" id="position" class="form-select">
                        <c:forEach items="${positionList}" var="position">
                            <option value="${position.getPositionId()}">${position.getPositionName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="education">Education ID:</label>
                    <select name="educationId" id="education" class="form-select">
                        <c:forEach items="${educationList}" var="education">
                            <option value="${education.getEducationId()}">${education.getEducationName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="division">Division ID:</label>
                    <select name="divisionId" id="division" class="form-select">
                        <c:forEach items="${divisionList}" var="division">
                            <option value="${division.getDivisionId()}">${division.getDivisionName()}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>