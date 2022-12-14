<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="../include/header.jsp">
        <jsp:param name="title" value="createUser" />
    </jsp:include>

    <div class="container" id="container">
        <div class="py-5">
            <form action="/user/createuser" method="post">
                <input type="hidden" name="id" value="${form.id}">
                <div class="mb-3">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" value="${form.firstName}" class="form-control" id="firstName" name="firstName"
                        aria-describedby="firstNameHelp">
                </div>
                <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                    <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                        <p class="text-danger">${error.getDefaultMessage()}</p>
                    </c:forEach>
                </c:if>

                <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" value="${form.lastName}" class="form-control" id="lastName" name="lastName"
                        aria-describedby="lastNameHelp">
                </div>
                <c:if test="${bindingResult.hasFieldErrors('lastName')}">
                    <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                        <p class="text-danger">${error.getDefaultMessage()}</p>
                    </c:forEach>
                </c:if>

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" value="${form.email}" class="form-control" id="email" name="email"
                        aria-describedby="emailHelp">
                </div>
                <c:if test="${bindingResult.hasFieldErrors('email')}">
                    <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                        <p class="text-danger">${error.getDefaultMessage()}</p>
                    </c:forEach>
                </c:if>

                <div class="mb-3">
                    <label for="phone" class="form-label">Phone</label>
                    <input type="tel" value="${form.phone}" class="form-control" id="phone" name="phone"
                        aria-describedby="phoneHelp">
                </div>
                <c:if test="${bindingResult.hasFieldErrors('phone')}">
                    <c:forEach items="${bindingResult.getFieldErrors('phone')}" var="error">
                        <p class="text-danger">${error.getDefaultMessage()}</p>
                    </c:forEach>
                </c:if>

                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" value="${form.password}" class="form-control" id="password" name="password"
                        aria-describedby="passwordHelp">
                </div>
                <c:if test="${bindingResult.hasFieldErrors('password')}">
                    <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                        <p class="text-danger">${error.getDefaultMessage()}</p>
                    </c:forEach>
                </c:if>

                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" value="${form.confirmPassword}" class="form-control" id="confirmPassword"
                        name="confirmPassword" aria-describedby="confirmPasswordHelp">
                </div>
                <c:if test="${bindingResult.hasFieldErrors('confirmPassword')}">
                    <c:forEach items="${bindingResult.getFieldErrors('confirmPassword')}" var="error">
                        <p class="text-danger">${error.getDefaultMessage()}</p>
                    </c:forEach>
                </c:if>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check to receive updates</label>
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