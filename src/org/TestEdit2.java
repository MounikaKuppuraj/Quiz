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
 * Servlet implementation class TestEdit2
 */
@WebServlet("/EditTest2")
public class TestEdit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestEdit2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try(PrintWriter out = response.getWriter()) {
			String TestName = request.getParameter("TestName");
			String NoOfQuestion = request.getParameter("NoOfQuestions");
			String TestDuration = request.getParameter("Duration");
			String StartDate = request.getParameter("StartingDate");
			String EndDate = request.getParameter("EndingDate");
			String TestCode = request.getParameter("TestCode");
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt =   conn.createStatement();
				stmt.executeUpdate("update test set Noofquestion='"+NoOfQuestion+"',Testduration='"+TestDuration+"',Startdate='"+StartDate+"',Enddate='"+EndDate+"',Testcode='"+TestCode+"' where Testname='"+TestName+"'");
				stmt.close();
				conn.close();
			} catch(Exception e){
				System.out.println(e);
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
