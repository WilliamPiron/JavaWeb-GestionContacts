package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOPhone {
	
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/gestioncontacts";
	
	public String addPhone(long idContact, String phoneNumber, String phoneKind) {

		System.out.println("Entre dans phone dao");

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			PreparedStatement lPreparedStatementContactExist =

					lConnection.prepareStatement("SELECT ID FROM contact WHERE id=?");

			lPreparedStatementContactExist.setLong(1, idContact);
			ResultSet rsContact = lPreparedStatementContactExist.executeQuery();

			if (!rsContact.next()) {
				return "L'id du contact n'existe pas !";
			}

			PreparedStatement lPreparedStatementGroupCreation =

					lConnection.prepareStatement("INSERT INTO PHONENUMBER (IDCONTACT, PHONEKIND, PHONENUMBER) VALUES(?, ?, ?)");

			lPreparedStatementGroupCreation.setLong(1, idContact);
			lPreparedStatementGroupCreation.setString(2, phoneKind);
			lPreparedStatementGroupCreation.setString(3, phoneNumber);
			lPreparedStatementGroupCreation.executeUpdate();

			return null;

		} catch (NamingException e) {

			return "NamingException : " + e.getMessage();

		} catch (SQLException e) {

			return "SQLException : " + e.getMessage();
		} finally {
			try {
				if (lConnection != null)
					lConnection.close();
			} catch (SQLException e) {
				return "Erreur : " + e.getMessage();
			}
		}
	}

}
