package com.blade.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String n = this.getServletContext().getInitParameter("name");
        System.out.println(n);

        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();
        if (session.getAttribute("visited") == null) {
            session.setAttribute("visited", 1);
        } else {
            Integer count = (Integer) session.getAttribute("visited");
            session.setAttribute("visited", ++count);
        }

        int name = 0;
        int nation = 0;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")) name = 1;
            if (cookie.getName().equals("nation")) nation = 1;
        }

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=utd-8");

        if (name + nation < 2) {
            System.out.println("no cookies for name&&nation seted");

            Cookie name_cookie = new Cookie("name", "xuezhijian");
            name_cookie.setMaxAge(60*60*24);

            Cookie nation_cookie = new Cookie("nation", "china");
            nation_cookie.setMaxAge(60*60*24);

            resp.addCookie(name_cookie);
            resp.addCookie(nation_cookie);
        } else {
            System.out.println("cook with name&&nation has been set");
            for (Cookie c : cookies) {
                writer.append(c.getName()).append(": ").append(c.getValue()).append("<br>");
                if (c.getName().equals("name")) System.out.println(c.getName()+": "+c.getValue());
                if (c.getName().equals("nation")) System.out.println(c.getName()+": "+c.getValue());
            }
        }

        Integer count = (Integer) session.getAttribute("visited");
        writer.append("<br><br>you have visited this site for ").append(String.valueOf(count)).append(" times");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
