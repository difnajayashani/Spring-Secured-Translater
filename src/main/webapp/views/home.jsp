
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
  <title>Admin Page</title>

  <spring:url value="/resources/css/translate.css" var="translateCss"/>
  <link href="${translateCss}" rel="stylesheet">

</head>
<body>
<jsp:include page="header.jsp"/>
<div id="heading">

  <h1>Home Page </h1>
  <a href="/translate">Go to Translator</a>

</div>

<div id="">

  <h3 style="text-align: center;">Click the link here to move to translater</h3>


</div>

</body>
</html>
