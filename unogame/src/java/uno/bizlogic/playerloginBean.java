/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno.bizlogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uno.entity.players;

/**
 *
 * @author e0000371
 */
@Stateless
public class playerloginBean {
    
    @PersistenceContext private EntityManager em;
    
    public players checkplayer(String playerID){
        players p = em.find(players.class, playerID);
        if (p==null)
            return null;
        return p;
    }
    
    public players addplayer(String playerID, String playerName){
        if (em.find(players.class, playerID) == null) {
            players player = new players(playerID, playerName);
            em.persist(player);
            return player;
        } else
        {
            System.out.println("Can not add player,already exist.");
            return null;
        }
    }
    
    
}
