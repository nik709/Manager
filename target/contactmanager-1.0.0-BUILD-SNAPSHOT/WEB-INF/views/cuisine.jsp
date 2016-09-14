<%@ page import="com.netcracker.StaticList" %><%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 14.09.2016
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title><spring:message code="entity.Cuisune"/></title>
</head>
<body>
<a href="/MenuPage">Back to menu</a>
<h1>
    <spring:message code="entity.Cuisune"/>
</h1>

<form:form method="post" action="addCuisine" commandName="cuisine">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="id"/>
                </form:label>
            </td>
            <td>
                <form:input path="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message text="ADD"/>"/>
            </td>
        </tr>
    </table>
</form:form>

<form>
    <c:if test="${!empty cuisineList}">
        <table class="data">
            <tr>
                <th><spring:message text="id"/></th>
                <th><spring:message text="name"/></th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${cuisineList}" var="cuisine">
                <tr>
                    <td>${cuisine.id}</td>
                    <td>${cuisine.name}</td>
                    <td><input type="radio" name="id" value="${cuisine.id}"></td>
                </tr>
            </c:forEach>
            <tr>
                <td>
                    <input type="submit" value="<spring:message code="label.search"/>">
                </td>
            </tr>
        </table>
    </c:if>
</form>

<%
    String select[] = request.getParameterValues("id");
    if (select != null && select.length != 0) {
        for (int i = 0; i < select.length; i++) {
            StaticList.staticList.add(Integer.parseInt(select[i]));
        }
        response.sendRedirect("/cuisine");
    }
%>

<c:if test="${!empty recipes}">
    <table>
        <h2><spring:message code="recipe.list"/></h2>
        <tr>
            <th><spring:message text="ID"/></th>
            <th><spring:message code="label.name"/></th>
            <th><spring:message code="entity.category"/></th>
            <th><spring:message code="entity.Cuisune"/></th>
            <th><spring:message code="entity.CookMethod"/></th>
            <th><spring:message code="entity.Time"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${recipes}" var="i">
            <tr>
                <td>${i.id}</td>
                <td>${i.name}</td>
                <td>${i.category.name}</td>
                <td>${i.cuisine.name}</td>
                <td>${i.method.name}</td>
                <td>${i.time.name}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
