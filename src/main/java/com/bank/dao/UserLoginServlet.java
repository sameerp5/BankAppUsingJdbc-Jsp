package com.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.databaseconn.ConnectDatabase;


@WebServlet("/user")
public class UserLoginServlet extends HttpServlet {
	public static long accNo;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 accNo = Long.parseLong(req.getParameter("accNo"));
		int pin = Integer.parseInt(req.getParameter("pin"));
		
		try {
			Connection con = ConnectDatabase.connectDB();
			PreparedStatement ps = con.prepareStatement("select * from Account where account_no = ? and pincode = ?");
			ps.setLong(1, accNo);
			ps.setInt(2, pin);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp");
				rd.forward(req, resp);
			}
			else {
				resp.getWriter().print("<h1 style="+"color:red;"+">Invalid Credentials</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
