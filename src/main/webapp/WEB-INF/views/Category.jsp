<%@ page import="com.netcracker.StaticList" %><%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 18.09.2016
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="/resources/css/base.css">
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category</title>
</head>
<body>

<a href="/MenuPage"><img src="/resources/pictures/back.png"></a>
<a style="margin-left: 100px" href="/addingCategory"><img src="/resources/pictures/db_add.png"/></a>

<h1><spring:message code="entity.category"/></h1>

<form>
    <c:if test="${!empty categoryList}">
        <table class="searchTable">
            <tr>
                <th class="searchTh"><spring:message text="name"/></th>
                <th class="searchTh">&nbsp;</th>
            </tr>
            <c:forEach items="${categoryList}" var="category">
                <tr>
                    <td class="searchTd">${category.name}</td>
                    <td class="searchTd"><input class="bigbox" type="radio" name="id" value="${category.id}"></td>
                </tr>
            </c:forEach>
        </table>
        <input class="searchSubmit" type="submit" value="<spring:message code="label.search"/>">
    </c:if>
</form>

<%
    String select[] = request.getParameterValues("id");
    if (select != null && select.length != 0) {
        for (int i = 0; i < select.length; i++) {
            StaticList.staticList.add(Integer.parseInt(select[i]));
        }
        response.sendRedirect("/category");
    }
%>

<c:if test="${!empty recipes}">
    <table class="searchTable2">
        <h2><spring:message code="recipe.list"/></h2>
        <tr>
            <th class="searchTh"><spring:message code="label.name"/></th>
            <th class="searchTh"><spring:message code="entity.category"/></th>
            <th class="searchTh"><spring:message code="entity.Cuisune"/></th>
            <th class="searchTh"><spring:message code="entity.CookMethod"/></th>
            <th class="searchTh"><spring:message code="entity.Time"/></th>
            <th class="searchTh">&nbsp;</th>
            <th class="searchTh">&nbsp;</th>
        </tr>
        <c:forEach items="${recipes}" var="i">
            <tr>
                <td class="searchTd">${i.name}</td>
                <td class="searchTd">${i.category.name}</td>
                <td class="searchTd">${i.cuisine.name}</td>
                <td class="searchTd">${i.method.name}</td>
                <td class="searchTd">${i.time.name}</td>
                <td class="searchTd"><a href="/showComment/${i.id}"><spring:message code="label.comment"/></a></td>
                <td class="searchTd"><a href="/addComment/${i.id}"><spring:message code="label.addComment"/></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
