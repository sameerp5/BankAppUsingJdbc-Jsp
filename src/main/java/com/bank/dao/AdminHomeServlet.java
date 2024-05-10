package com.bank.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminhome")
public class AdminHomeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String in = req.getParameter("adminAction");
		
		if ("Add Account".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("Add.jsp");
			rd.forward(req, resp);
		} 
		else if ("View Account By Account Number".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("ViewAcc.jsp");
			rd.forward(req, resp);
		}
		else if ("View All Accounts".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("ViewAllAcc.jsp");
			rd.forward(req, resp);
		}
		else if ("Logout".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
	}
}
