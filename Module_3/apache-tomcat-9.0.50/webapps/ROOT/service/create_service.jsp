<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Service</title>
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
                    <h3>Create Service</h3>
                    <form method="post">
                        <div class="mb-3">
                            <label class="form-label">Name Service</label>
                            <input type="text" name="nameService" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Service Area </label>
                            <input type="number" name="area" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Floor </label>
                            <input type="number" name="floor" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Capacity</label>
                            <input type="date" name="capacity" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Rent Cost</label>
                            <input type="number" name="cost" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">ID Card</label>
                            <input type="text" name="idCard" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="rent">Rent Type</label>
                            <select name="rentType" id="rent" class="form-select">
                                <c:forEach var="rentType" items="${rentType}">
                                    <option value="${rentType.getIdRentType()}">${rentType.getRentType()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="serviceType">Service Type</label>
                            <select name="serviceType" id="serviceType" class="form-select">
                                <c:forEach var="serviceType" items="${serviceType}">
                                    <option value="${serviceType.getIdServiceType()}">${serviceType.getServiceType()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Description</label>
                            <input type="text" name="description" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Standard</label>
                            <input type="text" name="standard" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Pool Area</label>
                            <input type="number" name="pool" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
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