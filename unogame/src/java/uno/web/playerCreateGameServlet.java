/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uno.entity.players;

/**
 *
 * @author e0000371
 */
@WebServlet("/playerCreateGameServlet")
public class playerCreateGameServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String roomID= req.getParameter("roomID");
        System.out.println("RoomID is "+roomID);
        
        int capacity=Integer.parseInt(req.getParameter("capacity"));
        
        int current=1;
        ServletContext application =super.getServletContext();
       
        List<players> playerlist=new LinkedList<>();
       
        playerlist.add((players)application.getAttribute("players"));
  
        application.setAttribute("playerlist", playerlist);
        application.setAttribute("roomID", roomID);
        application.setAttribute("capacity", capacity);
        application.setAttribute("current", current);
       
        
        application.setAttribute("roomlist", roomID);       
       
        req.getRequestDispatcher("/playerWaitingRoom.jsp")
                            .forward(req, resp);
     
       
    }

}
