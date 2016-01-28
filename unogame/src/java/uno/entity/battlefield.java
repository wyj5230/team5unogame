package uno.entity;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author e0000371
 */
public class battlefield {
    private int whosturn;
    private int playernumber;
    private card top;

    public battlefield(int playernumber){
        whosturn=1;
        this.playernumber=playernumber;
        top=null;
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
    
    
    
}
