package com.staff.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBuilder {
    static Connection con;
    public static Connection createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dmart","root","root");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("connection error");
        }
        return  con;
    }
}
