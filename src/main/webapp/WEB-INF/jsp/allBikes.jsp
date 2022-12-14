<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="all bikes" />
    </jsp:include>

    <div class="container px-5">
        <!-- first is from spring boot, second is variable in this page -->
        <c:forEach items="${bikes}" var="bike" varStatus="loop">
            <c:if test="${loop.count % 2 != 0}">
                <div class="row px-5">
            </c:if>
            <c:if test="${loop.count % 2 != 0}">
                <div class="col-md-6 col-lg-6 my-4 ps-5">
                    <div class="card shadow  mx-auto" style="width: 18rem;">
                        <img class="card-img-top" src="../../pub/images/${bike.image}" alt="Card image cap">
                        <div class="card-body text-center">
                            <h5 class="card-title">Rans ${bike.name}</h5>
                            <p class="card-text">${bike.primaryColor}<c:if test="${bike.secondaryColor !='N/A'}">,
                                    ${bike.secondaryColor}</c:if>
                            </p>
                            <a href="/info/bikes/${bike.id}" class="btn custom-button">Check out this bike</a>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${loop.count % 2 == 0}">
                <div class="col-md-6 col-lg-6 my-4 pe-5">
                    <div class="card shadow  mx-auto" style="width: 18rem;">
                        <img class="card-img-top" src="../../pub/images/${bike.image}" alt="Card image cap">
                        <div class="card-body text-center">
                            <h5 class="card-title">Rans ${bike.name}</h5>
                            <p class="card-text">${bike.primaryColor}<c:if test="${bike.secondaryColor !='N/A'}">,
                                    ${bike.secondaryColor}</c:if>
                            </p>
                            <a href="/info/bikes/${bike.id}" class="btn custom-button">Check out this bike</a>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${loop.count % 2 == 0 || loop.count == bikes.size()}">
                </div>
            </c:if>
        </c:forEach>
    </div>

    <jsp:include page="include/footer.jsp" />