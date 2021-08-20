<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div class="contain-fluid m-lg-3">
    <div class="row">
        <div class="col-lg-3">
            <jsp:include page="/side_column.jsp"></jsp:include>
        </div>
        <div class="col-lg-9">
            <h3>Customer List</h3>

            <div class="container-fluid">
                <div class="col-lg-12">
                    <a class="btn btn-primary" href="/customers?action=create" role="button">Create customer</a>
                </div>
            </div>

            <div class="container-fluid">
                <div class="col-lg-12">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Customer Code</th>
                            <th scope="col">Name</th>
                            <th scope="col">Type Customer</th>
                            <th scope="col">Birthday</th>
                            <th scope="col">Gender</th>
                            <th scope="col">ID Card</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Email</th>
                            <th scope="col">Address</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${customerList}" var="customer">
                            <tr>
                                <td>${customer.getIdCustomer()}</td>
                                <td>${customer.getCustomerCode()}</td>
                                <td>${customer.getCustomerName()}</td>
<%--                                <td>${customer.getTypeCustomer()}</td>--%>
                                <c:choose>
                                    <c:when test="${customer.getTypeCustomer()=='1'}">
                                        <td>Diamond</td>
                                    </c:when>
                                    <c:when test="${customer.getTypeCustomer()=='2'}">
                                        <td>Platinum</td>
                                    </c:when>
                                    <c:when test="${customer.getTypeCustomer()=='3'}">
                                        <td>Gold</td>
                                    </c:when>
                                    <c:when test="${customer.getTypeCustomer() =='4'}">
                                        <td>Silver</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Member</td>
                                    </c:otherwise>
                                </c:choose>
                                <td>${customer.getCustomerBirthday()}</td>
                                <c:choose>
                                    <c:when test="${customer.isGender()==true}">
                                        <td>Male</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Female</td>
                                    </c:otherwise>
                                </c:choose>
<%--                                <td>${customer.isGender()}</td>--%>
                                <td>${customer.getCustomerIdCard()}</td>
                                <td>${customer.getCustomerPhone()}</td>
                                <td>${customer.getCustomerEmail()}</td>
                                <td>${customer.getCustomerAddress()}</td>
                                <td>
                                    <a class="btn btn-primary me-1" href="/customers?action=edit&id=${customer.getIdCustomer()}"
                                       role="button">Edit</a>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#staticBackdrop" onclick="deleteCustomer(${customer.getIdCustomer()})">
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
            <form action="/customers" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="" id="idCustomer">
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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<script>
    function deleteCustomer(id) {
        document.getElementById("idCustomer").value = id;
    }
</script>
