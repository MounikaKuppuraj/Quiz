package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Editselectprofile
 */
@WebServlet("/Editselectprofile")
public class Editselectprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editselectprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		try{
			//response.setContentType("text/html");
			String emailId = request.getParameter("email");
			String userName = request.getParameter("username");
			String telephoneNo = request.getParameter("telephone");
			String Gender = request.getParameter("gender");
			String Dob = request.getParameter("dob");
			String Occupation= request.getParameter("occupation");
			
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("update register set username = '"+userName+"', telephone='"+telephoneNo+"', gender = '"+Gender+"', dob = '"+Dob+"', occupation = '"+Occupation+"' where email = '"+emailId+"'");
				stmt.close();
				conn.close();
			
				response.sendRedirect("profile.html");
				
			} catch(Exception e){
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
