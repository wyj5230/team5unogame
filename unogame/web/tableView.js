$(function () {
    //this js is only used for listening socket
    $("#battlefield").hide();
    var hidplayerID = document.getElementById("hidplayerID").textContent;
    var hidroomID = document.getElementById("hidroomID").textContent;
    console.log("hidplayerID=" + hidplayerID);
    console.log("hidroomID=" + hidroomID);

    var socket = new WebSocket("ws://localhost:8080/unogame/joinroom/"
            + hidroomID);

    socket.onopen = function () {
        $("#status").text(" Connected");
        var msg = {
            cmd: "tableview"
        };
        socket.send(JSON.stringify(msg));
    };

    socket.onmessage = function (evt) {

        console.log(evt.data);
        var msgback = JSON.parse(evt.data);
        var roomID = msgback.roomID;
        if (roomID == hidroomID) {
            var cmd = msgback.cmd;
            console.log(cmd);
            switch (cmd) {
                case("playernumberback"):
                    var current = msgback.current;
                    if (current == $("#capacity").text())
                        document.getElementById("startbtn").disabled = false;
                    $("#current").text(current);
                    break;
                case("join"):
                    var current = msgback.current;
                    console.log(current);
                    $("#welcome").text("Let's welcome new player: " + msgback.name);
                    if (current == $("#capacity").text())
                        document.getElementById("startbtn").disabled = false;
                    $("#current").text(current);
                    break;
                case("initial"):
                    $("#waitroom").hide();
                    $("#top").text(msgback.top);
                    document.getElementById("toppic").innerHTML = "<img src='images/" + msgback.top + ".png'/>";
                    $("#battlefield").show();
                    break;
                case("playcard"):
                    console.log(msgback.card);
                    console.log(msgback.card.cid);
                    $("#top").text(msgback.card.cid);
                    document.getElementById("toppic").innerHTML = "<img src='images/" + msgback.card.cid + ".png'/>";
                    break;
                case "win":
                    alert("Winnier is " + msgback.playerID + "and Score is " + msgback.score);
                    var msg = {
                        cmd: "start"
                    };
                    socket.send(JSON.stringify(msg));
                    break;
            }

        }
    };

    $("#startbtn").on("click", function () {
        var msg = {
            cmd: "start"
        };
        socket.send(JSON.stringify(msg));
    })

})