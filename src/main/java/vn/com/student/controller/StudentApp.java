package vn.com.student.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentApp {

    public static Connection getConnection() {

        Connection con = null;
        String dbName = "jdbc:postgresql://localhost:5432/sinhvien";
        String dbDriver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "postgres";
        try{
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbName, userName, password);
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return con;
    }
}