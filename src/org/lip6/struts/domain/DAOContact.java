package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOContact {

	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/gestioncontacts";

	public String addContact(final long id, final String firstName, final String lastName, final String email) {
		
		System.out.println("Entre dans contact DAO !");
		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();

			// adding a new contact
			final PreparedStatement lPreparedStatementCreation =

					lConnection.prepareStatement(
							"INSERT INTO CONTACT(ID, LASTNAME, FIRSTNAME, EMAIL) VALUES(?, ?, ?, ?)");

			lPreparedStatementCreation.setLong(1, id);
			lPreparedStatementCreation.setString(2, lastName);
			lPreparedStatementCreation.setString(3, firstName);
			lPreparedStatementCreation.setString(4, email);
			lPreparedStatementCreation.executeUpdate();

			return null;
		} catch (NamingException e) {

			return "NamingException : " + e.getMessage();

		} catch (SQLException e) {

			return "SQLException : " + e.getMessage();

		}
	}
}
