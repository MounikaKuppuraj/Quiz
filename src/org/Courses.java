package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Courses
 */
@WebServlet("/Courses")
public class Courses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Courses() {
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
			try{
				 int i=0;

				 DateFormat df = new SimpleDateFormat("dd/MM/yy");
			       Date dateobj = new Date();
			       System.out.println(df.format(dateobj));

				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from test");
			
				out.println("<div style='width:1024px; margin:40px 80px auto;'>\n"+
						"<div align=\"center\" style=\"font-size:20px;\" class=\"text-danger\">\n"+
				"<div>\n"+
				"<label>Take Test</label>\n"+
				"</div>\n"+
				"</div>\n"+
				"<div style='width:1224px; margin:40px 80px auto;'>\n"+
				"<table class='table table-striped'>\n"+
				"<tr>\n"+
				"<th>S.No</th>\n"+
				"<th>Subject Name</th>\n"+
				"<th>Exam Date</th>\n"+
				"<th>Duration</th>\n"+
				"<th>Total Questions</th>\n"+
				"<th>Test Code</th>\n"+
				"<th>Action</th>\n"+
				"<tr>\n"+
				"</div>\n"
				
				);
				while(rs.next())
					out.println("<tr><td>"+(++i)+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(6)+"</td>"+
							/*"if(!df.format(dateobj).equals(rs.getString(4)))\n"+
							"{\n"+
							"<td>\n"+
							"<td class=\"text-danger\" style=\"font-weight:bold\" id=\"days\"></td>\n"+
							"<td class=\"text-danger\" style=\"font-weight:bold\" id=\"hours\"></td>\n"+
							"<td class=\"text-danger\"style=\"font-weight:bold\" id=\"minutes\"></td>\n"+
							"<td class=\"text-danger\" style=\"font-weight:bold\" id=\"seconds\"></td>\n"+
							"</td>\n"+
							
			               "}\n"+
							"else\n"+
							"{\n"+*/
								"<td><a href=\"Attend\"><span style=\"font-weight:bold\" class=\"glyphicon glyphicon-ok\"></span>Attend</a></td>\n"+
							//"}\n"+
							 "</tr>");
							
				out.println("</table>");
				out.println("</div>");
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e){
				out.println(e);
			}
			/*out.println(
					"<script type=\"text/javascript\">"+
					"function countdown()\n"+
					"{\n"+
					"var now=new Date();\n"+
					"var eventDate=new Date(2017,4,14);\n"+
					"var currentTime=now.getTime();\n"+
					"var eventTime=eventDate.getTime();\n"+
					"var remTime=eventTime-currentTime;\n"+
					"var s=Math.floor(remTime/1000);\n"+
					"var m=Math.floor(s/60);\n"+
					"var h=Math.floor(m/60);\n"+
					"var d=Math.floor(h/24);\n"+
					"h%=24;\n"+
					"m%=60;\n"+
					"s%=60;\n"+
					"h=(h<10)?\"0\"+h:h;\n"+
					"m=(m<10)?\"0\"+m:m;\n"+
					"s=(s<10)?\"0\"+s:s;\n"+
					"document.getElementById(\"days\").textContent=d;\n"+
					"document.getElementById(\"days\").innerText=d;\n"+
					"document.getElementById(\"hours\").textContent=h;\n"+
					"document.getElementById(\"minutes\").textContent=m;\n"+
					"document.getElementById(\"seconds\").textContent=s;\n"+
					"setTimeout(countdown,1000);\n"+
					"}\n"+
					"countdown();\n"+
					"</script>\n");*/
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
