package bsu.rfe.java.group7.lab9.Fyodorov.varA.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import bsu.rfe.java.group7.lab9.Fyodorov.varA.entity.Ad;
import bsu.rfe.java.group7.lab9.Fyodorov.varA.entity.AdList;
import bsu.rfe.java.group7.lab9.Fyodorov.varA.entity.UserList;
import bsu.rfe.java.group7.lab9.Fyodorov.varA.helper.AdListHelper;
import bsu.rfe.java.group7.lab9.Fyodorov.varA.helper.UserListHelper;

public class StartupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        UserList userList = UserListHelper.readUserList(getServletContext());

        getServletContext().setAttribute("users", userList);

        AdList adList = AdListHelper.readAdList(getServletContext());

        getServletContext().setAttribute("ads", adList);
        for (Ad ad: adList.getAds()) {
            ad.setAuthor(userList.findUser(ad.getAuthorId()));
            ad.setLastModified(ad.getLastModified());
        }
    }
}
