package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import controller.CategorySubcategoryController;
import controller.DbHelper;

/**
 * Servlet implementation class GetAllSubcategoryJSON
 */
@WebServlet("/GetAllSubcategoryJSON")
public class GetAllSubcategoryJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllSubcategoryJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out=response.getWriter();
	ResultSet rs=CategorySubcategoryController.GetAllSubcategory(Integer.parseInt(request.getParameter("cid")));
	ArrayList <JSONObject> obj=DbHelper.JsonEngine(rs); 
	out.println(obj);
	
	}

}
