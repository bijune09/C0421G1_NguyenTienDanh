<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body{
            width: auto;!important;
            overflow-x: hidden;!important;
        }
        form{
            padding-left: 260px;
            width: 75%;
        }
    </style>
</head>
<body>
<jsp:include page="/layout/header.jsp"></jsp:include>
<div class="container-fluid m-1">
    <div class="row">
        <div class="col-lg-3">
            <jsp:include page="/layout/side_column.jsp"></jsp:include>
        </div>
        <div class="col-lg-9 bg-info">
            <h3>Edit</h3>
            <form method="post" >
                <div class="mb-3">
                    <label class="form-label">Name: </label>
                    <input type="text" class="form-control" name="name" value="${product.productName}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Price:</label>
                    <input type="number" class="form-control" name="price" value="${product.productPrice}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Quantity:</label>
                    <input type="number" class="form-control" name="quantity" value="${product.quantity}">
                </div>
                <div class="mb-3">
                    <label class="form-label">Color:</label>
                    <input type="text" class="form-control" name="color" value="${product.color}">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="category">Position ID:</label>
                    <select name="categoryId" id="category" class="form-select">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.categoryId}">${category.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="/layout/footer.jsp"></jsp:include>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>