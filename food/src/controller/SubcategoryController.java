package controller;

import java.sql.Connection;
import java.sql.ResultSet;


import model.Subcategory;

public class SubcategoryController
{

	public static boolean addNewSubcategory(Subcategory s)
	{
		try{
			  Connection cn=DbHelper.openConnection();
			  String query="insert into subcategory(categoryid,subcategoryname,subcategorydescription,subcategoryicon) values('"+s.getCategoryid()+"','"+s.getSubcategoryname()+"','"+s.getSubcategorydescrition()+"','"+s.getSubcategoryicon()+"')";
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
				String query="select * from subcategory";
				ResultSet rs=DbHelper.executeQuery(cn, query);
				return rs;
				
			}catch(Exception e)
			{
				
				System.out.println("Error:display all category () "+e);
			}
			return null;
		}
		
	 public static ResultSet displayById(int cid)
		{
			try{
			Connection cn=DbHelper.openConnection();
			String query="select P.subcategoryid,P.subcategoryname,P.subcategorydescription,P.subcategoryicon,P.categoryid from subcategory P where P.subcategoryid="+cid;
			ResultSet rs=DbHelper.executeQuery(cn, query);
			return rs;
			}catch(Exception e)
			{
				System.out.println("Error:displayProductById():"+e);
				
			}
			return null;
		}
	 
	 public static boolean editCategory(Subcategory c)
	 { try{
	   Connection cn=DbHelper.openConnection();
	   String query="update subcategory set subcategoryname='"+c.getSubcategoryname()+"',subcategoryid='"+c.getSubcategoryid()+"',subcategorydescription='"+c.getSubcategorydescrition()+"',categoryid='"+c.getCategoryid()+"' where subcategoryid="+c.getSubcategoryid();
	   System.out.println(query);
	   boolean st=DbHelper.executeUpdate(cn, query);
	  return(st);
	   
	  }
	  catch(Exception e)
	  	{
	  	System.out.println("Error:editRecord()"+e);
	  	}
	  return(false);
	  	
	  }
	 public static boolean deleteCategory(int cid)
	 { try{
	   Connection cn=DbHelper.openConnection();
	   String query="delete from subcategory where subcategoryid="+cid;
	  boolean st=DbHelper.executeUpdate(cn, query);
	  return(st);
	   
	 }
	 catch(Exception e)
	 	{
	 	System.out.println("Error:deleteCategory()"+e);
	 	}
	 return(false);
	 	
	 }
	
	 public static boolean editIcon(int pid,String pic)
	 { try{
	   Connection cn=DbHelper.openConnection();
	   String query="update subcategory set subcategoryicon='"+pic+"' where subcategoryid="+pid;
	  boolean st=DbHelper.executeUpdate(cn, query);
	  return(st);
	   
	 }
	 catch(Exception e)
	 	{
	 	System.out.println("Error:editPicture()"+e);
	 	}
	 return(false);
	 	
	 }
	 public static ResultSet displayByCategory(int cid)
	 {
		 try{
				Connection cn=DbHelper.openConnection();
				String query="select * from subcategory where categoryid="+cid;
				ResultSet rs=DbHelper.executeQuery(cn, query);
				return rs;
				
			}catch(Exception e)
			{
				
				System.out.println("Error:display all category () "+e);
			}
			return null; 
		 
	 }
	
}
