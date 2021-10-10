package com.blade.servlet;

import com.blade.jdbc.UserDao;
import com.blade.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class UserServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        System.out.println(Long.valueOf(req.getParameter("uid")));
        System.out.println(Arrays.toString(req.getParameterValues("username")));
        System.out.println(Arrays.toString(req.getParameterValues("nickname")));

        if (user.getUid() == null || user.getUsername() == null || user.getNickname() == null)
            throw new RuntimeException("datas should not be null");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        if (userDao.getUserById(user.getUid()) == null) {
            Integer rows = userDao.insertUser(user);
            out.println("<p>have inserted " + rows + " row(s) of data</p><br>");
            out.println("<a href=\"/user\">back to user page</a>");
        } else {
            Integer rows = userDao.updateUser(user);
            out.println("<p>have updated " + rows + " row(s) of data</p><br>");
            out.println("<a href=\"/user\">back to user page</a>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int counter = 0;
        List<User> list = userDao.getAllUsers();

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("   <meta charset=\"UTF-8\">");
        out.println("   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("   <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
        out.println("   <title>用户管理</title>");
        out.println("    <style>");
        out.println("       #refresh-btn {");
        out.println("           position: absolute;");
        out.println("           right: 20px;");
        out.println("       }");
        out.println("       ");
        out.println("       #tools {");
        out.println("           min-height: 40px;");
        out.println("       }");
        out.println("   </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div align=\"center\">");
        out.println("       <h1>简单的用户管理实例</h1>");
        out.println("       <p>当前时间是：</p>");
        out.println("   </div>");
        out.println("    <div id=\"tools\" align=\"center\" width=\"1200\">");
        out.println("       <button id=\"refresh-btn\" onclick=\"javascript: location.reload()\">刷新页面</button>");
        out.println("       <!-- post请求提交表单 -->");
        out.println("       <i>**根据学号提交用户，学号不存在则创建新用户，存在则更新用户**</i>");
        out.println("       <form action=\"/user\" method=\"POST\">");
        out.println("           <label>学号：</label><input type=\"text\" name=\"uid\" />");
        out.println("           <label>用户名：</label><input type=\"text \" name=\"username\" />");
        out.println("           <label>昵称</label><input type=\"text \" name=\"nickname\" />");
        out.println("           <input type=\"submit\" value=\"提交用户\" />");
        out.println("           <br><br>");
        out.println("        </form>");
        out.println("   </div>");
        out.println("    <table border=\"1 \" align=\"center \" width=\"1200 \">");
        out.println("       <tr>");
        out.println("           <th>编号</th>");
        out.println("           <th>学号</th>");
        out.println("           <th>用户名</th>");
        out.println("           <th>昵称</th>");
        out.println("       </tr>");
        for (User user: list) {
            out.println("       <tr>");
            out.println("           <td>" + ++counter + "</td>");
            out.println("           <td>" + user.getUid() + "</td>");
            out.println("           <td>" + user.getUsername() + "</td>");
            out.println("           <td>" + user.getNickname() + "</td>");
            out.println("       </tr>");
        }
        out.println("   </table>");
        out.println("</body>");
        out.println("</html>");

    }
}


//for (User user: list) {
//        out.println("       <tr>");
//        out.println("           <td>" + ++counter + "</td>");
//        out.println("           <td>" + user.getUid() + "</td>");
//        out.println("           <td>" + user.getUsername() + "</td>");
//        out.println("           <td>" + user.getNickname() + "</td>");
//        out.println("       </tr>");
//        }



