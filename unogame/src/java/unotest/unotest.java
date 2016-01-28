/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unotest;

import uno.entity.battlefield;
import uno.entity.drawdeck;
import uno.entity.players;

/**
 *
 * @author e0000371
 */
public class unotest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //initialize a game
        drawdeck dd=new drawdeck();
        dd.initialize();
        battlefield bf=new battlefield(3);
        players a=new players("abc1","wang");
        players b=new players("abc2","liu");
        players c=new players("abc3","zhao");
        a.drawcard(dd,7);
        b.drawcard(dd,7);
        c.drawcard(dd,7);
        bf.setTop(dd.randompick());
        
        
        System.out.println("a first:"+a.getHandcards().get(0).getCid());
        System.out.println("c last:"+c.getHandcards().get(6).getCid());
        System.out.println("topcard:"+bf.getTop().getCid());
        System.out.println("whosturn:"+bf.getWhosturn());
        System.out.println("remain:"+dd.getRemain());
        
        

        System.out.println(bf.getTop());
        
    }
    
}
