<%-- 
    Document   : playerRegisterSuccess
    Created on : Jan 25, 2016, 9:18:32 PM
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
         <div id="temp"><h1>Hello,Player   
                ${applicationScope.players.playerID},
                ${applicationScope.players.getName()}.
                <br>${applicationScope.messenger}</h1></div>
                <br>
    <a href="http://localhost:8080/unogame/playerLogin.jsp">Login and play now!</a>
    </body>
</html>
