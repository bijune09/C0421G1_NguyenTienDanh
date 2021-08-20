<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
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
            <h3>Create</h3>
            <span class="text-danger">${msg}</span>
            <form method="post">
                <div class="mb-3">
                    <label class="form-label">Name: </label>
                    <input type="text" class="form-control" name="name">
                </div>
                <div class="mb-3">
                    <label class="form-label">Price:</label>
                    <input type="number" class="form-control" name="price">
                </div>
                <div class="mb-3">
                    <label class="form-label">Quantity:</label>
                    <input type="number" class="form-control" name="quantity">
                </div>
                <div class="mb-3">
                    <label class="form-label">Color:</label>
                    <select name="color" id="colorId">
                        <option value="red" selected>red</option>
                        <option value="green">green</option>
                        <option value="black">black</option>
                        <option value="yellow">yellow</option>
                        <option value="white">white</option>
                    </select>
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
                <a href="/products" role="button" class="btn btn-dark">Back</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/layout/footer.jsp"></jsp:include>
</body>
</html>
