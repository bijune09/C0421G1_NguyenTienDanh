<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Contract</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div class="container-fluid m-lg-3">
    <div class="row">
        <div class="col-lg-3">
            <jsp:include page="/side_column.jsp"></jsp:include>
        </div>
        <div class="col-lg-9">
            <div class="row">
                <div class="col-lg-12">
                    <h3>Create new contract</h3>
                    <legend>Create Form</legend>
                    <form method="post">
                        <div class="mb-3">
                            <label class="form-label">Start Day:</label>
                            <input type="date" name="start" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">End Day: </label>
                            <input type="date" name="end" class="form-control">
                        </div>
                        <%--                employee--%>
                        <div class="mb-3">
                            <label class="form-label" for="employeeList">Employee:</label>
                            <select name="idEmployee" id="employeeList" class="form-select">
                                <c:forEach var="employee" items="${employeeList}">
                                    <option value="${employee.getEmployee_id()}">${employee.getEmployee_name()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <%--                customer--%>
                        <div class="mb-3">
                            <label class="form-label" for="customerList">Customer:</label>
                            <select name="idCustomer" id="customerList" class="form-select">
                                <c:forEach var="customer" items="${customerList}">
                                    <option value="${customer.getIdCustomer()}">${customer.getCustomerName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <%--                service--%>
                        <div class="mb-3">
                            <label class="form-label" for="serviceList">Service:</label>
                            <select name="idService" id="serviceList" class="form-select">
                                <c:forEach var="service" items="${serviceList}">
                                    <option value="${service.getIdService()}">${service.getNameService()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Deposit:</label>
                            <input type="number" name="deposit" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Total: </label>
                            <input type="number" name="total" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
