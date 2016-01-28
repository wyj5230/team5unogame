<%-- 
    Document   : playerLoginSuccess
    Created on : Jan 20, 2016, 8:48:05 PM
    Author     : e0000371
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Player Login Success</title>
    </head>
    <body>  
        <div id="temp"><h1>Hello,Player   
                ${applicationScope.players.playerID},
                ${applicationScope.players.getName()}.
                <br>${applicationScope.messenger}</h1></div>


        <input type="text" id="playerID" hidden="true" value="${applicationScope.players.playerID}">


        <form id="roomform" method="POST" action="http://localhost:8080/unogame/playerCreateGameServlet">
            <table>
                PLZ input room number:<BR>
                <input type="text" size="30" name="roomID" id="rid" value="room1"/><BR>
                PLZ input room size:<BR>
                <input type="text" size="30" name="capacity" id="rc" value="3"/>
                <br><br>
                <button type="submit" name="create" id="createbtn">Create</button>
                Click here to create a new game.<BR>
                <button type="submit" name="join" id="joinbtn"
                        onclick="document.forms.roomform.action = 'http://localhost:8080/unogame/playerJoinRoomServlet'">
                    Join</button>
                Click here to join an existing room.<BR>
            </table>
        </form>
        <BR>

        <BR><BR><BR><BR><BR><BR>
        Room List<BR>

    <td>  ${applicationScope.roomlist} </td>
    <br><br>

</body>
</html>
