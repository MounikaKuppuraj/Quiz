package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Changepassword
 */
@WebServlet("/changepassword")
public class Changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changepassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
	    String password=request.getParameter("newPassword");  
	    String oldpassword=request.getParameter("oldPassword");  
	   
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
			Statement smt =(Statement) con.createStatement();
		   ResultSet rs= smt.executeQuery("select * from register where password='"+oldpassword+"'");
			while(rs.next())
			{
		    		smt.executeUpdate("update register set password='"+password+"', confirmpassword='"+password+"' where email='"+rs.getString(4)+"'");
	   
			}
			response.sendRedirect("profile.html");	
		con.close();
	   smt.close();
	   
	    }
	    catch(Exception e)
	    {
	    out.println(e);	   
	    }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
