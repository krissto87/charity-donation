<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<footer>--%>
<div class="contact">
    <h2><spring:message code="pages.footer.contact"/></h2>
    <h3><spring:message code="pages.footer.contact-form"/></h3>
    <form class="form--contact">
        <div class="form-group form-group--50"><input type="text" name="name" placeholder="<spring:message code="pages.footer.form.name"/>"/></div>
        <div class="form-group form-group--50"><input type="text" name="surname" placeholder="<spring:message code="pages.footer.form.surname"/>"/></div>

        <div class="form-group"><textarea name="message" placeholder="<spring:message code="pages.footer.form.message"/>" rows="1"></textarea></div>

        <button class="btn" type="submit"><spring:message code="pages.footer.form.send"/></button>
    </form>
</div>
<div class="bottom-line">
    <span class="bottom-line--copy"><spring:message code="pages.footer.form.copyright"/></span>
    <div class="bottom-line--icons">
        <a href="#" class="btn btn--small"><img src="<c:url value="/resources/images/icon-facebook.svg"/>"/></a>
        <a href="#" class="btn btn--small"><img src="<c:url value="/resources/images/icon-instagram.svg"/>"/></a>
    </div>
</div>
<%--</footer>--%>
