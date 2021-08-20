<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display employee</title>
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
<jsp:include page="/header.jsp"></jsp:include>
<div class="container-fluid m-2" style="min-height: 100vh">
    <div class="row">
        <div class="col-lg-3">
            <jsp:include page="/side_column.jsp"></jsp:include>
        </div>
        <div class="col-lg-9">
            <h3>Employee List</h3>
            <div class="container-fluid">
                <div class="col-lg-12">
                    <a class="btn btn-primary" href="/employees?action=create" role="button">Create employee</a>
                </div>
            </div>
            <table id="example" class="table table-striped table-bordered"
                   style="width:100%; overflow-x: scroll; display: inline-block">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">ID Card</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Position</th>
                    <th scope="col">Education</th>
                    <th scope="col">Division</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.birthday}</td>
                        <td>${employee.idCard}</td>
                        <td>${employee.salary}</td>
                        <td>${employee.phone}</td>
                        <td>${employee.email}</td>
                        <td>${employee.address}</td>
                        <c:choose>
                            <c:when test="${employee.positionId=='2'}">
                                <td>Phục vụ</td>
                            </c:when>
                            <c:when test="${employee.positionId=='2'}">
                                <td>Phục vụ</td>
                            </c:when>
                            <c:when test="${employee.positionId=='3'}">
                                <td>Chuyên viên</td>
                            </c:when>
                            <c:when test="${employee.positionId=='4'}">
                                <td>Giám sát</td>
                            </c:when>
                            <c:when test="${employee.positionId=='5'}">
                                <td>Quản lý</td>
                            </c:when>
                            <c:otherwise>
                                <td>Giám đốc</td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${employee.educationId=='1'}">
                                <td>Trung cấp</td>
                            </c:when>
                            <c:when test="${employee.educationId=='2'}">
                                <td>Cao đẳng</td>
                            </c:when>
                            <c:when test="${employee.educationId=='3'}">
                                <td>Đại học</td>
                            </c:when>
                            <c:otherwise>
                                <td>Sau Đại học</td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${employee.divisionId=='1'}">
                                <td>Sale-Marketing</td>
                            </c:when>
                            <c:when test="${employee.divisionId=='2'}">
                                <td>Hành chính</td>
                            </c:when>
                            <c:when test="${employee.divisionId=='3'}">
                                <td>Phục vụ</td>
                            </c:when>
                            <c:otherwise>
                                <td>Quản lý</td>
                            </c:otherwise>
                        </c:choose>
                        <td class="d-flex">
                            <a class="btn btn-primary" href="/employees?action=edit&id=${employee.id}"
                               role="button">Edit</a>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#staticBackdrop"
                                    onclick="deleteEmployee('${employee.id}','${employee.name}')">
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
<jsp:include page="/footer.jsp"></jsp:include>

<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/employees" method="post">
                <div class="modal-body">
                    Do you want delete <input type="text" readonly value="" id="nameEmployee" style="border: none">?
                </div>
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="" id="idEmployee">
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
                "pageLength": 1
            }
        );
    });

    function deleteEmployee(id, name) {
        document.getElementById("idEmployee").value = id;
        document.getElementById("nameEmployee").value = name;
    }
</script>