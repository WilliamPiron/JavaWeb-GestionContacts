package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOGroup {
	
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/gestioncontacts";

	public String addGroup(final long id, final String name) {

		System.out.println("Entre dans group DAO");

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();

			PreparedStatement lPreparedStatementGroupCreation =

					lConnection.prepareStatement("INSERT INTO CONTACTGROUP(GROUPID, GROUPNAME) VALUES(?, ?)");

			lPreparedStatementGroupCreation.setLong(1, id);
			lPreparedStatementGroupCreation.setString(2, name);
			lPreparedStatementGroupCreation.executeUpdate();

			return null;
		} catch (NamingException e) {

			return "NamingException : " + e.getMessage();

		} catch (SQLException e) {

			return "SQLException : " + e.getMessage();

		}
	}
}
