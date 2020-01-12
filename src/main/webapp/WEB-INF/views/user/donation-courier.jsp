<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.user.donation.courier-details.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header class="header--form-page">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <section class="login-page">
        <h2><spring:message code="pages.user.donation.courier-details.header"/></h2>
        <table>
            <tr>
                <td><strong><spring:message code="pages.user.donation.courier-details.street"/></strong></td>
                <td><strong><spring:message code="pages.user.donation.courier-details.city"/></strong></td>
                <td><strong><spring:message code="pages.user.donation.courier-details.zip-code"/></strong></td>
                <td><strong><spring:message code="pages.user.donation.courier-details.arrival"/></strong></td>
                <td><strong><spring:message code="pages.user.donation.courier-details.arrival-hour"/></strong></td>
                <td><strong><spring:message code="pages.user.donation.courier-details.message"/></strong></td>
            </tr>
            <tr>
                <td>${donation.street}<br></td>
                <td>${donation.city}</td>
                <td>${donation.zipCode}</td>
                <td>${donation.pickUpDate}</td>
                <td>${donation.pickUpTime}</td>
                <td>${donation.pickUpComment}</td>
            </tr>
        </table>
    </section>

</header>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>