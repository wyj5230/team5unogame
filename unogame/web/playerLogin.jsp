<%-- 
    Document   : playerLogin
    Created on : Jan 20, 2016, 3:26:55 PM
    Author     : e0000371
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="playerServlet/login">
            <table>
                PLZ input playerID:<BR>
                <input type="text" size="30" name="playerID"/>
                <br><br>
                <button type="submit">Login</button>
            </table>
        </form>
        <br><br><br><br>
        <form method="POST" action="playerServlet/add">
            <table>
                If you want to register as a new player,<BR>
                PLZ input playerID:<BR>
                <input type="text" size="30" name="newplayerID"/>
                <br><br>
                Nickname:<BR>
                <input type="text" size="30" name="name"/>
                <br><br>
                <button type="submit">Register</button>
            </table>
        </form>
       
    </body>
</html>
