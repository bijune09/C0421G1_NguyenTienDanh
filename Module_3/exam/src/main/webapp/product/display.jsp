<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap5.min.css">
    <style>
        body {
            width: auto;
        !important;
            overflow-x: hidden;
        !important;
        }
    </style>

</head>
<body>
<jsp:include page="/layout/header.jsp"></jsp:include>
<div class="container-fluid m-2" style="min-height: 100vh">
    <div class="row">
        <div class="col-lg-3">
            <jsp:include page="/layout/side_column.jsp"></jsp:include>
        </div>
        <div class="col-lg-9">
            <h3>Product List</h3>
            <div class="container-fluid">
                <div class="col-lg-12">
                    <a class="btn btn-primary" href="/products?action=create" role="button">Create product</a>
                </div>
            </div>
            <div class="container-fluid">
                <div class="col-lg-12">
                    <form action="/products?action=search" method="post">
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Product Name:</label>
                            <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="name" name="name">
                        </div>
                        <button type="submit" class="btn btn-primary">search</button>
                    </form>
                </div>
            </div>
            <table id="example" class="table table-striped table-bordered"
                   style="width:100%;display: inline-block">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Color</th>
                    <th scope="col">Category</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.productPrice}</td>
                        <td>${product.quantity}</td>
                        <td>${product.color}</td>
                        <c:choose>
                            <c:when test="${product.categoryId=='1'}">
                                <td>Phone</td>
                            </c:when>
                            <c:when test="${product.categoryId=='2'}">
                                <td>Tivi</td>
                            </c:when>
                            <c:when test="${product.categoryId=='3'}">
                                <td>Tủ lạnh</td>
                            </c:when>
                            <c:otherwise>
                                <td>Máy giặt</td>
                            </c:otherwise>
                        </c:choose>
                        <td class="d-flex">
                            <a class="btn btn-warning" href="/products?action=edit&id=${product.productId}"
                               role="button">Edit</a>
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                    data-bs-target="#staticBackdrop"
                                    onclick="deleteEmployee('${product.productId}')">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="/layout/footer.jsp"></jsp:include>

<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
<%--            chú ý action--%>
            <form action="/products" method="post">
                <div class="modal-body">
                    Do you want delete?
                </div>
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="" id="idProductDelete">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-primary">Yup</button>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap5.min.js"></script>

<script>
    $(document).ready(function () {
        $('#example').DataTable(
            {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            }
        );
    });

    function deleteEmployee(id) {
        document.getElementById("idProductDelete").value = id;
    }
</script>