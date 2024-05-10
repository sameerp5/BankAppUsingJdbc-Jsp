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

@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pswd");
		
		try {
			Connection con = ConnectDatabase.connectDB();
			PreparedStatement ps = con.prepareStatement("select * from Admin where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("AdminHome.jsp");
				rd.forward(req, resp);
			}
			else {
				resp.getWriter().print("<h1 style="+"color:red;"+">Invalid Credentials</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.jsp");
				rd.include(req, resp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
