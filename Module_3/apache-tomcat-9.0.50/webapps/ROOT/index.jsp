<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid p-4">
    <div class="col-lg-12">
        <div class="row">
            <div class="col-lg-6">
                <div class="row">
                    <div class="col-lg-12">
                        LOGO
                    </div>
                </div>
            </div>
            <div class="col-lg-6 position-relative">
                <div class="row position-absolute top-0 end-0 pe-1">
                    <div class="col-lg-12 ">
                        NGUYEN VAN A
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-5">
                <li class="nav-item me-lg-5">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item me-lg-5">
                    <a class="nav-link" href="#">Employee</a>
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
<div class="container-fluid m-lg-5">
    <div class="row">
        <div class="col-lg-3">
            <div class="list-group" id="list-tab" role="tablist">
                <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list"
                   href="#list-home" role="tab" aria-controls="list-home">Item One</a>
                <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list"
                   href="#list-profile" role="tab" aria-controls="list-profile">Item Two</a>
                <a class="list-group-item list-group-item-action" id="list-messages-list" data-bs-toggle="list"
                   href="#list-messages" role="tab" aria-controls="list-messages">Item Three</a>
            </div>
        </div>
        <div class="col-lg-9 bg-body">
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
                    <div class="col-lg-12">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. A accusamus architecto asperiores
                        commodi culpa eius exercitationem hic incidunt, ipsum itaque labore, laborum nam quam quia
                        repudiandae totam vitae, voluptate voluptatum.
                    </div>
                    <div>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad corporis eligendi esse et ex
                        impedit mollitia necessitatibus numquam praesentium, vel. Consectetur dolorem eius esse
                        inventore nobis nostrum officiis sit tenetur?
                    </div>
                    <div>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem debitis eum laborum, obcaecati
                        praesentium quae quaerat. Commodi dolor dolorum earum et impedit ipsa, ipsam officia ratione
                        totam vitae voluptas voluptatibus?
                    </div>
                    <div>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab ad assumenda atque consequatur
                        cumque cupiditate deleniti dolore dolores enim nemo nihil optio pariatur quas quisquam ratione
                        repudiandae, similique? Necessitatibus, perferendis?
                    </div>
                </div>
                <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">...
                </div>
                <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">...
                </div>
            </div>
        </div>
    </div>
</div>
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