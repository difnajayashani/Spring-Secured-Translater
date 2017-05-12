<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translater Page</title>

    <spring:url value="/resources/js/translator.js" var="translateJs"/>
    <script src="${translateJs}"></script>

    <spring:url value="/resources/css/translate.css" var="translateCss"/>
    <link href="${translateCss}" rel="stylesheet">

</head>
<body>
<jsp:include page="header.jsp"/>

<div id="heading">
    <h1>Translator Page </h1>
</div>


<div class="row">

                <center>

                    <form class="form-horizontal" role="form" method="get" action="/translatedText" id="translater"
                              >
                        <div class="form-group ">
                            <c:set var = "original" scope = "session" value = "${original_text}"/>

                            <c:if test="${not empty original}">
                                <textarea name="original_text" class="form-control" id="original-text" rows="10"cols="40">${original}</textarea>

                            </c:if>
                            <c:if test="${empty original}">
                                <textarea name="original_text" class="form-control" id="original-text" rows="10"cols="40"></textarea>

                            </c:if>

                            <textarea class="form-control"  name="translated-text" id="text_trans" rows="10" cols="40">${translated_text}</textarea>

                        </div>
                        <br>

                        <div class="form-group ">

                                <select class="form-control" name="original-lang" id="original" style="margin: 0 -250px;
                                 width: 200px; padding:0px; position:absolute;">
                                    <c:set var = "ol" scope = "session" value = "${original_lang}"/>

                                    <c:forEach items="${language_list}" var="language">
                                        <c:choose>
                                            <c:when test="${ol == language.key}">
                                                <option selected="selected" value="<c:out value="${language.key}" />"><c:out value="${language.value}"/></option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="<c:out value="${language.key}" />"><c:out value="${language.value}"/></option>

                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>



                                <select class="form-control" name="translate-lang" id="translated" style="margin:0 70px;
                                 width: 200px; padding:0px; position:absolute;">
                                    <c:set var = "tl" scope = "session" value = "${translated_lang}"/>
                                    <c:forEach items="${language_list}" var="language">
                                        <c:choose>
                                            <c:when test="${tl == language.key}">
                                                <option selected="selected" value="<c:out value="${language.key}" />"><c:out value="${language.value}"/></option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="<c:out value="${language.key}" />"><c:out value="${language.value}"/></option>
                                            </c:otherwise>
                                        </c:choose>
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


                                <input  type="button" class="btn btn-primary" onclick="resetFunction()" value="Reset" />
                        </div>
                     </form>
                </center>
</div>


</body>
</html>
