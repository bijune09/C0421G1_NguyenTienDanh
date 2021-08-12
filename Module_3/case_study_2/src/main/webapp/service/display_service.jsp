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
            <div class="container-fluid">
                <div class="col-lg-12">
                    <h3>Service Page</h3>
                    <a href="/services?action=create" class="btn btn-primary" role="button">Create New Service</a>
                </div>
            </div>
            <div class="container-fluid">
                <div class="col-lg-12">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Service Name:</th>
                            <th scope="col">Area</th>
                            <th scope="col">Cost</th>
                            <th scope="col">Capacity</th>
                            <th scope="col">Rent Type</th>
                            <th scope="col">Service Type</th>
                            <th scope="col">Standard Room</th>
                            <th scope="col">Description</th>
                            <th scope="col">Pool area</th>
                            <th scope="col">Floor</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${serviceList}" var="service">
                            <tr>
                                <td>${service.getIdService()}</td>
                                <td>${service.getNameService()}</td>
                                <td>${service.getServiceArea()}</td>
                                <td>${service.getRent_cost()}</td>
                                <td>${service.getCapacity()}</td>
<%--                                <td>${service.getIdRentType()}</td>--%>
                                <c:choose>
                                    <c:when test="${service.getIdRentType()=='1'}">
                                        <td>Năm</td>
                                    </c:when>
                                    <c:when test="${service.getIdRentType()=='2'}">
                                        <td>Tháng</td>
                                    </c:when>
                                    <c:when test="${service.getIdRentType()=='3'}">
                                        <td>Ngày</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Giờ</td>
                                    </c:otherwise>
                                </c:choose>
<%--                                <td>${service.getIdServiceType()}</td>--%>
                                <c:choose>
                                    <c:when test="${service.getIdServiceType()=='1'}">
                                        <td>Villa</td>
                                    </c:when>
                                    <c:when test="${service.getIdServiceType()=='2'}">
                                        <td>House</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Room</td>
                                    </c:otherwise>
                                </c:choose>
                                <td>${service.getStandard()}</td>
                                <td>${service.getDescription()}</td>
                                <td>${service.getPoolArea()}</td>
                                <td>${service.getFloor()}</td>
                                <td>
                                    <a class="btn btn-primary" href="/services?action=edit&id=${service.getIdService()}"
                                       role="button">Edit</a>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#staticBackdrop" onclick="deleteService(${service.getIdService()})">
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
            <form action="/services" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="" id="idService">
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
    function deleteService(id) {
        document.getElementById("idService").value = id;
    }
</script>