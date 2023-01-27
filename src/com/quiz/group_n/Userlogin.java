package com.quiz.group_n;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Userlogin {
	Scanner scan = new Scanner(System.in);
	NewConnection con = new NewConnection();
	PreparedStatement ps = null;
	Connection conn = null; 
	
	public static void main(String[] args) {
		Userlogin ul = new Userlogin();
		ul.userInfo();
		
	}
	public void userInfo() {
		
		System.out.println("Enter your full name: ");
        String name = scan.nextLine();
        System.out.println("Enter username: ");
        String username = scan.next();
        
        try {
      conn =con.newConnection();
      ps = conn.prepareStatement("insert into user (full_name , username) values (?, ?)" );
      ps.setString(1 , name);
      ps.setString(2 , username);
     ps.execute();
     
     System.out.println("user added");
        	
        } catch (Exception e)
        {
        	e.printStackTrace();
        }
		
	}

}
