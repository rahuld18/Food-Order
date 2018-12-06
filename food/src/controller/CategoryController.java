package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Category;


public class CategoryController 
{

 public static boolean addNewCategory(Category cat)
 {
		try{
			  Connection cn=DbHelper.openConnection();
			  String query="insert into category(categoryname,categoryicon) values('"+cat.getCategoryname()+"','"+cat.getCategoryicon()+"')";
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
			String query="select * from category";
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
		String query="select P.categoryid,P.categoryname,P.categoryicon from category P where P.categoryid="+cid;
		ResultSet rs=DbHelper.executeQuery(cn, query);
		return rs;
		}catch(Exception e)
		{
			System.out.println("Error:displayProductById():"+e);
			
		}
		return null;
	}
 

public static boolean editCategory(Category c)
{ try{
  Connection cn=DbHelper.openConnection();
  String query="update category set categoryname ='"+c.getCategoryname()+"',categoryid="+c.getCategoryid()+"  where categoryid="+c.getCategoryid();
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
  String query="delete from category where categoryid="+cid;
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
  String query="update category set categoryicon='"+pic+"' where categoryid="+pid;
 boolean st=DbHelper.executeUpdate(cn, query);
 return(st);
  
}
catch(Exception e)
	{
	System.out.println("Error:editPicture()"+e);
	}
return(false);
	
}
 
 
 
	
}
