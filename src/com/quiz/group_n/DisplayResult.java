package com.quiz.group_n;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class DisplayResult {
	
	 NewConnection ns=new NewConnection();
	 Connection con=null;
	 PreparedStatement ps =null;
	 Scanner scan = new Scanner(System.in);
	 HashSet set1 = new HashSet();
	 
	public void getResult() {
		
		
		try {
			con =ns.newConnection();
		    ps = con.prepareStatement("select username from user ");
		    ps.execute();
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    set1.add(rs.getInt(1));
		    System.out.println(set1);
		    }
		
		    
		System.out.println("To check your score press 1:"); 
		System.out.println("To check the score all students in descending order press 2:");
		System.out.println("To check the score all students in ascending order press 3:");
		int n = scan.nextInt();
		
		switch(n) {
		case 1:
			getScore();
			break;
		case 2:
			descSortedResult();
			break;
		case 3:
			ascSortedResult();
			break;
		
		}
		

		
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public void getScore() {
		int score_user= 0;
			System.out.println("Enter your username");
			String username = scan.next();
			if(set1.contains(username)) {
			try {
			con =ns.newConnection();
		    ps = con.prepareStatement("select score from user where username =?");
		    ps.setString(1, username);
		    ps.execute();
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()){
		    	score_user = rs.getInt(1);
		    }
			
			 {
						if (score_user>=8 && score_user<=10) {
							System.out.println("Score is: "+score_user+" and grade is 'A' ");
							}
						else if(score_user>6 && score_user>=8) {
							System.out.println("Score is: "+score_user+" and grade is 'B' ");
						}
						else if(score_user==5) {
							System.out.println("Score is: "+score_user+" and grade is 'C' ");
						}
						else {
							System.out.println("Score is: "+score_user+" and you have failed this test ");
						}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			}
			
			else {
				System.out.println("Wrong username");
			}
	}
		
	public void descSortedResult() {
		try {
			con =ns.newConnection();
		    ps = con.prepareStatement("select * from user order by score desc");
		   
		    ps.execute();
		    ResultSet rs=ps.executeQuery();
		    System.out.println("The score displayed will be in from top scorer to low scorer\n");
		    
		    while(rs.next()){
		    	
		    	System.out.println("[ Full Name: "+rs.getString(1)+" |  Username: "+rs.getString(2)+" |  Score: "+rs.getInt(3)+" ]");
		    	
		    }
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void ascSortedResult() {
		try {
			con =ns.newConnection();
		    ps = con.prepareStatement("select * from user order by score asc");
		   
		    ps.execute();
		    ResultSet rs=ps.executeQuery();
		    System.out.println("The score displayed will be in from low scorer to top scorer\n");
		    
		    while(rs.next()){
		    	
		    	System.out.println("[ Full Name: "+rs.getString(1)+" |  Username: "+rs.getString(2)+" |  Score: "+rs.getInt(3)+" ]");
		    	
		    }
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		DisplayResult res=new DisplayResult();
		res.getResult();
		
		

	}

}
