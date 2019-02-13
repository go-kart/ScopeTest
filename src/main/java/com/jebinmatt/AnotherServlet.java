package com.jebinmatt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/another")
public class AnotherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = "You've hit AnotherServlet. q="+ req.getParameter("q") + " " + Integer.toHexString(System.identityHashCode(req))+ " " + Integer.toHexString(System.identityHashCode(resp)) ;
        System.out.println(s);
        resp.getOutputStream().println(s);
    }
}
