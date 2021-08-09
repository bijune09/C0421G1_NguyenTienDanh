<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>Employee Page</title>
</head>
<body>
<%--navbar--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-5">
                <li class="nav-item me-lg-5">
                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item me-lg-5">
                    <a class="nav-link" href="/employees">Employee</a>
                </li>
                <li class="nav-item me-lg-5">
                    <a class="nav-link" href="#">Customer</a>
                </li>
                <li class="nav-item me-lg-5">
                    <a class="nav-link" href="#">Service</a>
                </li>
                <li class="nav-item me-lg-5">
                    <a class="nav-link" href="#">Contract</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light  " type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="col-lg-12">
        <a class="btn btn-primary" href="/employees?action=create" role="button">Create employee</a>
    </div>
</div>

<div class="container-fluid">
    <div class="col-lg-12">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Position</th>
                <th scope="col">Education</th>
                <th scope="col">Division</th>
                <th scope="col">Birthday</th>
                <th scope="col">ID Card</th>
                <th scope="col">Salary</th>
                <th scope="col">Phone</th>
                <th scope="col">Email</th>
                <th scope="col">Address</th>
                <th scope="col">User_name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employeeList}" var="employee">
                <tr>
                    <td>${employee.getEmployee_id()}</td>
                    <td>${employee.getEmployee_name()}</td>
                    <td>${employee.getEmployee_id_position()}</td>
                    <td>${employee.getEmployee_id_education()}</td>
                    <td>${employee.getEmployee_id_division()}</td>
                    <td>${employee.getEmployee_birthday()}</td>
                    <td>${employee.getEmployee_id_card()}</td>
                    <td>${employee.getEmployee_salary()}</td>
                    <td>${employee.getEmployee_phone()}</td>
                    <td>${employee.getEmployee_email()}</td>
                    <td>${employee.getEmployee_address()}</td>
                    <td>${employee.getEmployee_user_name()}</td>
                    <td>
                        <a class="btn btn-primary" href="/employees?action=edit&id=${employee.getEmployee_id()}"
                           role="button">Edit</a>
                        <a class="btn btn-primary" href="#" role="button">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<%--footer--%>
<div class="container-fluid bg-dark p-lg-3">
    <div class="row">
        <div class="col-lg-12 text-center text-color text-white">
            this is footer
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