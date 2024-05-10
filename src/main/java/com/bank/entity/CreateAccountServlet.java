package com.bank.entity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.databaseconn.ConnectDatabase;

@WebServlet("/add")
public class CreateAccountServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long phone= Long.parseLong(req.getParameter("phone"));
		double balance = Double.parseDouble(req.getParameter("balance"));
		int pin = Integer.parseInt(req.getParameter("pin"));
		
		try {
			Connection con =ConnectDatabase.connectDB();
			PreparedStatement ps = con.prepareStatement("insert into Account value(?,?,?,?,?,?)");
			ps.setInt(1, getId());
			ps.setLong(2, getAccount());
			ps.setInt(3, pin);
			ps.setString(4, name);
			ps.setDouble(5, balance);
			ps.setLong(6, phone);
			ps.execute();
			
			RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static int getId() throws Exception {
		Connection con = ConnectDatabase.connectDB();
		Statement s = con.createStatement();
		ResultSet r = s.executeQuery("select * from account");
		int c = 0;
		while (r.next())
			c++;
		return c + 1;
	}
	private static long getAccount() throws Exception {
		String s = "";
		for (int i = 0; i < 12; i++) {
			s += (int) (Math.random() * 9) + 1;
		}
		long l = Long.parseLong(s);
		Connection con = ConnectDatabase.connectDB();
		PreparedStatement ps = con.prepareStatement("select * from Account where account_no =?");
		ps.setLong(1, l);
		ResultSet r = ps.executeQuery();
		if (r.next())
			return getAccount();
		else
			return l;
	}

}
