<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/15/2021
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div class="container-fluid m-1">
    <div class="row">
        <div class="col-lg-3">
            <jsp:include page="/side_column.jsp"></jsp:include>
        </div>
        <div class="col-lg-9">
            <h3>Create Employee</h3>
            <legend>Create new employee</legend>
            <form method="post">
                <%--        <input type="hidden" name="action" value="create">--%>
                <div class="mb-3">
                    <label class="form-label">Name: </label>
                    <input type="text" class="form-control" name="name">
                    <p class="text-warning">${msgName}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label">Birthday:</label>
                    <input type="date" class="form-control" name="birthday">
                </div>
                <div class="mb-3">
                    <label class="form-label">ID Card:</label>
                    <input type="text" class="form-control" name="idCard">
                    <p class="text-warning">${msgIdCard}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label">Salary:</label>
                    <input type="number" class="form-control" name="salary" min="0">
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone Number:</label>
                    <input type="tel" class="form-control" name="phone">
                    <p class="text-warning">${msgPhone}</p>
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
                <div class="mb-3">
                    <label class="form-label">Username:</label>
                    <input type="text" class="form-control" name="username">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
