package com.quiz.group_n;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Questions {
	Scanner scan = new Scanner(System.in);
	static HashMap<String, Character> map = new HashMap<String, Character>();
	NewConnection connect = new NewConnection();
	Connection con = null;
	PreparedStatement ps =null;

	public void demo() {
		int count = 0;
		
		String q1= "Which nation has won the most FiFa World Cups"+ "\nA. Italy"+"\nB. Germany"+"\nC. Argentina"+"\nD. Brazil";
		String q2= "In what year did world war II start"+ "\nA. 1938"+  "\nB. 1945"+  "\nC. 1914"+ "\nD. 1918";
		String q3= "How many times did India win the ICC World cup"+"\nA. 2"+"\nB. 5"+"\nC. 3"+"\nD. 1";
		String q4= "Which country won the FIFA World cup in 2010"+"\nA. Germany"+"\nB. Spain"+"\nC. Italy"+"\nD. Brazil";
		
		map.put(q1, 'D');
		map.put(q2, 'A');
		map.put(q3, 'A');
		map.put(q4, 'B');
		
		Set<String> set= map.keySet();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String q = itr.next();
			System.out.println(q);
			System.out.println("Choose your answer");
			char ans = scan.next().toUpperCase().charAt(0);
			if(ans==map.get(q)){
				count++;
						
			}
//		System.out.println("Your score is: "+count);
		
	}
		try {
			con = connect.newConnection();
			ps = con.prepareStatement("update user set score = ? where id = ?");
			ps.setInt(1, count);
			ps.setInt(2,1);
			ps.execute();
			ps = con.prepareStatement("select * from user where id = 1");
			ps.execute();
			ResultSet rs  = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Your score is: "+rs.getInt(5));
			}
			
		}catch(Exception e	) {
			e.printStackTrace();
		
	}
		}
	
	
	public static void main(String[] args) {
		Questions quiz = new Questions();
		quiz.demo();		
	}	
	
	}
	
	
	



