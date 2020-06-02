package bsu.rfe.java.group7.lab8.Fyodorov.varA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bsu.rfe.java.group7.lab8.Fyodorov.varA.entity.ChatMessage;

@WebServlet(name = "MessageListServlet")
public class MessageListServlet extends ChatServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<html><head><meta http-equiv='Content-Type' content='text/html; " +
                "charset=utf-8'/><meta http-equiv='refresh' content='10'></head>");
        pw.println("<body>");

        for (int i=messages.size()-1; i>=0; i--) {
            ChatMessage aMessage = messages.get(i);
            if(aMessage.getFlag() == true) {
                pw.println("<div><strong>" + ""
                        + "</strong>" + aMessage.getMessage() + "</div>");

            } else {
                pw.println("<div><strong>" + aMessage.getAuthor().getName()

                        + "</strong>: " + aMessage.getMessage() + "</div>");
            }
        }
        pw.println("</body></html>");
    }
}