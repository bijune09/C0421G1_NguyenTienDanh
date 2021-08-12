<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
            <h3>Contract Page</h3>
            <a href="/contracts?action=create" class="btn btn-primary" role="button">Create New Contract</a>
            <a href="/contracts?action=createContractDetail" class="btn btn-primary" role="button">Create New Contract
                Detail</a>
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
