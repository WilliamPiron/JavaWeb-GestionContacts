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

			//On regarde si le numéro existe déjà
			PreparedStatement lPreparedStatementPhoneExist =

					lConnection.prepareStatement("SELECT PHONEKIND FROM phonenumber WHERE PHONENUMBER = ?");

			lPreparedStatementPhoneExist.setString(1, phoneNumber);
			ResultSet rsPhone = lPreparedStatementPhoneExist.executeQuery();

			if (rsPhone.next()) {
				return "Le numéro existe déjà !";
			}

			PreparedStatement lPreparedStatementGroupCreation =

					lConnection.prepareStatement(
							"INSERT INTO PHONENUMBER (IDCONTACT, PHONEKIND, PHONENUMBER) VALUES(?, ?, ?)");

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

	public String deletePhone(String phoneNumber) {

		System.out.println("Entre dans phone delete");

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			PreparedStatement lPreparedStatementPhoneDeletion =

					lConnection.prepareStatement("DELETE FROM phonenumber WHERE PHONENUMBER = ?");

			lPreparedStatementPhoneDeletion.setString(1, phoneNumber);
			lPreparedStatementPhoneDeletion.executeUpdate();

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
	
	public String updatePhone(final long idPhone, final String phoneKind, final String phoneNumber) {

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();
			
			//On regarde si le numéro existe déjà
			PreparedStatement lPreparedStatementPhoneExist =

					lConnection.prepareStatement("SELECT PHONEKIND FROM phonenumber WHERE PHONENUMBER = ?");

			lPreparedStatementPhoneExist.setString(1, phoneNumber);
			ResultSet rsPhone = lPreparedStatementPhoneExist.executeQuery();

			if (rsPhone.next()) {
				return "Le numéro existe déjà !";
			}

			PreparedStatement lPreparedStatementUpdate =

					lConnection.prepareStatement("UPDATE phonenumber SET PHONEKIND=?, PHONENUMBER=? WHERE id=?");

			lPreparedStatementUpdate.setString(1, phoneKind);
			lPreparedStatementUpdate.setString(2, phoneNumber);
			lPreparedStatementUpdate.setLong(3, idPhone);
			lPreparedStatementUpdate.executeUpdate();
			
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
	
	public PhoneNumber getPhone(int idPhone) {

		System.out.println("Entre dans get phone dao");

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			PreparedStatement lPreparedStatementGetPhone =

					lConnection.prepareStatement("SELECT IDCONTACT, PHONEKIND, PHONENUMBER FROM phonenumber WHERE id=?");

			lPreparedStatementGetPhone.setLong(1, idPhone);
			ResultSet rsPhone = lPreparedStatementGetPhone.executeQuery();

			
			while(rsPhone.next()) {
				
				final int idContact = rsPhone.getInt("IDCONTACT");
				final String phoneKind = rsPhone.getString("PHONEKIND");
				final String phoneNumber = rsPhone.getString("PHONENUMBER");
				
				return (new PhoneNumber(idPhone, idContact, phoneKind, phoneNumber, null));
			}
			
			return (new PhoneNumber(0, 0, null, null, "Id du téléphone introuvable !"));
			
		} catch (NamingException e) {

			return (new PhoneNumber(0, 0, null, null, "NamingException : " + e.getMessage()));

		} catch (SQLException e) {

			return (new PhoneNumber(0, 0, null, null, "SQLException : " + e.getMessage()));
		} finally {
			try {
				if (lConnection != null)
					lConnection.close();
			} catch (SQLException e) {
				
				return (new PhoneNumber(0, 0, null, null, "Erreur : " + e.getMessage()));
			}
		}
	}
}
