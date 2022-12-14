<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <title>
                <c:out value="${param.title}" />
            </title>
            <meta name="description" content="">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="../../../pub/CSS/style.css">
            <!-- CSS only -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
            <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
            <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        </head>

        <body class="d-flex flex-column min-vh-100">

            <div class="container text-center py-3">
                <h1 class="my-3">Recumbent Bike Rental</h1>
                <nav class="navbar navbar-expand-lg navbar-dark custom-color">
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav nav-fill w-100">
                            <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="/info/all-bikes">All Bikes</a></li>
                            <sec:authorize access="!isAuthenticated()">
                                <li class="nav-item"><a class="nav-link" href="/user/createuser">Sign Up</a></li>
                                <li class="nav-item"><a class="nav-link" href="/user/login">Login</a></li>
                            </sec:authorize>
                            <sec:authorize access="hasAnyAuthority('ADMIN')">
                                <li class="nav-item"><a class="nav-link" href="/admin/admintest">Admin</a></li>
                            </sec:authorize>
                            <sec:authorize access="hasAnyAuthority('USER')">
                                <li class="nav-item"><a class="nav-link" href="/user/profile">Profile</a></li>
                                <li class="nav-item"><a class="nav-link" href="/user/logout">Log Out</a></li>
                            </sec:authorize>
                        </ul>
                    </div>
                </nav>
            </div>