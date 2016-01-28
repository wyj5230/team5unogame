<%-- 
    Document   : playerWaitingRoom
    Created on : Jan 22, 2016, 5:45:34 PM
    Author     : e0000371
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="lib/jquery-2.2.0.js"></script>
        <script src="playerWaitingRoom.js"></script>
        <title>JSP Page</title>
    </head>
    <body>

        <div id="temp">
            <h1> Hello,${applicationScope.players.getName()}.
                <br>${applicationScope.messenger}
            </h1>
        </div>
        <h1>Room ID is : ${applicationScope.roomID} </h1>

        <div hidden="true" id="hidroomID">${applicationScope.roomID}</div>
        <div hidden="true" id="hidplayerID">${applicationScope.players.playerID}</div>
        <div id="waitroom">
            <BR><BR>
            <div id="welcome"></div>
            <BR>
            <h3>Current player in queue:     
                <span id="current"></span>
                /${applicationScope.capacity}</h3>
            <BR><BR>
            Current player list:
            <BR>

            <ul id="playerqueue">
            </ul>

            <BR><BR><h2>Socket Status:
                <span id="status">Off Line</span></h2>
        </div>
        <div id="battlefield">            
            <input type="text"id="cardID">
            <input type="button" id="playcardbtn" value="Play it!"><BR>
            <input type="button" id="drawcardbtn" value="Draw a card!"><BR>
            <span id="pic"></span><BR>
            <span id="handcard"></span><BR>  
            <ul id="record">
            </ul>           
        </div>

    </body>
</html>
