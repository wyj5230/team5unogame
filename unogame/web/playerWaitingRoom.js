$(function () {

    $("#battlefield").hide();

    //this js is only used for listening socket
    var hidplayerID = document.getElementById("hidplayerID").textContent;
    var hidroomID = document.getElementById("hidroomID").textContent;
    console.log("hidplayerID=" + hidplayerID);
    console.log("hidroomID=" + hidroomID);
    var handcard = new Array();

    var socket = new WebSocket("ws://localhost:8080/unogame/joinroom/"
            + hidroomID);

    socket.onopen = function () {
        $("#status").text(" Connected");

        var msg = {
            cmd: "join",
            playerID: hidplayerID
        };
        socket.send(JSON.stringify(msg));
    };

    socket.onmessage = function (evt) {

        console.log(evt.data);
        var msgback = JSON.parse(evt.data);
        console.log(msgback);
        var roomID = msgback.roomID;
        if (roomID == hidroomID) {
            var cmd = msgback.cmd;
            console.log(cmd);
            switch (cmd) {
                case "join":
                    console.log("current=" + msgback.current);
                    var $li = $("<li>");
                    $li.text("[" + msgback.playerID + "] " + msgback.name);
                    $("#playerqueue").prepend($li);
                    $("#current").text(msgback.current);
                    $("#welcome").text("Let's welcome new player: " + msgback.name);
                    break;
                case "initial":
                    console.log("playerID=" + msgback.playerID);
                    if (msgback.playerID == hidplayerID)
                    {
                        console.log("cards length =" + msgback.cards.length);
                        $("#waitroom").hide();
                        $("#battlefield").show();
                        for (var i = 0; i < msgback.cards.length; i++) {
                            handcard.push(msgback.cards[i].cid);
                        }
                        $("#handcard").text(handcard);
                        $("#pic").empty();
                        for (var i = 0; i < handcard.length; i++) {
                            document.getElementById("pic").innerHTML += "<img src='images/" + handcard[i] + ".png'/>";
                            console.log(">>>url=" + "<img height:248px; width:138px; src='images/" + handcard[i] + ".png'/>");
                        }
                    }
                    break;
                case "playcard":
                    var $li = $("<li>");
                    $li.text("[" + msgback.name + "] played a card (color="
                            + msgback.card.color + ",number="
                            + msgback.card.number + ",function="
                            + msgback.card.function + ")");
                    $("#record").prepend($li);
                    break;
                case "drawcard":
                    if (msgback.playerID == hidplayerID)
                    {
                        handcard.push(msgback.cardID);
                        $("#handcard").text(handcard);
                        $("#pic").empty();
                        for (var i = 0; i < handcard.length; i++) {
                            document.getElementById("pic").innerHTML += "<img src='images/" + handcard[i] + ".png'/>";
                            console.log(">>>url=" + "<img height:248px; width:138px; src='images/" + handcard[i] + ".png'/>");
                        }
                    }
                    break;
                case "win":
                    
                    handcard=[];
                    handcard.slice(0,handcard.length);
                    handcard.length = 0;
                    alert("Winnier is " + msgback.playerID + "/n Score is " + msgback.score);
                    break;
            }


        }
    };
    $("#playcardbtn").on("click", function () {
        for (var i = 0; i < handcard.length; i++)
        {
            if (handcard[i] == $("#cardID").val())
            {
                handcard.splice(i, 1);
                if (handcard.length == 0)
                {
                    var msg = {
                        cmd: "win",
                        playerID: hidplayerID
                    };
                    socket.send(JSON.stringify(msg));
                    break;
                } else {
                    var msg = {
                        cmd: "playcard",
                        playerID: hidplayerID,
                        cardID: $("#cardID").val()
                    };
                    socket.send(JSON.stringify(msg));
                    break;
                }
            }

        }
        $("#handcard").text(handcard);
        $("#pic").empty();
        for (var i = 0; i < handcard.length; i++) {
            document.getElementById("pic").innerHTML += "<img src='images/" + handcard[i] + ".png'/>";
            console.log(">>>url=" + "<img height:248px; width:138px; src='images/" + handcard[i] + ".png'/>");
        }
    });

    $("#drawcardbtn").on("click", function () {
        var msg = {
            cmd: "drawcard",
            playerID: hidplayerID
        }
        socket.send(JSON.stringify(msg));
    })
});
  