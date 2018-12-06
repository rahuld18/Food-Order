package controller;

import java.sql.Connection;
import java.sql.ResultSet;


import model.User;


public class UserController {
	public static boolean addNewUser(User U)
	 {
			try{
				  Connection cn=DbHelper.openConnection();
				  String query="insert into user(name,mno,email,password) values('"+U.getName()+"','"+U.getMno()+"','"+U.getEmail()+"','"+U.getPassword()+"')";
				  boolean st=DbHelper.executeUpdate(cn, query);
					 return(st); 
			}
			catch(Exception e)
				{
				System.out.println("Error:addNewUser()"+e);
				}
			return(false);
		 
	 }
	
	public static User checkLogin(String uid,String pwd)
	{
		try{
			  Connection cn=DbHelper.openConnection();
			  String query="select * from user where userid='"+uid+"' and password='"+pwd+"'";
			  
			  ResultSet rs=DbHelper.executeQuery(cn, query);
			  if(rs.next())
			  {
				  User U= new User();
				  U.setUserid(Integer.parseInt(rs.getString(1)));
				  U.setPassword(rs.getString(5));
				  U.setEmail(rs.getString(4));
				  U.setName(rs.getString(2));
				  
				  
					return U;
					  
					  
			  }
			  
		}
		catch(Exception e)
			{
			System.out.println("Error:checkLogin"+e);
			}
		return(null);
		  
		
		
	}

}
