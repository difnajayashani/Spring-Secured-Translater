<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login Page</title>

    <spring:url value="/resources/css/login.css" var="loginCss"/>
    <link href="${loginCss}" rel="stylesheet">
</head>
<body onload='document.loginForm.username.focus();'>
<body>

<c:if test="${not empty error}">
  <div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
  <div class="msg">${msg}</div>
</c:if>

<div class="login">
  <h1>Login</h1>
  <form method="post"  action="<c:url value='/login' />" name="loginForm">

    <input type="text" name="username" placeholder="Username" required="required" />
    <input type="password" name="password" placeholder="Password" required="required" />
    <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    <input type="hidden"
           name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
</div>



</body>
</html>
