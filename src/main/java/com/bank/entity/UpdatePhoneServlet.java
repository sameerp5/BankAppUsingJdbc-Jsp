package com.bank.entity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.UserLoginServlet;
import com.bank.databaseconn.ConnectDatabase;

@WebServlet("/updph")
public class UpdatePhoneServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long phone = Long.parseLong(req.getParameter("phone"));
		try {
			Connection con= ConnectDatabase.connectDB();
			PreparedStatement ps = con.prepareStatement("update Account set phone_no = ? where account_no = ?");
			ps.setLong(1, phone);
			ps.setLong(2, UserLoginServlet.accNo);
			ps.execute();
			resp.getWriter().print("<h1 style="+"color:red;"+">Phone Number Updated</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("Blank.jsp");
			rd.include(req, resp);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}