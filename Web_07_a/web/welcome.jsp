<%-- 
    Document   : welcome (hoặc a.jsp tùy tên file của bạn)
    Created on : Jan 8, 2026, 11:29:33 AM
    Author     : LENOVO
--%>

<%@page import="model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <%-- Kiểm tra nếu user đã login --%>
        <c:if test="${not empty sessionScope.user}">
            <h1>Welcome, ${sessionScope.user.fullName}</h1>

            <%-- Link Logout đi qua MainController --%>
            <a href="MainController?action=logout">Logout</a><br/>
            
            <%-- QUAN TRỌNG: Sửa link này để đi qua Controller lấy dữ liệu trước --%>
            <a href="MainController?action=search">Search</a>
        </c:if>
            
        <%-- Nếu chưa login thì đá về trang login --%>
        <c:if test="${empty sessionScope.user}">
            <c:redirect url="login.jsp"/>
        </c:if>
                
    </body>
</html>