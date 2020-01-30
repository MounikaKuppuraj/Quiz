package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Viewanswer
 */
@WebServlet("/Viewanswer")
public class Viewanswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewanswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(PrintWriter out = response.getWriter()) {
			response.setContentType("text/html");
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>\n"+
			"<meta charset=\"ISO-8859-1\">\n"+
			"<title>Courses</title>\n"+
			"<link rel=\"stylesheet\" href=\"css/bootstrap.css\"/>\n"+
			"</head>\n"+
			"<body>\n"+
			"<nav class=\"navbar navbar-inverse\">\n"+
			 " <div class=\"container-fluid\">\n"+
			    "<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n"+
			      "<ul class=\"nav navbar-nav\">\n"+
			        "<li><a href=\"taketest.html\"><span class=\"glyphicon glyphicon-pencil\"></span> TakeTest</a></li>\n"+
			        "<li><a href=\"profile.html\"><span class=\"glyphicon glyphicon-user\"></span> Profile</a></li>\n"+
			       " <li class=\"active\"><a href=\"Report\"><span class=\"glyphicon glyphicon-list-alt\"></span> Report</a></li>\n"+
			     "</ul>\n"+
			       "<ul class=\"nav navbar-nav navbar-right\">\n"+
			       " <li class=\"active\"><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> MounikaKuppuraj</a></li>\n"+
			          "<li><a href=\"index2.html\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n"+
			     "</ul>\n"+
			    "</div>\n"+
			  "</div>\n"+
			  "</nav>\n");
		
			try{
				 int i=0,mark=0,totalmark=0;
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from useranswers");
				out.println("<div style='width:1024px; margin:40px 80px auto;'>\n"+
						"<div align=\"center\" style=\"font-size:20px;\" class=\"text-danger\">\n"+
				"<div>\n"+
				"<label>Marks Scored</label>\n"+
				"</div>\n"+
				"</div>\n"+
				"<div style='width:1024px; margin:40px 80px auto;'>\n"+
				"<table class='table table-striped'>\n"+
				
				"<tr>\n"+
				"<th>S.No</th>\n"+
				"<th>Question</th>\n"+
				"<th>Original Answer</th>\n"+
				"<th>Mark</th>\n"+
				"<th>Student Answer</th>\n"+
				"<th>Marks Scored</th>\n"+
				"<tr>\n"+
				"</div>");
				while(rs.next())
				{
					if(rs.getString(2).equals(rs.getString(3)))
					{
						mark++;
						totalmark++;
					}
					else
					{
						mark=0;
					}
					out.println("<tr><td>"+(++i)+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>1.0</td><td>"+rs.getString(3)+"</td><td>"+mark+".0</td></tr>");
                    mark=0;
				}
				out.println("<div align=\"right\" style=\"font-size:20px;\" class=\"text-danger\">\n"+
						"<label>Total Score:</label>"+totalmark+"\n"+
						"</div>\n"+
						"</table>");
				out.println("</div>");
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e){
				out.println(e);
			}
			out.println("</body>");
			out.println("</html>");
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
