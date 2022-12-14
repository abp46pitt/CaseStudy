<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="bike info" />
    </jsp:include>

    <div class="container py-3">
        <div class="row mb-5">
            <div class="col-lg-6 col-md-6">
                <div class="row text-center">
                    <h1>Rans ${bike.name}</h1>
                    <img class="mx-auto d-block w-75" src="../../pub/images/${bike.image}" alt="${bike.name}">
                </div>
                <div class="my-5">
                    <table class="table table-bordered mx-auto">
                        <tr>
                            <th class="text-center px-2">Capacity</th>
                            <th class="text-center px-2">Primary Color</th>
                            <th class="text-center px-2">Secondary Color</th>
                            <th class="text-center px-2">Seat Type</th>
                            <th class="text-center px-2">Price</th>
                        </tr>
                        <tr>
                            <td class="text-center px-2">${bike.capacity}</td>
                            <td class="text-center px-2">${bike.primaryColor}</td>
                            <td class="text-center px-2">${bike.secondaryColor}</td>
                            <td class="text-center px-2">${bike.seatType}</td>
                            <td class="text-center px-2">$${bike.price}/Day</td>
                        </tr>
                    </table>
                </div>
                <div class="my-3">
                    <h3 class="text-center">Description</h3>
                    <p>${bike.description}</p>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 pe-5">
                <h2 class="text-center mb-5">Reviews</h2>
                <c:if test="${empty reviews}">
                    <h3 class="text-center">No reviews for this bike yet!</h3>
                </c:if>
                <c:forEach items="${reviews}" var="review" varStatus="loop">
                    <c:if test="${loop.count < 15}">
                        <div class="row my-3">
                            <div class="col-lg-3 col-md-3">
                                <p>${review.user.firstName} ${review.user.lastName}</p>
                            </div>
                            <div class="col-lg-9 col-md-9">
                                <p class="speech-bubble px-3">${review.comment}</p>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-md-12">
                <a href="/rental/rent_bike/${bike.id}"><button type="button" class="btn custom-button w-50">Rent this Bike!</button></a>
            </div>
        </div>
    </div>

    <jsp:include page="include/footer.jsp" />