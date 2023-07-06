package com.hodowla.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class DbTest
 */
@WebServlet("/DbTest")
public class DbTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "hodowlapajakow";
		String pass = "Hodowlapajakow2";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hodowla_pajakow?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Laczenie do bazy: " + jdbcUrl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("Pomyslne polaczenie sie!");
			myConn.close();
		}
		catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	}
}
