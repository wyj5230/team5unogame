/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno.web.rest;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author e0000371
 */
@RequestScoped
@Path("/player123")
public class playerCreateGameResource {
    
    
           
    
    @POST
    public void createRoom(@FormParam("roomID") String roomID){
        System.out.println("RoomID is "+roomID);
        
    }
}
