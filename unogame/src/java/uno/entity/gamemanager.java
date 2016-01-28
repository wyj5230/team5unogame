/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno.entity;

import java.io.Serializable;
import static java.lang.System.in;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author E0000371
 */
@Named("gamemanager")
@ApplicationScoped
public class gamemanager implements Serializable {

    private List<players> playerlist;
    private List<String> playernamelist;
    private drawdeck deck;
    private int whosturn;
    private int playernumber;
    private card top;
    private String roomID;

    public gamemanager() {
        this.playerlist = new LinkedList<>();
        this.playernamelist = new LinkedList<>();
        deck = new drawdeck();
        whosturn = 1;
    }

    public void initialize() {
        deck.initialize();
        top = deck.randompick();
        for (players p : playerlist) {
            playernamelist.add(p.getPlayerID());
        }
        for (players p : playerlist) {
            p.drawcard(deck, 7);
        }
        playernumber = playerlist.size();
    }

    public players getplayer(String playerID) {
        for (players p : playerlist) {
            if (p.getPlayerID().equals(playerID)) {
                return p;
            }
        }
        return null;
    }

    public void drawcard(String playerID, int num) {
        this.getplayer(playerID).drawcard(deck, num);
    }

    public card playcard(String playerID, String cid) {
        players p = this.getplayer(playerID);
        List<card> cardlist = p.getHandcards();
        for (card c : cardlist) {
            if (c.getCid().equals(cid)) {
                return p.playcard(this, c);
            } else {
                return null;
            }
        }
        return null;
    }

    public List<players> getPlayerlist() {
        return playerlist;
    }

    public void setPlayerlist(List<players> playerlist) {
        this.playerlist = playerlist;
    }

    public drawdeck getDeck() {
        return deck;
    }

    public void setDeck(drawdeck deck) {
        this.deck = deck;
    }

    public int getWhosturn() {
        return whosturn;
    }

    public void setWhosturn(int whosturn) {
        this.whosturn = whosturn;
    }

    public int getPlayernumber() {
        return playernumber;
    }

    public void setPlayernumber(int playernumber) {
        this.playernumber = playernumber;
    }

    public card getTop() {
        return top;
    }

    public void setTop(card top) {
        this.top = top;
    }

    public List<String> getPlayernamelist() {
        return playernamelist;
    }

    public void setPlayernamelist(List<String> playernamelist) {
        this.playernamelist = playernamelist;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

}
