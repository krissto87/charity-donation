<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.user.donation-details.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header class="header--form-page">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
    <section class="login-page">
        <h2>Szczegóły daru:</h2>
        <table>
            <tr>
                <td><strong>Instytucja:</strong></td>
                <td><strong>Data utworzenia:</strong></td>
                <td><strong>Data przekazania:</strong></td>
                <td><strong>Kategoria darów:</strong></td>
                <td><strong>Ilość worków:</strong></td>
            </tr>
            <tr>
                <td>${donation.institution.name}<br></td>
                <td></td>
                <td></td>
                <td>
                    <c:forEach items="${donation.categories}" var="singleDonation">
                        ${singleDonation.name}<br>
                    </c:forEach>
                </td>
                <td>${donation.quantity}</td>
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