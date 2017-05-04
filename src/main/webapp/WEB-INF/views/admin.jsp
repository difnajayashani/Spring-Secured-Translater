
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <title>Admin Page</title>


  <style>

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
<jsp:include page="header.jsp"/>
<div id="heading">

       <h1>Admin Page </h1>
      <a class="button" href="https://localhost:8443/translate">Translator</a>

</div>

<div id="">

  <h3 style="text-align: center;">Click the link here to move to translater</h3>


</div>

</body>
</html>
