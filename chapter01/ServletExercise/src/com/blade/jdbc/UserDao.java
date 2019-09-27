package com.blade.jdbc;

import javafx.scene.control.TableView;

import java.sql.*;

public class UserDao {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/boothrms?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&allowMultiQueries=true";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        String sql = "select * from user;";

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
