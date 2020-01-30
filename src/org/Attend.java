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
 * Servlet implementation class Attend
 */
@WebServlet("/Attend")
public class Attend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			try{
				 int i=0;
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from question");
				int value=1;
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>\n"+
				"<meta charset=\"ISO-8859-1\">\n"+
				"<title>Courses</title>\n"+
				"<link rel=\"stylesheet\" href=\"css/bootstrap.css\"/>\n"+
				"<script src='js/switch.js'></script>"+
				"</head>\n"+
				"<body>\n");

				out.println("<nav class=\"navbar navbar-inverse\">\n"+
				 " <div class=\"container-fluid\">\n"+
				    "<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n"+
				      "<ul class=\"nav navbar-nav\">\n"+
				        "<li class=\"active\"><a href=\"taketest.html\"><span class=\"glyphicon glyphicon-pencil\"></span> TakeTest</a></li>\n"+
				        "<li><a href=\"profile.html\"><span class=\"glyphicon glyphicon-user\"></span> Profile</a></li>\n"+
				       " <li><a href=\"Report\"><span class=\"glyphicon glyphicon-list-alt\"></span> Report</a></li>\n"+
				     "</ul>\n"+
				       "<ul class=\"nav navbar-nav navbar-right\">\n"+
				       " <li class=\"active\"><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> MounikaKuppuraj</a></li>\n"+
				          "<li><a href=\"index2.html\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n"+
				     "</ul>\n"+
				    "</div>\n"+
				  "</div>\n"+
				  "</nav>\n");
				while(rs.next())
				{
					
					out.println("<form action=\"Answers\" method=\"post\">\n"+
							"<div id='question"+value+"' style='display:none'>\n"+
							 	"<div style='width :1024px;margin:0 auto;'>\n"+
								 		"<div align=\"left\" style=\"font-size:20px;\" class=\"text-danger\">\n"+
								 			"<label>Duration:</label>\n"+
								 			"<input type=\"text\" id=duration name=duration>\n"+
								 		"</div>\n"+
								 	
								 		"<div align=\"center\" style=\"font-size:20px;\" class=\"text-danger\">\n"+
										"<label>Question.No:"+(++i)+"</label>\n"+
										"<br>\n"+
										"<textarea class=\"form-control\" rows=\"4\" name=\"question\" readonly=\"readonly\" id=\"Question\">"+rs.getString(1)+"</textarea>\n"+
										"</div>\n"+
										"<br>\n"+
										 "<div align=\"left\" style=\"font-size:20px;\" class=\"text-danger\">\n"+
										"<label>Answers</label>\n"+
										"<br>\n"+
									"</div>\n"+
									"<div class=\"options\">\n");
										out.println("<div class=\"form-group\">\n"+      
											"1)&nbsp;<input type=\"radio\" name=\"userradio\" value=\"option1\"class=\"form-cntrol\">\n"+rs.getString(2)+
										"</div>\n"+
										"<br>\n"+
										"<div class=\"form-group\">\n"+      
											"2)&nbsp;<input type=\"radio\" name=\"userradio\" value=\"option2\" class=\"form-cntrol\">\n"+rs.getString(3)+
										"</div>\n"+
										"<br>\n"+
										"<div class=\"form-group\">\n"+      
							         		"3)&nbsp;<input type=\"radio\" name=\"userradio\" value=\"option3\" class=\"form-cntrol\">\n"+rs.getString(4)+
							         	"</div>\n"+
							         	"<br>\n"+
							         	"<div class=\"form-group\">\n"+      
							         		"4)&nbsp;<input type=\"radio\" name=\"userradio\" value=\"option4\" class=\"form-cntrol\">\n"+rs.getString(5)+
							         	"</div>\n"+
							         	"<br>\n"+
							        "</div>\n"+
							      "<div  class=\"input-group\">\n"+
							       	"<button type=\"submit\" class=\"btn btn-success\">Submit</button>\n"+
							       	"&nbsp;   <a class=\"btn btn-primary btn-success nextButton\"><span class=\"glyphicon glyphicon-circle-arrow-right\"></span> Next</a>\n"+
							      "</div>\n"+
							   "</div>"+
							"</div>\n"+
							   "</form>");
						value++;
				}
				out.println("<script>document.getElementById('question1').style='display:block';</script>");
				
				stmt.close();
				conn.close();
				rs.close();
			} catch(Exception e){
				out.println(e);
			}
			
			out.println("</body>");
			out.println("</html>");
		}
	
				
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
