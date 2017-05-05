<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>

  <spring:url value="/resources/css/style.css" var="bootstrapCss"/>
  <link href="${bootstrapCss}" rel="stylesheet">
</head>
<body>

<div class="login">
  <h1>Login</h1>
  <form method="post" action="/login">
    <input type="text" name="u" placeholder="Username" required="required" />
    <input type="password" name="p" placeholder="Password" required="required" />
    <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
  </form>
</div>

</body>
</html>
