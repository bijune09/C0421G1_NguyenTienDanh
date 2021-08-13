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
            <div class="row">
                <div class="col-lg-12">
                    <h3>Contract Page</h3>
                    <a href="/contracts?action=create" class="btn btn-primary" role="button">Create New Contract</a>
                    <a href="/contracts?action=createContract" class="btn btn-primary" role="button">Create New Contract
                        Detail</a>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">ID Customer</th>
                            <th scope="col">Customer Name</th>
                            <th scope="col">Customer Code</th>
                            <th scope="col">ID Contract</th>
                            <th scope="col">Attach Service</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${customerUsingList}" var="customer">
                            <tr>
                                <td>${customer.getCustomerId()}</td>
                                <td>${customer.getNameCustomer()}</td>
                                <td>${customer.getCustomerCode()}</td>
                                <td>${customer.getIdContract()}</td>
                                <td>${customer.getAttachServiceName()}</td>
                                <td>
                                    <a class="btn btn-primary"
                                       href="/contracts?action=edit&id=${customer.getCustomerId()}"
                                       role="button">Edit</a>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#staticBackdrop"
                                            onclick="onDelete(${customer.getCustomerId()})">
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
    </div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>

<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Do you want delete?
            </div>
            <form action="/contracts" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="" id="idDelete">
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
<script>
    function onDelete(id) {
        document.getElementById("idDelete").value = id;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
