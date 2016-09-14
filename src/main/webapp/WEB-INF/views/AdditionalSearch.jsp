<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 14.09.2016
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title><spring:message code="label.additionalSearch"/></title>
</head>
<body>
<a href="/time">By the time</a>
<br>
<a href="/CookingMethod">By the cooking method</a>
<br>
<a href="/cuisine">By the cuisine</a>
<br>
</body>
</html>
