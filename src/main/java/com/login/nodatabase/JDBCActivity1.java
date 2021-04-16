package com.login.nodatabase;

import com.mysql.cj.protocol.Resultset;

import entity.Activity1;
import entity.ActivityEntity1;
import entity.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCActivity1 {
    public static Connection gconnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/nbs","root","sajib1432"
        );
    }
    public static void save (Activity1 u) throws SQLException, ClassNotFoundException {
        String sql ="insert into nbs.Activity values(" +
                u.getId() + ","
                + "'" + u.getTitle() + "',"
                + "'" + u.getDescription() + "',"
                + "'" + u.getActivityDate() + "',"
                + "'" + u.getTime() + "'"
                + ")";
        Statement stmt= gconnection().createStatement();
        stmt.executeQuery("use nbs");
        stmt.executeUpdate(sql);

    }
    public static List<ActivityEntity1> getallclient1() throws SQLException, ClassNotFoundException {
        List<ActivityEntity1> list = new ArrayList<>();
        Statement stmt= gconnection().createStatement();
        String sql  ="select * from nbs.Activity";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        	ActivityEntity1 c= new ActivityEntity1();
            c.setId(rs.getInt(1));
            c.setTitle(rs.getString(2));
            c.setDescription(rs.getString(3));
            c.setActivityDate(rs.getString(4));
            c.setTime(rs.getString(5));

            list.add(c);
            System.out.println(c.toString()+"Successful");

        }
        return list;
    }
}
