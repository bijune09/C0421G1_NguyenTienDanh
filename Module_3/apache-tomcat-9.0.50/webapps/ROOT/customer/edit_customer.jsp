<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div class="contain-fluid m-lg-5">
    <div class="row">
        <div class="col-lg-3">
            <jsp:include page="/side_column.jsp"></jsp:include>
        </div>
        <div class="col-lg-9">
            <h3>Edit Customer</h3>
            <form method="post">
                <div class="mb-3">
                    <label class="form-label">Name: </label>
                    <input type="text" class="form-control" name="name" value="${customer.getCustomerName()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Birthday:</label>
                    <input type="date" class="form-control" name="birthday" value="${customer.getCustomerBirthday()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">ID Card:</label>
                    <input type="text" class="form-control" name="idCard" value="${customer.getCustomerIdCard()}">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="selectType">Type Customer:</label>
                    <select name="typeCustomer" id="selectType" class="form-select">
                        <c:forEach var="typeCustomer" items="${typeCustomer}">
                            <option value="${typeCustomer.getIdTypeCustomer()}">${typeCustomer.getTypeCustomer()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone Number:</label>
                    <input type="tel" class="form-control" name="phone" value="${customer.getCustomerPhone()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email:</label>
                    <input type="email" class="form-control" name="email" value="${customer.getCustomerEmail()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address:</label>
                    <input type="tel" class="form-control" name="address" value="${customer.getCustomerAddress()}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Customer Code:</label>
                    <input type="text" class="form-control" name="customerCode" value="${customer.getCustomerCode()}">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="customerGender">Gender</label>
                    <select name="gender" id="customerGender" class="form-select">
                        <option value="false">Female</option>
                        <option value="true">Male</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>

            </form>
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
