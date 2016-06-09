package com.mmh.pkg;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("MyBank4/Login")
public class Login {

private String url = "jdbc:db2://192.86.32.54:5040/DALLASB:retrieveMessagesFromServerOnGetMessage=true;emulateParameterMetaDataForZCalls=1;";

	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			Connection connection = DriverManager.getConnection(url, "DTU22", "FAGP2016");
			Statement statement = connection.createStatement();
			  String username = request.getParameter("username");   
		        String password = request.getParameter("password");
		    	String url = "jdbc:db2://192.86.32.54:5040/DALLASB:retrieveMessagesFromServerOnGetMessage=true;emulateParameterMetaDataForZCalls=1;";
		        PreparedStatement pst = connection.prepareStatement
		        		("SELECT client_id, client_password FROM client WHERE client_id=? and client_password=?");
		        pst.setString(1, username);
		        pst.setString(2, password);
		        ResultSet rs = pst.executeQuery();   
		} catch (Exception e) {
			// TODO Automatisk genereret catch-blok
			e.printStackTrace();
			
		}
		request.getRequestDispatcher("Forside_Kunde.jsp").forward(request, response);
}
		
}
