<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.user.pick-up-confirm" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>

<section class="login-page">
    <h2>Jeśli chcesz zmienić status paczki i potwierdzasz wizytę kuriera kliknij potwierdzam</h2>

        <div class="form-group">
            <form:form method="post" modelAttribute="status">
                <form:hidden path="delivered" value="true"/>
                <form:hidden path="id"/>
                <div class="form-group form-group--buttons">
                    <button class="btn" type="submit">Potwierdź</button>
                </div>
                <sec:csrfInput/>
            </form:form>
        </div>
        <div class="form-group">
            <form:form method="get" action="/user/donation/all" modelAttribute="status">
                <div class="form-group form-group--buttons">
                    <button class="btn" type="submit">Anuluj</button>
                </div>
                <sec:csrfInput/>
            </form:form>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>