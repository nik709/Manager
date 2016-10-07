<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="/resources/css/base.css">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8"/>
    <title><spring:message code="label.title"/></title>
</head>
<body>

<center>
<h1 id="welcome">Welcome to Food DataBase</h1>
</center>

<center>
    <a id="login"  href="/login">
        <spring:message code="label.login"/>
    </a>
    <br>
    <br>
    <a id="logout" href="<c:url value="/logout" />">
        <spring:message code="label.logout"/>
    </a>
</center>

</body>
</html>