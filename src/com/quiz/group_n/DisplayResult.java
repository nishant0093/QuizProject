package com.quiz.group_n;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class DisplayResult {
	 int score;
	 NewConnection ns=new NewConnection();
	 Connection con=null;
	 PreparedStatement ps =null;
	 
	
	public void getResult() {
		
		ArrayList list=new ArrayList();
		try {
			con =ns.newConnection();
		    ps = con.prepareStatement("select score from user where username=?");
		    ps.execute();
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    list.add(rs.getInt(1));
		    }
		    System.out.println(list);
		    System.out.println(Collections.frequency(list,4));
		
		if (score>=8 && score<=10) {
			System.out.println("Class A");
		}
		else if(score>6 && score>=8) {
			System.out.println("Class B");
		}
		else if(score==5) {
			System.out.println("Class C");
		}
		else {
			System.out.println("Fail");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	public static void main(String[] args) {
		
		DisplayResult dr=new DisplayResult();
		dr.getResult();
		

	}

}
