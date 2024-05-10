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

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long accNo= Long.parseLong(req.getParameter("accNo"));
		Connection con;
		try {
			con = ConnectDatabase.connectDB();
			PreparedStatement ps = con.prepareStatement("select * from Account where account_no =?");
			ps.setLong(1, accNo);
			ResultSet rs = ps.executeQuery();
			
			req.setAttribute("res", rs);
			
			RequestDispatcher rd = req.getRequestDispatcher("ViewAcc2.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			
		}
		
	}
}
