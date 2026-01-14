<%-- 
    Document   : login
    Created on : Jan 8, 2026, 8:01:40 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="post">
            Username: <input type="txt", name="txtUsername"/></br>
            Password: <input type="password", name="txtPassword"/></br>
         <input type="submit" value="login"/>
        </form>
       <%
            String message = request.getAttribute("message")+"";
            message = (message.equals("null"))?"":message;
        %>
        <span style="color:red"> <%=message%></span>
    </body>
</html>
