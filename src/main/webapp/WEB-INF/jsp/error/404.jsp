<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="../include/header.jsp">
        <jsp:param name="title" value="all bikes" />
    </jsp:include>

    <div class="container" id="container">
        <div class="row">
            <h1 class="text-center">404 error page</h1>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $('#container').height($(window).height());
        });
    </script>

    <jsp:include page="../include/footer.jsp" />