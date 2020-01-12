<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
        <h2><spring:message code="pages.user.donation-details.header"/></h2>
        <table>
            <tr>
                <td><strong><spring:message code="pages.user.donation-details.institution"/></strong></td>
                <td><strong><spring:message code="pages.user.donation-details.create"/></strong></td>
                <td><strong><spring:message code="pages.user.donation-details.date"/></strong></td>
                <td><strong><spring:message code="pages.user.donation-details.category"/></strong></td>
                <td><strong><spring:message code="pages.user.donation-details.bags"/></strong></td>
            </tr>
            <tr>
                <td>${donation.institution.name}<br></td>
                <td>
                    <fmt:parseDate value="${donation.createTime}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                    <fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${parsedDateTime}" />
                </td>
                <td>
                    <fmt:parseDate value="${donation.deliverTime}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                    <fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${parsedDateTime}" />
                </td>
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