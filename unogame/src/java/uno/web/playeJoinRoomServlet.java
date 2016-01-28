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

@WebServlet("/playerJoinRoomServlet")
public class playeJoinRoomServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletContext application = super.getServletContext();

        String roomID = req.getParameter("roomID");
        System.out.println("RoomID is " + roomID);

        String approomID = (String) application.getAttribute("roomID");
        System.out.println("APProomID is " + approomID);
        if (roomID.equals(application.getAttribute("roomID"))) {
            application.setAttribute("roomID", roomID);

            List<players> playerlist = (List<players>) application.getAttribute("playerlist");
            playerlist.add((players) application.getAttribute("players"));
            application.setAttribute("playerlist", playerlist);


            req.getRequestDispatcher("/playerWaitingRoom.jsp")
                    .forward(req, resp);
        } else {
            req.setAttribute("flag", "Room not found!");
            req.getRequestDispatcher("/errorpage.jsp")
                    .forward(req, resp);

        }

    }

}
