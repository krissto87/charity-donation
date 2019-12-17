<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<footer>--%>
<div class="contact">
    <h2><fmt:message key="pages.footer.contact"/></h2>
    <h3><fmt:message key="pages.footer.contact-form"/></h3>
    <form class="form--contact">
        <div class="form-group form-group--50"><input type="text" name="name" placeholder="<fmt:message key="pages.footer.form.name"/>"/></div>
        <div class="form-group form-group--50"><input type="text" name="surname" placeholder="<fmt:message key="pages.footer.form.surname"/>"/></div>

        <div class="form-group"><textarea name="message" placeholder="<fmt:message key="pages.footer.form.message"/>" rows="1"></textarea></div>

        <button class="btn" type="submit"><fmt:message key="pages.footer.form.send"/></button>
    </form>
</div>
<div class="bottom-line">
    <span class="bottom-line--copy"><fmt:message key="pages.footer.form.copyright"/></span>
    <div class="bottom-line--icons">
        <a href="#" class="btn btn--small"><img src="<c:url value="/resources/images/icon-facebook.svg"/>"/></a>
        <a href="#" class="btn btn--small"><img src="<c:url value="/resources/images/icon-instagram.svg"/>"/></a>
    </div>
</div>
<%--</footer>--%>
