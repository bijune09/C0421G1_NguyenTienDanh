<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer Page</title>
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
            <legend>Create Form</legend>
            <form method="post">
                <div class="mb-3">
                    <label class="form-label">Customer Code</label>
                    <input type="text" name="customerCode" class="form-control">
                    <p>${msgCustomerCode}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label">Name: </label>
                    <input type="text" name="name" class="form-control">
                    <p>${msgCustomerName}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="typeOfCustomer">Type Customer</label>
                    <select name="typeCustomer" id="typeOfCustomer" class="form-select">
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <option value="${customerType.getIdTypeCustomer()}">${customerType.getTypeCustomer()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Birthday</label>
                    <input type="date" name="birthday" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="customerGender">Gender</label>
                    <select name="gender" id="customerGender" class="form-select">
                        <option value="false">Female</option>
                        <option value="true">Male</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">ID Card</label>
                    <input type="text" name="idCard" class="form-control">
                    <p>${msgIdCard}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone number</label>
                    <input type="text" name="phone" class="form-control">
                    <p>${msgPhone}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-control">
                    <p>${msgEmail}</p>
                </div>
                <div class="mb-3">
                    <label class="form-label"> Address</label>
                    <input type="text" name="address" class="form-control">
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
