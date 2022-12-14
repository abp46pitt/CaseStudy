<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="../include/header.jsp">
        <jsp:param name="title" value="login" />
    </jsp:include>

    <style>
        .container {
            height: 100%;
        }
    </style>

    <div class="container" id="container">
        <div class="d-flex align-items-center justify-content-center my-5">
            <form action="/user/loginpost" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Email address</label>
                    <input type="email" class="form-control" name="username" id="username" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" id="password">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $('#container').height($(window).height());
        });
    </script>

    <jsp:include page="../include/footer.jsp" />