<%@ page import="java.security.Principal" %>


<body>


<%

  Principal principal = (Principal)request.getUserPrincipal();
  session.setAttribute("casPrincipal", principal);
//  session.setAttribute("username", request.getRemoteUser());
  session.setAttribute("username1", principal.getName());

%>
<div>

    <div><p>authenticated as  <%= session.getAttribute("username1")%></p> </div>

    <%--<%= session.getAttribute("username1")%>--%>

    <div style="text-align: right"><p><a href="https://localhost:8443/login?logout">Logout</a></p> </div>

</div>


</body>

