package com.bank.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String in = req.getParameter("updateUser");

		if ("Update Phone Number".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("UpdatePhone.jsp");
			rd.forward(req, resp);
		} else if ("Update Pin-Code".equals(in)) {
			RequestDispatcher rd = req.getRequestDispatcher("UpdatePin.jsp");
			rd.forward(req, resp);
		}

	}
}
