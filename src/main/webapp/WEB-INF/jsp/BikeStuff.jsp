<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp">
    <jsp:param name="title" value="bikeStuff"/>
</jsp:include>

<table>
    <tr>
        <th class="course">id</th>
        <th class="course">name</th>
        <th class="course">primaryColor</th>
    </tr>
    <!-- first is from spring boot, second is variable in this page -->
    <c:forEach items="${bikes}" var="bike">
        <tr>
            <td class="bike">${bike.id}</td>
            <td class="bike">${bike.name}</td>
            <td class="bike">${bike.primaryColor}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="include/footer.jsp" />