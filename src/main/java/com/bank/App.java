package com.bank;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class App extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String in = req.getParameter("submitButton");
		if ("Accountant Login".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(req, resp);
		} else if ("User Login".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
			rd.forward(req, resp);
		}
	}
}
