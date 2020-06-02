package bsu.rfe.java.group7.lab8.Fyodorov.varA.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bsu.rfe.java.group7.lab8.Fyodorov.varA.entity.ChatUser;

@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends ChatServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        String name = (String) request.getSession().getAttribute("name");

        if (name!=null) {
            ChatUser aUser = activeUsers.get(name);
            if (aUser.getSessionId().equals((String)
                    request.getSession().getId())) {
                synchronized (activeUsers) {
                    activeUsers.remove(name);
                }

                request.getSession().setAttribute("name", null);
                response.addCookie(new Cookie("sessionId", null));
                response.sendRedirect(response.encodeRedirectURL("/laba8/"));
            } else {
                response.sendRedirect(response.encodeRedirectURL("/laba8/view.html"));
            }
        } else {
            response.sendRedirect(response.encodeRedirectURL("/laba8/view.html"));
        }
    }
}
