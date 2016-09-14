<%@ page import="com.netcracker.StaticList" %><%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 13.09.2016
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><spring:message code="label.basicSearch"/></title>
</head>
<body>

<h1><spring:message code="ingredient.list"/></h1>

<form>
<c:if test="${!empty ingredientList}">
    <table>
        <tr>
            <th><spring:message text="id"/></th>
            <th><spring:message text="name"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${ingredientList}" var="i">
            <tr>
                <td>${i.id}</td>
                <td>${i.name}</td>
                <td>
                    <input type="checkbox" name="id" value="${i.id}">
                </td>
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
        response.sendRedirect("/search");
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