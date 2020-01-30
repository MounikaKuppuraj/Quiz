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
 * Servlet implementation class Editprofile
 */
@WebServlet("/Editprofile")
public class Editprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editprofile() {
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
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt = conn.createStatement();
				String emailId = request.getParameter("email");
				ResultSet rs= stmt.executeQuery("select * from register where email='"+emailId+"'");
				if(rs.next())
				{
					out.println("<!DOCTYPE html>\n"+
					"<html>\n"+
					"<head>\n"+
					"<meta charset=\"ISO-8859-1\">\n"+
					"<title>Editprofile1</title>\n"+
					"<link rel=\"stylesheet\" href=\"css/bootstrap.css\"/>\n"+
					"</head>\n"+
					"<body>\n"+
					"<nav class=\"navbar navbar-inverse\">\n"+
					  "<div class=\"container-fluid\">\n"+
					    "<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n"+
					      "<ul class=\"nav navbar-nav\">\n"+
					         "<li><a href=\"taketest.html\"><span class=\"glyphicon glyphicon-pencil\"></span> TakeTest</a></li>\n"+
					        "<li class=\"active\"><a href=\"profile.html\"><span class=\"glyphicon glyphicon-user\"></span> Profile</a></li>\n"+
					        "<li><a href=\"Report\"><span class=\"glyphicon glyphicon-list-alt\"></span> Report</a></li>\n"+
					      "</ul>\n"+
					       "<ul class=\"nav navbar-nav navbar-right\">\n"+
					        "<li class=\"active\"><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> MounikaKuppuraj</a></li>\n"+
					          "<li><a href=\"index2.html\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n"+
					      "</ul>\n"+
					    "</div>\n"+
					  "</div>\n"+
					  "</nav>\n"+
					  "<div style='width: 512px; margin:0 auto;'>\n"+
					"<form action=\"Editselectprofile\" method=\"post\">\n"+
				       "<label for=\"email\">EMAIL</label>\n"+
				"<div class=\"input-group\">\n"+
				     "<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"+
				    "<input id=\"email\" type=\"email\" class=\"form-control\" name=\"email\" value='"+emailId+"'placeholder=\"email\">\n"+
				  "</div>\n"+
				  "<br>\n"+
					"<label for=\"UserName\">USERNAME</label>\n"+
					"<div class=\"input-group\">\n"+
					     "<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"+
					    "<input id=\"username\" type=\"text\" class=\"form-control\" name=\"username\" value='"+rs.getString(1)+"' placeholder=\"UserName\">\n"+
					  "</div>\n"+
					  "<br>\n"+
					  "<label for=\"telephone\">TELEPHONENO</label>\n"+
				        "<div class=\"input-group\">\n"+
				        "<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-earphone\"></i></span>\n"+
				         "<input id=\"telephone\" type=\"text\" class=\"form-control\" name=\"telephone\" value='"+rs.getString(5)+"' placeholder=\"telephoneno\">\n"+
				  "</div>\n"+
				  "<br>\n");
				  if(rs.getString(6).equalsIgnoreCase("male")){
				    out.println("<label for=\"gender\">GENDER</label>\n"+
				  "<div class=\"input-group\">\n"+
				   "<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"+
				    "<input type=\"radio\" name=\"gender\"  value=\"male\" checked=\"checked\"> Male<br>\n"+
				    "<input type=\"radio\" name=\"gender\"   value=\"female\"> FeMale<br>\n"+
					   
				    "</div>\n");
				  }
				  if(rs.getString(6).equalsIgnoreCase("female")){
					    out.println("<label for=\"gender\">GENDER</label>\n"+
					  "<div class=\"input-group\">\n"+
					   "<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"+
					    "<input type=\"radio\" name=\"gender\"  value=\"male\" > Male<br>\n"+
					    "<input type=\"radio\" name=\"gender\" checked=\"checked\"  value=\"female\"> FeMale<br>\n"+
						   
					    "</div>\n");
					  }
					  out.println("<br>\n"+
					   "<label for=\"dob\">DATE OF BIRTH</label>\n"+
					  "<div class=\"input-group\">\n"+
					  "<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-list-alt\"></i></span>\n"+
					    "<input id=\"dob\" type=\"date\" class=\"form-control\" name=\"dob\" value='"+rs.getString(7)+"' placeholder=\"dob\">\n"+
					  "</div>\n"+
					  "<br>\n"+
					 "<label for=\"occupation\">OCCUPATION</label>\n"+
					  "<div class=\"input-group\">\n"+
					   "<span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-user\"></i></span>\n"+
					    "<input id=\"occupation\" type=\"text\" class=\"form-control\" name=\"occupation\" value='"+rs.getString(8)+"' placeholder=\"work\">\n"+
					  "</div>\n"+
					   
					  "<br>\n"+
					  
					   "<button type=\"submit\" class=\"btn btn-success\">Update</button>\n"+
					  "</form>\n"+
					  "</div>\n"+
					"</body>\n"+
					"</html>\n");
				}
				stmt.close();
				conn.close();
				rs.close();
			} catch(Exception e){
				out.println(e);
			}
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
