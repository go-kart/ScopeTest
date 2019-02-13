package com.jebinmatt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = "You've hit the MainServlet. q="+ req.getParameter("q")  + " " + Integer.toHexString(System.identityHashCode(req))+ " " + Integer.toHexString(System.identityHashCode(resp)) ;
        System.out.println(s);
        resp.getOutputStream().println(s);

        s = (new PrintIt()).get();
        resp.getOutputStream().println(s);

        req.getRequestDispatcher("/another").include(req, resp);
//        req.getRequestDispatcher("/another").forward(req, resp);
//        resp.sendRedirect("/another");

        s = "Psychic Activity from the MainServlet! q="+ req.getParameter("q");
        System.out.println(s);
        resp.getOutputStream().println(s);
    }
}
