package com.bank.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userhome")
public class UserHomeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String in = req.getParameter("userAction");
		
		if ("Deposit Money".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("Deposit.jsp");
			rd.forward(req, resp);
		} 
		else if ("Send Money".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("Send.jsp");
			rd.forward(req, resp);
		}
		else if ("Withdraw Money".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("Withdraw.jsp");
			rd.forward(req, resp);
		}
		else if ("Update Profile".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
		}
		else if ("Logout".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
	}
}
