package uno.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.persistence.Id;

@Named("players")
@Entity
@SessionScoped
public class players implements Serializable {

    @Id
    private String playerID;
    private String name;

    @Transient
    private int cardnumber;
    @Transient
    private int totalscore;
    @Transient
    private List<card> handcards;
    @Transient
    private int position;

    public players() {
        this.handcards = new LinkedList<card>();
    }

    public players(String playerID, String name) {
        this.playerID = playerID;
        this.name = name;
        cardnumber = 7;
        totalscore = 0;
        this.handcards = new LinkedList<card>();
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayID(String playerID) {
        this.playerID = playerID;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

    public int getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(int cardnumber) {
        this.cardnumber = cardnumber;
    }

    public List<card> getHandcards() {
        return handcards;
    }

    public void setHandcards(List<card> handcards) {
        this.handcards = handcards;
    }

    public void drawcard(drawdeck d, int n) {

        for (int i = 0; i < n; i++) {
            {
                handcards.add(d.randompick());
                cardnumber++;
            }
        }

    }

    public card playcard(gamemanager gm, card c) {
        if (handcards.contains(c)) {
            handcards.remove(c);
            cardnumber--;
            gm.setTop(c);
            System.out.println("Card played successfully");
            return c;
        } else {
            System.out.println("You dont have this card!");
            return null;
        }
    }

    public card getcard(String cid) {
        for (card c : handcards) {
            if (c.getCid().equals(cid)) {
                return c;
            }
        }
        return null;

    }

    public String drawonecard(gamemanager gm) {
        card c = gm.getDeck().randompick();
        handcards.add(c);
        cardnumber++;
        return (c.getCid());
    }

    @Override
    public String toString() {
        return "players{" + "playerID=" + playerID + ", name=" + name + ", cardnumber=" + cardnumber + ", totalscore=" + totalscore + ", handcards=" + handcards + ", position=" + position + '}';
    }

    public players copy() {
        players a = new players();
        a.setCardnumber(this.cardnumber);
        a.setHandcards(this.handcards);
        a.setName(this.name);
        a.setPlayID(this.playerID);
        a.setPosition(this.position);
        a.setTotalscore(this.totalscore);
        return a;
    }

    public int toscore() {
        int score = 0;
        for (card c : handcards) {
            score = score + c.getPoints();
        }
        return score;

    }
}
