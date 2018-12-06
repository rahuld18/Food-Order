package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Item;

public class ItemController {
	
	
	public static boolean addNewItem(Item I)
	{
		
		try{
			  Connection cn=DbHelper.openConnection();
			  String query="insert into item (itemname,price,description,category,subcategory,photo)values('"+I.getItemname()+"','"+I.getPrice()+"','"+I.getDescription()+"','"+I.getCategory()+"','"+I.getSubcategory()+"','"+I.getPhoto()+"')";

		boolean st=DbHelper.executeUpdate(cn, query);
		 return(st);
		}
		catch(Exception e)
			{
			System.out.println("Error:addNewItem()"+e);
			}
		return(false);
	}

	public static ResultSet displayAll()
	{
		try{
			Connection cn=DbHelper.openConnection();
			String query="select * from item";
			ResultSet rs=DbHelper.executeQuery(cn, query);
			return rs;
			
		}catch(Exception e)
		{
			
			System.out.println("Error:displayAll()"+e);
		}
		return null;
	}
	
	public static ResultSet displayById(int cid)
	{
		try{
		Connection cn=DbHelper.openConnection();
		String query="select I.itemid,I.itemname,I.price,I.description,(select C.categoryname from category C where C.categoryid=I.category),(select S.subcategoryname from subcategory S where S.subcategoryid=I.subcategory),I.photo,I.category,I.subcategory from item I where I.itemid="+cid;
		ResultSet rs=DbHelper.executeQuery(cn, query);
		return rs;
		}catch(Exception e)
		{
			System.out.println("Error:displayitemById():"+e);
			
		}
		return null;
	}
	
	 public static ResultSet displayBySubcategory(int sid)
	 {
		 try{
				Connection cn=DbHelper.openConnection();
				String query="select * from item where subcategory="+sid;
				ResultSet rs=DbHelper.executeQuery(cn, query);
				return rs;
				
			}catch(Exception e)
			{
				
				System.out.println("Error:display all items () "+e);
			}
			return null; 
		 
	 }
	



}
