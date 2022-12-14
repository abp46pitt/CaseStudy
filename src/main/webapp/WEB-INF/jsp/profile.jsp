<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <jsp:include page="include/header.jsp">
                <jsp:param name="title" value="profile" />
            </jsp:include>

            <style>
                tbody tr:nth-child(odd) {
                    background-color: rgb(248, 248, 248);
                }
            </style>

            <div class="container">
                <div class="row">
                    <table class="table table-bordered mx-auto my-3">
                        <tr>
                            <th colspan="4" class="text-center">Your Information</th>
                        </tr>
                        <tr>
                            <th class="text-center">First Name</th>
                            <th class="text-center">Last Name</th>
                            <th class="text-center">Email</th>
                            <th class="text-center">Phone</th>
                        </tr>
                        <tr>
                            <td class="text-center">${user.firstName}</td>
                            <td class="text-center">${user.lastName}</td>
                            <td class="text-center">${user.email}</td>
                            <td class="text-center">${user.phone}</td>
                        </tr>
                    </table>
                </div>
                <div class="row">
                    <table class="table table-bordered mx-auto my-3">
                        <tr>
                            <th colspan="4" class="text-center">Your Rentals</th>
                        </tr>
                        <tr>
                            <th class="text-center">Bike Id</th>
                            <th class="text-center">Bike Name</th>
                            <th class="text-center">Start Date</th>
                            <th class="text-center">End Date</th>
                        </tr>
                        <c:forEach items="${rentals}" var="rental" varStatus="loop">
                            <tr>
                                <td class="text-center">${rental.bike.id}</td>
                                <td class="text-center">${rental.bike.name}</td>
                                <td class="text-center">
                                    <fmt:formatDate pattern="MM/dd/yyyy" value="${rental.startTime}" />
                                </td>
                                <td class="text-center">
                                    <fmt:formatDate pattern="MM/dd/yyyy" value="${rental.endTime}" />
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="row">
                    <table class="table table-bordered mx-auto my-3">
                        <tr>
                            <th colspan="2" class="text-center">Your Reviews</th>
                        </tr>
                        <tr>
                            <th class="text-center">Bike Name</th>
                            <th class="text-left">Review</th>
                        </tr>
                        <c:forEach items="${reviews}" var="review" varStatus="loop">
                            <tr>
                                <td class="text-center">${review.bike.name}</td>
                                <td>${review.comment}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

            <jsp:include page="include/footer.jsp" />