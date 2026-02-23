<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h2>Hospital Management - Registration</h2>
        <form action="register" method="post">
            Username: <input type="text" name="username" required><br><br>
            Email: <input type="email" name="email" required><br><br>
            Password: <input type="password" name="password" required><br><br>
            Phone: <input type="text" name="phone"><br><br>
            Address: <input type="text" name="address"><br><br>
            <button type="submit">Register Now</button>
        </form>
    </body>
</html>