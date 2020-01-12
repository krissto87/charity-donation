<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.user.pick-up-confirm.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>

<section class="login-page">
    <h2><spring:message code="pages.user.pick-up-confirm.header"/></h2>

        <div class="form-group">
            <form:form method="post" modelAttribute="status">
                <form:hidden path="delivered" value="true"/>
                <form:hidden path="id"/>
                <div class="form-group form-group--buttons">
                    <button class="btn" type="submit">
                        <spring:message code="pages.user.pick-up-confirm.confirm"/>
                    </button>
                </div>
                <sec:csrfInput/>
            </form:form>
        </div>
        <div class="form-group">
            <form:form method="get" action="/user/donation/all" modelAttribute="status">
                <div class="form-group form-group--buttons">
                    <button class="btn" type="submit">
                        <spring:message code="pages.user.pick-up-confirm.cancel"/>
                    </button>
                </div>
                <sec:csrfInput/>
            </form:form>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>
</body>
</html>