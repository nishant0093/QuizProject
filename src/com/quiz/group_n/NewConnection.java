package com.quiz.group_n;

import java.sql.Connection;
import java.sql.DriverManager;

public class NewConnection {
	
	static Connection conn  = null;
	
	public Connection newConnection() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","root");}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
		
	}

}
