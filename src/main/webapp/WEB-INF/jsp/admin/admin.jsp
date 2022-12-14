<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="../include/header.jsp">
        <jsp:param name="title" value="admin" />
    </jsp:include>

    <div class="container">
        <div class="row mt-2 mb-5">
            <form action="/admin/edit_bike" method="post">
                <div class="row">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <select name="id" id="id">
                            <c:forEach items="${bikes}" var="bike" varStatus="loop">
                                <option value="${bike.id}">${bike.id} ${bike.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" value="${form.name}" class="form-control" id="name" name="name">
                    </div>
                </div>
                <div class="row">
                    <div class="mb-3">
                        <label for="primaryColor" class="form-label">primaryColor</label>
                        <input type="text" value="${form.primaryColor}" class="form-control" id="primaryColor" name="primaryColor">
                    </div>
                </div>
                <div class="row">
                    <div class="mb-3">
                        <label for="secondaryColor" class="form-label">secondaryColor</label>
                        <input type="text" value="${form.secondaryColor}" class="form-control" id="secondaryColor" name="secondaryColor">
                    </div>
                </div>
                <div class="row">
                    <div class="mb-3">
                        <label for="seatType" class="form-label">seatType</label>
                        <input type="text" value="${form.seatType}" class="form-control" id="seatType" name="seatType">
                    </div>
                </div>
                <div class="row">
                    <div class="mb-3">
                        <label for="image" class="form-label">image</label>
                        <input type="text" value="${form.image}" class="form-control" id="image" name="image">
                    </div>
                </div>
                <div class="row">
                    <div class="mb-3">
                        <label for="description" class="form-label">description</label>
                        <input type="text" value="${form.description}" class="form-control" id="description" name="description">
                    </div>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="../include/footer.jsp" />