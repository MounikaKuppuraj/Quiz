package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Answers
 */
@WebServlet("/Answers")
public class Answers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Answers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   PrintWriter out = response.getWriter();
   String useropt = request.getParameter("userradio");
   String ques = request.getParameter("question");
    String uservalue=null;
		
		try{
			response.setContentType("text/html");
			if(useropt.equalsIgnoreCase("Option1")){
				uservalue="Option1";
			}
			else if(useropt.equalsIgnoreCase("Option2")){
				uservalue="Option2";

			}
			else if(useropt.equalsIgnoreCase("Option3")){
				uservalue="Option3";

			}
			else if(useropt.equalsIgnoreCase("Option4")){
				uservalue="Option4";

			}
			else{
				uservalue="none";
			}
			String opt=null;
			
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt = conn.createStatement();
				ResultSet rs= stmt.executeQuery("select * from question where Question='"+ques+"'");
				while(rs.next())
					opt=rs.getString(6);
				stmt.executeUpdate("insert into useranswers values('"+ques +"','"+uservalue+"','"+opt+"')");
				stmt.close();
				conn.close();
				response.sendRedirect("Attend");
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
