<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <jsp:include page="../include/header.jsp">
            <jsp:param name="title" value="rent" />
        </jsp:include>

        <div class="container" id="container">
            <div class="row">
                <div class="col-md-8 col-lg-8">
                    <h2 class="text-center">Rent a Bike:</h2>
                    <form>
                        <div class="form-group">
                            <label for="startDate">Start Date</label>
                            <input type="text" class="form-control" id="startDate">
                            <input type="hidden" value="${bike.id}" id="bikeId">
                        </div>
                        <div class="form-group mt-2">
                            <label for="endDate">End Date</label>
                            <input type="text" class="form-control" id="endDate">
                        </div>
                        <button type="button" class="btn custom-button mt-2" id="button">Submit</button>
                    </form>
                    <div style="display:none" id="hidden" class="my-3">
                        <table class="table table-bordered mx-auto">
                            <tr>
                                <th colspan="6" class="text-center">Rental Information</th>
                            </tr>
                            <tr>
                                <th>Name</th>
                                <th>bike</th>
                                <th>Start date</th>
                                <th>End date</th>
                                <th>daily price</th>
                                <th>total price</th>
                            </tr>
                            <tr>
                                <td>${user.firstName} ${user.lastName}</td>
                                <td>${bike.name}</td>
                                <td id="startFill"></td>
                                <td id="endFill"></td>
                                <td>$${bike.price}</td>
                                <td id="totalPrice"></td>
                            </tr>
                        </table>
                        <button type="button" class="btn custom-button" id="submit">Rent this Bike</button>
                    </div>
                    <div>
                        <h4 class="text-center" id="feedback"></h4>
                    </div>
                    <div id="profile" style="display:none" class="text-center py-3">
                        <a href="/user/profile"><button type="button" class="btn custom-button">View your
                                rentals</button></a>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4">
                    <h2 class="text-center">Current Rentals</h2>
                    <c:if test="${empty rentals}">
                        <p class="text-center">No upcoming rentals for this bike yet!</p>
                    </c:if>
                    <c:if test="${!empty rentals}">
                        <table class="table table-bordered mx-auto" id="rentalTable">
                            <tr>
                                <th>Start Day</th>
                                <th>End Day</th>
                            </tr>
                            <c:forEach items="${rentals}" var="rental" varStatus="loop">
                                <tr>
                                    <td>
                                        <fmt:formatDate pattern="MM/dd/yyyy" value="${rental.startTime}" />
                                    </td>
                                    <td>
                                        <fmt:formatDate pattern="MM/dd/yyyy" value="${rental.endTime}" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>

        <script>
            $(document).ready(function () {
                $('#container').height($(window).height());
            });
        </script>

        <script src="../../../pub/JS/script.js"></script>

        <jsp:include page="../include/footer.jsp" />