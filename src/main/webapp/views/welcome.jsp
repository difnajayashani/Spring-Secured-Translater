<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Welcome Page</title>
    <!-- CSS -->
  <spring:url value="/resources/css/translate.css" var="translateCss"/>
  <link href="${translateCss}" rel="stylesheet">

</head>
<body>
<div id="heading">
    <h1>Welcome Page </h1>
</div>

<div id="login-box">

  <h3 style="text-align: center;">Click the button here to go to Login</h3>

    <a href="/login" class="button">Login Page</a>

</div>

</body>
</html>
