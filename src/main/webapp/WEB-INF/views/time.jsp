<%@ page import="com.netcracker.StaticList" %><%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 08.09.2016
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="/resources/css/base.css">
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>TIME</title>
</head>
<body>

<a href="/MenuPage"><img src="/resources/pictures/back.png"></a>
<a style="margin-left: 100px" href="/addingTime"><img src="/resources/pictures/db_add.png"/></a>

<h1>
    <spring:message code="entity.Time"/>
</h1>

<h1><spring:message code="time.list"/></h1>

<form>
    <c:if test="${!empty timeList}">
        <table class="searchTable">
            <tr>
                <th class="searchTh"><spring:message text="name"/></th>
                <th class="searchTh">&nbsp;</th>
            </tr>
            <c:forEach items="${timeList}" var="time">
                <tr>
                    <td class="searchTd">${time.name}</td>
                    <td class="searchTd"><input class="bigbox" type="radio" name="id" value="${time.id}"></td>
                </tr>
            </c:forEach>
        </table>
        <input class="searchSubmit" type="submit" align="right" value="<spring:message code="label.search"/>">
    </c:if>
</form>

<%
    String select[] = request.getParameterValues("id");
    if (select != null && select.length != 0) {
        for (int i = 0; i < select.length; i++) {
            StaticList.staticList.add(Integer.parseInt(select[i]));
        }
        response.sendRedirect("/AddSearch");
    }
%>

<c:if test="${!empty recipes}">
    <table class="searchTable2">
        <h2><spring:message code="recipe.list"/></h2>
        <tr>
            <th class="searchTh2"><spring:message code="label.name"/></th>
            <th class="searchTh2"><spring:message code="entity.category"/></th>
            <th class="searchTh2"><spring:message code="entity.Cuisune"/></th>
            <th class="searchTh2"><spring:message code="entity.CookMethod"/></th>
            <th class="searchTh2"><spring:message code="entity.Time"/></th>
            <th class="searchTh2">&nbsp;</th>
            <th class="searchTh2">&nbsp;</th>
        </tr>
        <c:forEach items="${recipes}" var="i">
            <tr>
                <td class="searchTd2">${i.name}</td>
                <td class="searchTd2">${i.category.name}</td>
                <td class="searchTd2">${i.cuisine.name}</td>
                <td class="searchTd2">${i.method.name}</td>
                <td class="searchTd2">${i.time.name}</td>
                <td class="searchTd2"><a href="/showComment/${i.id}"><spring:message code="label.comment"/></a></td>
                <td class="searchTd2"><a href="/addComment/${i.id}"><spring:message code="label.addComment"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
