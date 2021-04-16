package com.login.service;

import entity.Notification;
import com.login.nodatabase.JDBCClient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Logininfo {
    private static Connection conn = null;

    public static List<Notification> loginfo() throws SQLException, ClassNotFoundException {
        List<Notification> log = new ArrayList<>();
        conn = JDBCClient.gconnection();
        Statement stmt= conn.createStatement();
        String sql  ="select * from nbs.login";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        	Notification x= new Notification();
            
            x.setUsername(rs.getString(1));
            x.setPassword(rs.getString(2));
            x.setRole(rs.getString(3));
            log.add(x);
            System.out.println(x.toString()+"Done");
        }
        return log;
    }
}
