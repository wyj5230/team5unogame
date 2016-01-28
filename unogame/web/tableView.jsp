<%-- 
    Document   : tableview
    Created on : Jan 22, 2016, 5:37:17 PM
    Author     : e0000371
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="lib/jquery-2.2.0.js"></script>
        <script src="tableView.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Room ID is : ${applicationScope.roomID} </h1>
        <div hidden="true" id="hidroomID">${applicationScope.roomID}</div>
        <div hidden="true" id="hidplayerID">${applicationScope.players.playerID}</div>
        <BR><BR>
        <div id="waitroom">
            <div id="welcome"></div>
            <BR>
            <h3>Current player in queue:     
                <span id="current">1</span>
                /<span id="capacity">${applicationScope.capacity}</span></h3>

            <button id="startbtn" disabled="true" >Start the game!</button><BR><BR>
            <h2>Socket Status:
            <span id="status">Off Line</span></h2>
        </div>
        <div id="battlefield" hidden="true">
            <div id="top">
            </div><BR>
            <span id="toppic"></span>
            <ul id="record">
            </ul>
        </div>
        
            
    </body>
</html>
