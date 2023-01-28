
package com.quiz.group_n;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Questions {
	static Scanner scan = new Scanner(System.in);
	
	NewConnection connect = new NewConnection();
	Connection con = null;
	PreparedStatement ps = null;

	public void takeQuiz() {
		int count=0;
		HashSet<String> set1 = new HashSet<String> ();
		System.out.println("To take the quiz test enter your username");
		String ans1 = scan.next();
		try {
			con = connect.newConnection();
			ps = con.prepareStatement("select username from user");
			ps.execute();
			ResultSet rs  = ps.executeQuery();
			while(rs.next()) {
				set1.add(rs.getString(1));
			}
			
		}catch(Exception e	) {
			e.printStackTrace();
		
	}
		
		
		if(set1.contains(ans1)) {
		
			final ArrayList<Character> list = new ArrayList<Character>();
			Scanner scan = new Scanner(System.in);
			
			
			String[] que = {"Which nation has won the most FiFa World Cups ?",
					"In what year did world war II start ?", 
					"How many times did India win the ICC World cup ?",
					"Which country won the FIFA World cup in 2010 ?",
					"Which country was host nation for 2012 OLYMPICS ?",
					"Real Madrid a Spanish football club was founded in?",
					"Which French player holds the record for most goal scored for country ?",
					"Which sports band sponsored the 'Brazuca' football at the 2014 world cup ?",
					"First ICC T20 world cup played in which country ?",
					"Which country lost 2004 Euro final ?"
					};
			
			String[][] options = {
					
					{"Italy","Germany","Argentina", "Brazil"},
					{ "1939", "1945", "1914", "1918"},
					{"2","5","3","1"},
					{"Germany","Spain","Italy", "Brazil"},
					{"England","Spain","Italy", "Brazil"},
					{ "1898", "1902", "1914", "1950"},
					{"Zinedine Zidane", "Oliver Giroud", "Antoine Griezmann","Thierry Henry"},
					{"Puma","Nike","Adidas","New Balance"},
					{"South Africa","Australia","India","England"},
					{"Greece","Portugal","Germany","France"}
					
			};
			
			String[] button = {"A. ","B. ","C. ","D. "};
			
			list.add(0, 'D');
			list.add(1, 'A');
			list.add(2, 'A');
			list.add(3, 'B');
			list.add(4, 'A');
			list.add(5, 'B');
			list.add(6, 'B');
			list.add(7, 'C');
			list.add(8, 'A');
			list.add(9, 'B');
			

			
			for(int i=0; i<que.length;i++) {
				System.out.println(que[i]);
				for(int j=0; j<4;j++) {
				
				System.out.print(button[j]);
				System.out.println(options[i][j]);}
				System.out.println("\nChoose your answer");
				char input = scan.next().toUpperCase().charAt(0);
				
					if(list.get(i)==input) {
						count++;
						}
					}
			
			scan.close();		
			
			try {
				con = connect.newConnection();
				ps = con.prepareStatement("update user set score = ? where username = ?");
				ps.setInt(1, count);
				ps.setString(2,ans1);
				ps.execute();
				ps = con.prepareStatement("select score from user where username = ?");
				ps.setString(1, ans1);
				ps.execute();
				ResultSet rs  = ps.executeQuery();
				while(rs.next()) {
					System.out.println("Your score is: "+rs.getInt(1));
				}
				
			}catch(Exception e	) {
				e.printStackTrace();
			
					}
		}
	
		else {
			System.out.println("Username doesn't match");}
		
		}

		
		
	
	
	public static void main(String[] args) {
		Questions quiz = new Questions();
		Userlogin log = new Userlogin();
		
		System.out.println("Have you created username already");
		
		char input= scan.next().toLowerCase().charAt(0);
		
		if(input == 'y') {
		quiz.takeQuiz();		
		}
		else {
		log.userInfo();
		
		quiz.takeQuiz();}
		
	}	
	
	}
	
	
	



