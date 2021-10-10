package com.blade.jdbc;

import com.blade.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDao {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/hrmsboot?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&allowMultiQueries=true";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    // Connnectiongs and Statements
    Connection conn = null;
    Statement stmt = null;

    public UserDao() {
        try {
            // 初始一些全局变量
            // 在Servlet中加载类是需要一些技巧的
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        // 查询语句
        String sql = "select * from user";
        // 返回结果
        List<User> list = new LinkedList<>();

        try{
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.parseResultSet(resultSet);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public User getUserById(Long id) {

        // 查询语句
        String sql = String.format("select * from user where uid = %d", id);
        // 返回数据容器
        User user = new User();

        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                user.parseResultSet(resultSet);
            }
            if (user.getUid() == null) {
                throw new RuntimeException("uid can not be null.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // 返回修改成功的uid，否则-1
    public Integer updateUser(User user) {

        // 查询语句
        String sql = String.format("update user set username = '%s', nickname='%s' where uid=%d;",
                                    user.getUsername(), user.getNickname(), user.getUid());
        // 影响的行数
        Integer rows = null;

        try {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    // 返回修改成功的uid，否则-1
    public Integer insertUser(User user) {

        // 查询语句
        String sql = String.format("insert into user(uid, username, nickname) values (%d, '%s', '%s');",
                user.getUid(), user.getUsername(), user.getNickname());
        // 影响的行数
        Integer rows = null;

        try {
            rows = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
