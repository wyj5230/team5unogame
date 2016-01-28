/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno.web;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uno.bizlogic.playerloginBean;
import uno.entity.drawdeck;
import uno.entity.players;

/**
 *
 * @author e0000371
 */
@WebServlet("/playerServlet/*")
public class playerServlet extends HttpServlet {

    @Inject
    private players players;
    @EJB
    private playerloginBean plbean;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        //switch case by path
        String path = req.getPathInfo();
        System.out.println(">>>" + path);
        
//        //test deck initialize
//        drawdeck c = new drawdeck();
//        c.initialize();
//        
//        //test deck is ready
//        System.out.println(c.getDeck().get(0).getColor());
        
        
        ServletContext application =super.getServletContext();
        
        switch (path) {
            case "/login":
                String playerID = req.getParameter("playerID");
                System.out.println(playerID);
                if (plbean.checkplayer(playerID) != null) {
                    players = plbean.checkplayer(playerID);
                    System.out.println(players.copy().getName());
                    
                    application.setAttribute("players",players);
                    
                    application.setAttribute("messenger", "Online.");

                    req.getRequestDispatcher("/playerLoginSuccess.jsp")
                            .forward(req, resp);
                } else {
                    System.out.println("Player not found!");
                    req.setAttribute("flag","Player Not Found!");
                    req.getRequestDispatcher("/errorpage.jsp")
                            .forward(req, resp);
                }

                break;
            case "/add":
                String newplayerID = req.getParameter("newplayerID");
                String name = req.getParameter("name");
                players=plbean.addplayer(newplayerID, name);
                if (players != null) {
                    
                    
                    application.setAttribute("players",players);
                    
                    req.getRequestDispatcher("/playerRegisterSuccess.jsp")
                            .forward(req, resp);
                } else {  
                    req.setAttribute("flag", "Player already exist!");
                    req.getRequestDispatcher("/errorpage.jsp")
                            .forward(req, resp);
                }
                break;

        }
    }

}
