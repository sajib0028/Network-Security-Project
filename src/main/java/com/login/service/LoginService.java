package com.login.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.stereotype.Service;

import com.login.nodatabase.JDBCClient;



@Service
public class LoginService {

	private static Connection conn = null;

	public int validateUser(String userid, String password) {
		try {
			conn = JDBCClient.gconnection();

			String ret = "Select * from login;";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ret);

			while (rs.next()) {
				String name = rs.getString("username");
				String pass = rs.getString("password");
				String role = rs.getString("role");
				if (userid.equals(name) && password.equals(pass) && role.equals("client")) {
					return 1;
				} else if (userid.equals(name) && password.equals(pass) && role.equals("admin")) {
					return 2;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 3;
	}

}
