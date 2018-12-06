package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Cart;


public class CartController {
	public static boolean addNewItem(Cart C)
	 {
			try{
				  Connection cn=DbHelper.openConnection();
				  String query="insert into cart(userid,itemid,price) values('"+C.getUserid()+"','"+C.getItemid()+"','"+C.getPrice()+"')";
				  boolean st=DbHelper.executeUpdate(cn, query);
					 return(st); 
			}
			catch(Exception e)
				{
				System.out.println("Error:addNewRecord()"+e);
				}
			return(false);
		 
	 }
	public static ResultSet displayAll()
	{
		try{
			Connection cn=DbHelper.openConnection();
			String query="select * from cart";
			ResultSet rs=DbHelper.executeQuery(cn, query);
			return rs;
			
		}catch(Exception e)
		{
			
			System.out.println("Error:display all cart () "+e);
		}
		return null;
	}





}
