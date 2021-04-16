package com.login.nodatabase;


import com.mysql.cj.protocol.Resultset;

import entity.ClinetEntity;
import entity.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCClient {
    public static Connection gconnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/nbs","root","sajib1432"
        );
    }
    public static void save (Client u) throws SQLException, ClassNotFoundException {
        String sql ="insert into clientlist values(" +
                u.getId() + ","
                + "'" + u.getName() + "',"
                + "'" + u.getEmail() + "',"
                + "'" + u.getPosition() + "',"
                + "'" + u.getAddress() + "'"
                + ")";
        Statement stmt= gconnection().createStatement();
        stmt.executeQuery("use nbs");
        stmt.executeUpdate(sql);

    }

   
    
    public static List<ClinetEntity> getallclient() throws SQLException, ClassNotFoundException {
        List<ClinetEntity> list = new ArrayList<>();
        Statement stmt= gconnection().createStatement();
        String sql  ="select * from nbs.clientlist";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
        	ClinetEntity c= new ClinetEntity();
            c.setId(rs.getInt(1));
            c.setName(rs.getString(2));
            c.setPosition(rs.getString(3));
            c.setEmail(rs.getString(4));
            c.setAddress(rs.getString(5));

            list.add(c);
            System.out.println(c.toString()+"Done");

        }
        return list;
    }
    

 
    public static void delete(int Id) throws SQLException, ClassNotFoundException {
        Statement stmt= gconnection().createStatement();
        String sql  ="delete from nbs.clientlist where Id= "+Id+"";
        stmt.executeUpdate(sql);
       
        
    }
    public static void update (Client p) throws SQLException, ClassNotFoundException{
    	Statement stmt= gconnection().createStatement();
        String sql = "update clientlist set name='"+ p.getName()+"', email='"+p.getEmail()+"', position='"+p.getPosition()+"', Address='"+p.getAddress()+"', where id="+p.getId()+"";
        stmt.executeUpdate(sql);
    }
}

