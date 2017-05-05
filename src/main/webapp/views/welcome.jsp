<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Welcome Page</title>
    <!-- CSS -->
    <%--<spring:url value="/resources/css/style.css" var="styleCss"/>
    <link href="${styleCss}" rel="stylesheet">--%>

  <style>
    #login-box {
      width: 300px;
      padding: 20px;
      margin: 100px auto;
      background: #fff;
      -webkit-border-radius: 2px;
      -moz-border-radius: 2px;
      border: 1px solid #000;
    }
    #heading{
      text-align: center;
      font-size: 40px;
      color: #243ab1;
    }
    .button {
      background-color: #4CAF50;
      border: none;
      color: white;
      padding: 15px 32px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      cursor: pointer;
      margin: 0px 60px 0px 70px;
    }
  </style>

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
