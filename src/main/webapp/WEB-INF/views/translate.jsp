<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translater Page</title>

    <style>

        #heading{
            text-align: center;
            font-size: 40px;
            color: #243ab1;
        }

    </style>


    <script>
        function myFunction(){
            var e = document.getElementById("original-text").value;
            var e2 = document.getElementById("text_trans").value;

            document.getElementById("original-text").value = e2;

            document.getElementById("text_trans").value = e;

        }
    </script>
</head>
<body>
<jsp:include page="./header.jsp"/>

<div id="heading">
    <h1>Translator Page </h1>
</div>


<div class="row">

                <center>

                    <form class="form-horizontal" role="form" method="post" action="translate" id="translater"
                              >
                        <div class="form-group ">

                                    <textarea name="original-text" class="form-control" id="original-text" rows="10"
                                              cols="40">

                                    </textarea>


                                    <textarea class="form-control"  name="translated-text" id="text_trans" rows="10"
                                              cols="40">
                                    </textarea>

                        </div>
                        <br>

                        <div class="form-group ">

                                <select class="form-control" name="original-lang" id="original" style="margin: 0 -250px;
                                 width: 200px; padding:0px; position:absolute;">



                                    <c:forEach varStatus="i" items="${model.language_list}">

                                                <option>${model.language_list[i]}</option>

                                    </c:forEach>

                                </select>



                                <select class="form-control" name="translate-lang" id="translated" style="margin:0 70px;
                                 width: 200px; padding:0px; position:absolute;">

                                    <c:forEach varStatus="i" items="${language_list}">

                                        <option>${language_list[i.index]}</option>


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
