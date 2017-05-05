<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translater Page</title>

    <spring:url value="/resources/js/translator.js" var="jqueryJs"/>
    <script src="${jqueryJs}"></script>

    <style>

        #heading{
            text-align: center;
            font-size: 40px;
            color: #243ab1;
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="heading">
    <h1>Translator Page </h1>
</div>


<div class="row">

                <center>

                    <form class="form-horizontal" role="form" method="get" action="/translate" id="translater"
                              >
                        <div class="form-group ">
                            <textarea name="original-text" class="form-control" id="original-text" rows="10"cols="40"></textarea>


                            <textarea class="form-control"  name="translated-text" id="text_trans" rows="10" cols="40">${translated_text}</textarea>
                        </div>
                        <br>

                        <div class="form-group ">

                                <select class="form-control" name="original-lang" id="original" style="margin: 0 -250px;
                                 width: 200px; padding:0px; position:absolute;">

                                    <c:forEach items="${language_list}" var="language">

                                        <option value="<c:out value="${language}" />"><c:out value="${language}"/></option>
                                    </c:forEach>

                                </select>



                                <select class="form-control" name="translate-lang" id="translated" style="margin:0 70px;
                                 width: 200px; padding:0px; position:absolute;">

                                    <c:forEach items="${language_list}" var="language">
                                        <option value="<c:out value="${language}" />"><c:out value="${language}"/></option>
                                    </c:forEach>
                                </select>

                        </div>
                        <br>
                        <br>


                        <!-- Form buttons -->

                        <div class="form-group "></div>
                        <div class="form-group "></div>
                        <div class="form-group ">

                                <button type="submit" class="btn btn-primary" id="btnTranslate" >Translate</button>

                                <button type="button" class="btn btn-primary"  onclick="myFunction()">Swap</button>


                                <input class="btn btn-primary"  type="button" onclick="resetFunction()" value="Reset" />
                        </div>
                     </form>
                </center>
</div>


</body>
</html>
