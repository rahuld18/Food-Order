package controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class CategorySubcategoryController {
	
	public static ResultSet GetAllCategory()
	{
		try{
		Connection cn=DbHelper.openConnection();
		ResultSet rs=DbHelper.executeQuery(cn,"select * from category");
		return rs;
		}catch(Exception e)
		{
			
			System.out.println("GetAllcategory(): "+e);
	
		}return null;
	}

	public static ResultSet GetAllSubcategory(int cid)
	{
		
		try{
			Connection cn=DbHelper.openConnection();
			ResultSet rs=DbHelper.executeQuery(cn,"select * from subcategory where categoryid="+cid);
			return rs;
			}catch(Exception e)
			{
				
				System.out.println("GetAllSubcategory(): "+e);
		
			}return null;
	}
}
