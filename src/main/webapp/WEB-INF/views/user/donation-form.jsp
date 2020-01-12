<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <spring:message code="pages.donation-form.title" var="title"/>
    <jsp:include page="/WEB-INF/views/fragments/head.jsp">
        <jsp:param name="title" value="${title}"/>
    </jsp:include>
</head>
<body>
<header class="header--form-page">
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                <spring:message code="pages.form.header.slogan"/><br />
                <span class="uppercase"><spring:message code="pages.form.header.slogan.sub"/></span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title"><spring:message code="pages.form.header.slogan.steps"/></div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div>
                            <em>1</em><span><spring:message code="pages.form.header.slogan.step1"/></span>
                        </div>
                    </li>
                    <li>
                        <div>
                            <em>2</em><span><spring:message code="pages.form.header.slogan.step2"/></span>
                        </div>
                    </li>
                    <li>
                        <div>
                            <em>3</em><span><spring:message code="pages.form.header.slogan.step3"/></span>
                        </div>
                    </li>
                    <li>
                        <div>
                            <em>4</em><span><spring:message code="pages.form.header.slogan.step4"/></span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3><spring:message code="pages.form.instructions.head"/></h3>
            <p data-step="1" class="active"><spring:message code="pages.form.instructions.step1"/></p>
            <p data-step="2"><spring:message code="pages.form.instructions.step2"/></p>
            <p data-step="3"><spring:message code="pages.form.instructions.step3"/></p>
            <p data-step="4"><spring:message code="pages.form.instructions.step4"/></p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter"><spring:message code="pages.form.steps.counter"/><span>1</span>/4</div>

        <form:form modelAttribute="donation" method="post">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3><spring:message code="pages.form.step1.head"/></h3>

<%--                <c:forEach items="${categories}" var="category">--%>
<%--                    <div class="form-group form-group--checkbox">--%>
<%--                        <label>--%>
<%--                            <input name="categoriesId" type="checkbox" value="${category.id}">--%>
<%--                            <span class="checkbox"></span>--%>
<%--                            <span  class="description">${category.name}</span>--%>
<%--                        </label>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>

                <c:forEach items="${categories}" var="category">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <span class="checkbox"></span>
                            <form:checkbox path="categoriesId" checked="checked"
                                           cssClass="checkbox" value="${category.id}" />
                            <form:errors path="categoriesId" element="p"/>
                            <span class="description">${category.name}</span>
                        </label>
                    </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step"><spring:message code="pages.form.button.next"/></button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3><spring:message code="pages.form.step2.head"/></h3>

                <div class="form-group form-group--inline">
                    <label>
                        <spring:message code="pages.form.step2.label"/>
                        <form:input id="bags" path="quantity" required="true" type="number" step="1" min="1"/>
                        <form:errors path="quantity" element="p"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="pages.form.button.previous"/></button>
                    <button type="button" class="btn next-step"><spring:message code="pages.form.button.next"/></button>
                </div>
            </div>

            <!-- STEP 3 -->
            <div data-step="3">
                <h3><spring:message code="pages.form.step3.head"/> </h3>

                <c:forEach items="${institutions}" var="institution">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:radiobutton path="institutionId" cssClass="radio" value="${institution.id}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                                <div class="title">${institution.name}</div>
                                <div class="subtitle">${institution.description}</div>
                            </span>
                            <form:errors path="institutionId" element="p"/>
                        </label>
                    </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="pages.form.button.previous"/></button>
                    <button type="button" class="btn next-step"><spring:message code="pages.form.button.next"/></button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3><spring:message code="pages.form.step4.head"/> </h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4><spring:message code="pages.form.step4.address"/></h4>

                        <div class="form-group form-group--inline">
                            <form:label path="street">
                                <spring:message code="pages.form.step4.street"/>
                                <form:input id="street" type="text" path="street" required="true"/>
                                <form:errors path="street" element="p"/>
                            </form:label>
                        </div>

                        <div class="form-group form-group--inline">
                            <form:label path="city">
                                <spring:message code="pages.form.step4.city"/>
                                <form:input id="city" type="text" path="city" required="true"/>
                                <form:errors path="city" element="p"/>
                            </form:label>
                        </div>

                        <div class="form-group form-group--inline">
                            <form:label path="zipCode">
                                <spring:message code="pages.form.step4.zip"/>
                                <form:input id="zip-code" type="text" path="zipCode" required="true"/>
                                <form:errors path="zipCode" element="p"/>
                            </form:label>
                        </div>

                        <div class="form-group form-group--inline">
                            <form:label path="phoneNumber">
                                <spring:message code="pages.form.step4.phone"/>
                                <form:input id="phone" type="phone" path="phoneNumber" required="true"/>
                                <form:errors path="phoneNumber" element="p"/>
                            </form:label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4><spring:message code="pages.form.step4.date"/></h4>
                        <div class="form-group form-group--inline">
                            <form:label path="pickUpDate">
                                <spring:message code="pages.form.step4.day"/>
                                <form:input id="data" type="date" path="pickUpDate" required="true"/>
                                <form:errors path="pickUpDate" element="p"/>
                            </form:label>
                        </div>

                        <div class="form-group form-group--inline">
                            <form:label path="pickUpTime">
                                <spring:message code="pages.form.step4.hour"/>
                                <form:input id="time" type="time" path="pickUpTime" required="true"/>
                                <form:errors path="pickUpTime" element="p"/>
                            </form:label>
                        </div>

                        <div class="form-group form-group--inline">
                            <form:label path="pickUpComment">
                                <spring:message code="pages.form.step4.comment"/>
                                <form:textarea id="comment" path="pickUpComment"/>
                                <form:errors path="pickUpComment" element="p"/>
                            </form:label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="pages.form.button.previous"/></button>
                    <button id="summary" type="button" class="btn next-step"><spring:message code="pages.form.button.next"/></button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="5">
                <h3><spring:message code="pages.form.step5.head"/> </h3>

                <div class="summary">
                    <div class="form-section">
                        <h4><spring:message code="pages.form.step5.sum1"/></h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text" >
                                    <strong id="quantity-sum"></strong>
                                    <spring:message code="pages.form.summary.first"/>
                                    <strong id="categories-sum"></strong>
                                </span>
                            </li>
                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text">
                                    <spring:message code="pages.form.summary.second"/>
                                    <strong id="institution-sum"></strong>
                                </span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4><spring:message code="pages.form.step5.sum2"/></h4>
                            <ul>
                                <li id="street-sum"> </li>
                                <li id="city-sum"> </li>
                                <li id="zip-code-sum"> </li>
                                <li id="phone-sum"> </li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4><spring:message code="pages.form.step5.sum3"/></h4>
                            <ul>
                                <li id="data-sum"> </li>
                                <li id="time-sum"> </li>
                                <li id="comment-sum"> </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="pages.form.button.previous"/></button>
                    <button type="submit" class="btn"><spring:message code="pages.form.confirm"/></button>
                </div>
            </div>
            <sec:csrfInput/>
        </form:form>
    </div>
</section>

<footer>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</footer>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>