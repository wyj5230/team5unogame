/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno.socket;

import com.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import uno.bizlogic.playerloginBean;
import uno.entity.card;
import uno.entity.gamemanager;
import uno.entity.players;

/**
 *
 * @author e0000371
 */
@RequestScoped
@ServerEndpoint("/joinroom/{roomID}")
public class waitingRoomSocket {

    private Session session;
//    int count = 0;

    @EJB
    private playerloginBean plbean;

    @Inject
    private gamemanager gm;

    List<players> playerlist = new LinkedList<>();

    @OnOpen
    public void open(Session s, @PathParam("roomID") String roomID) {

        System.out.println(">>>wyj: socket is open!" + s.getId());
        session = s;
    }

    @OnMessage
    public void message(String msg, @PathParam("roomID") String roomID) throws IOException {
//        if (gm.getRoomID() == null) {
//            gm.setRoomID(roomID);
//        }
//        System.out.println("roomID is " + roomID);
//        System.out.println("gm roomID is" + gm.getRoomID());
//        System.out.println(roomID.equals(gm.getRoomID()));
//        System.out.println(!roomID.equals(gm.getRoomID()));
//        if (count == 0) {
//            if (!roomID.equals(gm.getRoomID())) {
//                System.out.println("I m here");
//                gm = new gamemanager();
//                System.out.println("Empty " + gm.getRoomID());
//                gm.setRoomID(roomID);
//                count++;
//                System.out.println("roomID is " + roomID);
//                System.out.println("gm roomID is" + gm.getRoomID());
//            }
//        }

        System.out.println(">>> msg for wyj: " + msg);
        System.out.println(">>> roomID for wyj: " + roomID);
        JsonReader reader = Json.createReader(
                new ByteArrayInputStream(msg.getBytes()));
        JsonObject json = reader.readObject();

        Gson gson = new Gson();
        String msgback;

        String cmd = json.getString("cmd");
        System.out.println("cmd is : " + cmd);
        switch (cmd) {
            case ("join"):
                String playerID = json.getString("playerID");
                players p = plbean.checkplayer(playerID);
                System.out.println("cmd is : " + p.getName());
//                 {
//                    if (gm.getPlayerlist().isEmpty()) {
//                        gm.getPlayerlist().add(p);
//                    } else {
//                        for (players pl : gm.getPlayerlist()) {
//                            if (pl.getPlayerID().equals(playerID)) {
//                                break;
//                            }
//                            gm.getPlayerlist().add(p);
//                        }
//                    }
//                }
                gm.getPlayerlist().add(p);
                System.out.println(playerlist.size());

                msgback = "{\"cmd\": \"join\",\"playerID\":\"" + p.getPlayerID() + "\",\"name\":\""
                        + p.getName() + "\",\"roomID\":\"" + roomID + "\",\"current\":\"" + gm.getPlayerlist().size() + "\"}";
                broadcast(msgback);
                break;

            case ("start"):

                gm.initialize();

                for (players player : gm.getPlayerlist()) {
                    JsonObjectBuilder objBuilder = Json.createObjectBuilder();
                    objBuilder.add("cmd", "initial")
                            .add("top", gm.getTop().getCid())
                            .add("roomID", roomID)
                            .add("playerID", player.getPlayerID());
                    JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
                    for (card c : player.getHandcards()) {
                        arrBuilder.add(c.toJson());
                    }
                    objBuilder.add("cards", arrBuilder.build());

                    //msgback = "{\"cmd\":\"initial\",\"playerID\":\"" + player.getPlayerID() + "\",\"cards\":\"" + gson.toJson(player.getHandcards()) + "\"}";
                    broadcast(objBuilder.build().toString());
                }

                break;

            case ("tableview"):
                msgback = "{\"cmd\": \"playernumberback\",\"current\":\"" + gm.getPlayerlist().size() + "\",\"roomID\":\"" + roomID + "\"}";
                broadcast(msgback);
                break;

            case ("playcard"):
                playerID = json.getString("playerID");
                String cardID = json.getString("cardID");
                p = gm.getplayer(playerID);
                card c = p.getcard(cardID);
                p.playcard(gm, c);
                String topcard = gson.toJson(c);
                msgback = "{\"cmd\": \"playcard\",\"name\":\"" + playerID + "\",\"roomID\":\"" + roomID + "\",\"card\":" + topcard + "}";
                broadcast(msgback);
                break;

            case ("drawcard"):
                playerID = json.getString("playerID");
                System.out.println("1playerID is " + playerID);
                String cid = gm.getplayer(playerID).drawonecard(gm);
                System.out.println("2cid is " + cid);
                msgback = "{\"cmd\": \"drawcard\",\"playerID\":\"" + playerID + "\",\"roomID\":\"" + roomID + "\",\"cardID\":\"" + cid + "\"}";
                System.out.println("3msgback is " + msgback);
                broadcast(msgback);
                System.out.println("4Broadcast complete!");
                break;
            case ("win"):
                playerID = json.getString("playerID");
                int pscore = gm.getplayer(playerID).toscore();
                int score = 0;
                for (players sb : gm.getPlayerlist()) {
                    score = score + sb.toscore();
                }
                int totalscore=score-pscore;
                msgback = "{\"cmd\": \"win\",\"playerID\":\"" + playerID + "\",\"score\":\"" + totalscore + "\",\"roomID\":\"" + roomID + "\"}";
                broadcast(msgback);
                break;
        }

    }

    public void broadcast(String msgback) throws IOException {
        for (Session peerSession : session.getOpenSessions()) {
            System.out.println(peerSession.toString());
            peerSession.getBasicRemote()
                    .sendText(msgback);
        }
    }
}
