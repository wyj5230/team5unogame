package uno.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author e0000371
 */
@Named("drawdeck")
@SessionScoped
public class drawdeck implements Serializable {

    int remain;
    List<card> deck;

    public static final String[] cid = {
        "c0_00", "c0_01", "c0_02", "c0_03", "c0_04",
        "c0_05", "c0_06", "c0_07", "c0_08", "c0_09",
        "c0_01", "c0_02", "c0_03", "c0_04", "c0_05",
        "c0_06", "c0_07", "c0_08", "c0_09",
        "c0_10", "c0_11", "c0_12", "c0_10", "c0_11", "c0_12",
        "c1_00", "c1_01", "c1_02", "c1_03", "c1_04",
        "c1_05", "c1_06", "c1_07", "c1_08", "c1_09",
        "c1_01", "c1_02", "c1_03", "c1_04", "c1_05",
        "c1_06", "c1_07", "c1_08", "c1_09",
        "c1_10", "c1_11", "c1_12", "c1_10", "c1_11", "c1_12",
        "c2_00", "c2_01", "c2_02", "c2_03", "c2_04",
        "c2_05", "c2_06", "c2_07", "c2_08", "c2_09",
        "c2_01", "c2_02", "c2_03", "c2_04", "c2_05",
        "c2_06", "c2_07", "c2_08", "c2_09",
        "c2_10", "c2_11", "c2_12", "c2_10", "c2_11", "c2_12",
        "c3_00", "c3_01", "c3_02", "c3_03", "c3_04",
        "c3_05", "c3_06", "c3_07", "c3_08", "c3_09",
        "c3_01", "c3_02", "c3_03", "c3_04", "c3_05",
        "c3_06", "c3_07", "c3_08", "c3_09",
        "c3_10", "c3_11", "c3_12", "c3_10", "c3_11", "c3_12",
        "c4_00", "c4_00", "c4_00", "c4_00",
        "c4_01", "c4_01", "c4_01", "c4_01"
    };

    public static final String[] function = {
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null",
        "skip", "reverse", "draw2", "skip", "reverse", "draw2",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null",
        "skip", "reverse", "draw2", "skip", "reverse", "draw2",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null",
        "skip", "reverse", "draw2", "skip", "reverse", "draw2",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null", "null",
        "null", "null", "null", "null",
        "skip", "reverse", "draw2", "skip", "reverse", "draw2",
        "wild", "wild", "wild", "wild",
        "wildDrawFour", "wildDrawFour", "wildDrawFour", "wildDrawFour",};
    public static final String[] color = {
        "red", "red", "red", "red", "red",
        "red", "red", "red", "red", "red",
        "red", "red", "red", "red", "red",
        "red", "red", "red", "red",
        "red", "red", "red", "red", "red", "red",
        "yellow", "yellow", "yellow", "yellow", "yellow",
        "yellow", "yellow", "yellow", "yellow", "yellow",
        "yellow", "yellow", "yellow", "yellow", "yellow",
        "yellow", "yellow", "yellow", "yellow",
        "yellow", "yellow", "yellow", "yellow", "yellow", "yellow",
        "green", "green", "green", "green", "green",
        "green", "green", "green", "green", "green",
        "green", "green", "green", "green", "green",
        "green", "green", "green", "green",
        "green", "green", "green", "green", "green", "green",
        "blue", "blue", "blue", "blue", "blue",
        "blue", "blue", "blue", "blue", "blue",
        "blue", "blue", "blue", "blue", "blue",
        "blue", "blue", "blue", "blue",
        "blue", "blue", "blue", "blue", "blue", "blue",
        "null", "null", "null", "null",
        "null", "null", "null", "null",};
    public static final String[] number = {
        "0", "1", "2", "3", "4",
        "5", "6", "7", "8", "9",
        "1", "2", "3", "4", "5",
        "6", "7", "8", "9",
        "-1", "-1", "-1", "-1", "-1", "-1",
        "0", "1", "2", "3", "4",
        "5", "6", "7", "8", "9",
        "1", "2", "3", "4", "5",
        "6", "7", "8", "9",
        "-1", "-1", "-1", "-1", "-1", "-1",
        "0", "1", "2", "3", "4",
        "5", "6", "7", "8", "9",
        "1", "2", "3", "4", "5",
        "6", "7", "8", "9",
        "-1", "-1", "-1", "-1", "-1", "-1",
        "0", "1", "2", "3", "4",
        "5", "6", "7", "8", "9",
        "1", "2", "3", "4", "5",
        "6", "7", "8", "9",
        "-1", "-1", "-1", "-1", "-1", "-1",
        "-1", "-1", "-1", "-1",
        "-2", "-2", "-2", "-2",};

    public static final int[] points = {
        0, 1, 2, 3, 4,
        5, 6, 7, 8, 9,
        1, 2, 3, 4, 5,
        6, 7, 8, 9,
        20, 20, 20, 20, 20, 20,
        0, 1, 2, 3, 4,
        5, 6, 7, 8, 9,
        1, 2, 3, 4, 5,
        6, 7, 8, 9,
        20, 20, 20, 20, 20, 20,
        0, 1, 2, 3, 4,
        5, 6, 7, 8, 9,
        1, 2, 3, 4, 5,
        6, 7, 8, 9,
        20, 20, 20, 20, 20, 20,
        0, 1, 2, 3, 4,
        5, 6, 7, 8, 9,
        1, 2, 3, 4, 5,
        6, 7, 8, 9,
        20, 20, 20, 20, 20, 20,
        50, 50, 50, 50,
        50, 50, 50, 50,};
    //constructor

    public drawdeck() {
        remain = 108;
        deck = new LinkedList<>();
    }

//getters and setters
    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public List<card> getDeck() {
        return deck;
    }

    public void setDeck(List<card> deck) {
        this.deck = deck;
    }

    public void initialize() {
        for (int i = 0; i < 108; i++) {
            deck.add(new card(cid[i], function[i], color[i], number[i], points[i]));
        }

    }

    public card randompick() {
        if (remain >= 1) {
            int j = (int) (remain * Math.random());
            remain--;
            card luckystrike = deck.get(j);
            deck.remove(j);
            return luckystrike;
        } else {
            this.initialize();
            int j = (int) (remain * Math.random());
            remain--;
            card luckystrike = deck.get(j);
            deck.remove(j);
            return luckystrike;
        }
    }
    
    

}
