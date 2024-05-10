package com.bank.entity;

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

import com.bank.dao.UserLoginServlet;
import com.bank.databaseconn.ConnectDatabase;


@WebServlet("/transfer")
public class SendMoneyServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long recAccNo = Long.parseLong(req.getParameter("accNo"));
		double amount = Double.parseDouble(req.getParameter("money"));
		
		try {
			Connection con = ConnectDatabase.connectDB();
			PreparedStatement ps = con.prepareStatement("select balance from Account where account_no = ?");
			ps.setLong(1, UserLoginServlet.accNo);

			ResultSet r = ps.executeQuery();
			r.next();
			double availBal = r.getDouble(1);
			if (availBal >= amount) {
				PreparedStatement p = con.prepareStatement("update Account set balance = ? where account_no =?");
				p.setDouble(1, availBal - amount);
				p.setLong(2, UserLoginServlet.accNo);
				p.execute();
				resp.getWriter().print("<h1 style="+"color:red;"+">Money Sent</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("Blank.jsp");
				rd.include(req, resp);
			} else {
				resp.getWriter().print("<h1 style="+"color:red;"+">Insufficient Balance</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("Blank.jsp");
				rd.include(req, resp);
			}	
			PreparedStatement ps2 = con.prepareStatement("select balance from Account where account_no = ?");
			ps2.setLong(1, recAccNo);

			ResultSet r2 = ps2.executeQuery();
			r2.next();
			double availBal2 = r2.getDouble(1);

			PreparedStatement p = con.prepareStatement("update Account set balance = ? where account_no =?");
			p.setDouble(1, availBal2 + amount);
			p.setLong(2, recAccNo);
			p.execute();
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
