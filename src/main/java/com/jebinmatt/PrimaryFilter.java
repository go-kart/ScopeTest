package com.jebinmatt;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class PrimaryFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String uri = ((HttpServletRequest)request).getRequestURI();
        if(uri.contains("jsp") || uri.contains("ico") || uri.equals("/") || uri.equals("/inner/"))
        {
            System.out.println("Excluded");
            chain.doFilter(request, response);
            return;
        }

        String s = "You've hit PrimaryFilter. q="+ request.getParameter("q")  + " " + Integer.toHexString(System.identityHashCode(request))+ " " + Integer.toHexString(System.identityHashCode(response));
        System.out.println(s);
        response.getOutputStream().println(s);

        chain.doFilter(request, response);

        s = "BuBye from PrimaryFilter. q="+ request.getParameter("q");
        System.out.println(s);
        response.getOutputStream().println(s);
    }

    @Override
    public void destroy() {

    }
}
