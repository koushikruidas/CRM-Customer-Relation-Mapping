package com.koushik.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set up connection variables
		String user= "customer-relation-mapping";
		String pass= "koushikRuidas";
		String jdbcUrl= "jdbc:mysql://127.0.0.1:3306/web_customer_tracker";
		String driver= "com.mysql.cj.jdbc.Driver";
		
		// get the connection
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting.. ");
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("Connected to the database..");
			Statement stmt = connection.createStatement();
			String query = "select * from customer";
			ResultSet rs = stmt.executeQuery(query);
			 while (rs.next()) {
			        String firstName = rs.getString("first_name");
			        String lastName = rs.getString("last_name");
			        String email = rs.getString("email");
			        int id = rs.getInt("id");
			        System.out.println(id + ", " + firstName + ", " + lastName +
			                           ", " + email);
			      }
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

