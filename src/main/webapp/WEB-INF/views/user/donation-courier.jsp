<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <h2>Szczegóły zamówienia kuriera:</h2>
        <table>
            <tr>
                <td><strong>Ulica:</strong></td>
                <td><strong>Miasto:</strong></td>
                <td><strong>Kod pocztowy:</strong></td>
                <td><strong>Data przyjazdu:</strong></td>
                <td><strong>Godzina przyjazdu:</strong></td>
                <td><strong>Wiadomość dla kuriera:</strong></td>
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