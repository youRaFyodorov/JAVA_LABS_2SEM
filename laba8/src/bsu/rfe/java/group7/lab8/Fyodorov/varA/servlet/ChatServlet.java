package bsu.rfe.java.group7.lab8.Fyodorov.varA.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import bsu.rfe.java.group7.lab8.Fyodorov.varA.entity.ChatMessage;
import bsu.rfe.java.group7.lab8.Fyodorov.varA.entity.ChatUser;

@WebServlet(name = "ChatServlet")
public class ChatServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //карта текущих пользователей
    protected HashMap<String, ChatUser> activeUsers;
    //список сообщений чата
    protected ArrayList<ChatMessage> messages;

    @SuppressWarnings("unchecked")
    public void init() throws ServletException {
        super.init();

        activeUsers = (HashMap<String, ChatUser>) getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<ChatMessage>) getServletContext().getAttribute("messages");

        if (activeUsers==null) {
            activeUsers = new HashMap<String, ChatUser>();
            getServletContext().setAttribute("activeUsers", activeUsers);
        }

        if (messages==null) {
            messages = new ArrayList<ChatMessage>(100);
            getServletContext().setAttribute("messages", messages);
        }
    }
}