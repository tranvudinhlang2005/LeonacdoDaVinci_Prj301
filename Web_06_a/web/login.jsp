<%-- 
    Document   : login
    Created on : Jan 26, 2026, 2:22:32 AM
    Author     : Yuikiri
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
            <input type="hidden" name="action" value="login"/>
            Username: <input type="text" name="txtUsername" required="required" /> <br/>
            Password: <input type="password" name="txtPassword" required="required"  /> <br/>
            <input type="submit" value="Login" />
        </form>
        <%
            String message = request.getAttribute("message")+"";
            message = (message.equals("null"))?"":message;
        %>
        <span style="color:red"> <%=message%></span>
    </body>
</html>
