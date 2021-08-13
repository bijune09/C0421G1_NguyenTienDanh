<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Contract Detail</title>
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
                            <label class="form-label" for="contract">Contract ID:</label>
                            <select name="contractId" id="contract" class="form-select">
                                <c:forEach var="contract" items="${contractList}">
                                    <option value="${contract.getIdContract()}">${contract.getIdContract()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="attach">Attach Service:</label>
                            <select name="attachId" id="attach" class="form-select">
                                <c:forEach var="attachService" items="${attachServiceList}">
                                    <option value="${attachService.getAttachServiceId()}">${attachService.getAttachServiceName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Quantity: </label>
                            <input type="number" name="quantity" class="form-control">
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

