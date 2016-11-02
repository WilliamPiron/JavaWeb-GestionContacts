package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOGroup {

	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/gestioncontacts";

	public String addGroup(final long id, final String name) {

		System.out.println("Entre dans group DAO");

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();
			
			// On regarde si le nom du groupe existe déjà
			final PreparedStatement lPreparedStatementGoupName =

					lConnection.prepareStatement("SELECT GROUPNAME FROM contactgroup WHERE GROUPNAME = ?");

			lPreparedStatementGoupName.setString(1, name);
			ResultSet rsGroup = lPreparedStatementGoupName.executeQuery();
			
			if (rsGroup.next()) {
				return "Le nom du groupe existe déjà !";
			}

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
		} finally {
			try {
				if (lConnection != null)
					lConnection.close();
			} catch (SQLException e) {
				return "Erreur : " + e.getMessage();
			}
		}
	}

	public String addGroupContact(long idContact, long idGroup) {

		System.out.println("Entre dans group contact DAO");

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

			PreparedStatement lPreparedStatementGroupExist =

					lConnection.prepareStatement("SELECT GROUPID FROM contactgroup WHERE groupId=?");

			lPreparedStatementGroupExist.setLong(1, idGroup);
			ResultSet rsGroup = lPreparedStatementGroupExist.executeQuery();

			if (!rsGroup.next()) {
				return "L'id du groupe n'existe pas !";
			}

			PreparedStatement lPreparedStatementGroupCreation =

					lConnection.prepareStatement("INSERT INTO GROUPCOMPOSITION (IDCONTACT, IDGROUP) VALUES(?, ?)");

			lPreparedStatementGroupCreation.setLong(1, idContact);
			lPreparedStatementGroupCreation.setLong(2, idGroup);
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

	public String deleteGroup(int id, String groupName) {

		System.out.println("Entre dans group delete : " + id + " : " + groupName);

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			System.out.println(11111);

			PreparedStatement lPreparedStatementGetGroupId =

					lConnection.prepareStatement("SELECT GROUPID FROM contactgroup WHERE GROUPNAME = ?");

			lPreparedStatementGetGroupId.setString(1, groupName);
			ResultSet rsGroup = lPreparedStatementGetGroupId.executeQuery();

			int idGroup = 0;
			while (rsGroup.next()) {
				idGroup = rsGroup.getInt("GROUPID");
			}

			System.out.println("Id contact : " + id + " Id groupe : " + idGroup);

			PreparedStatement lPreparedStatementGroupDeletion =

					lConnection.prepareStatement("DELETE FROM groupcomposition WHERE IDCONTACT = ? AND IDGROUP = ?");

			lPreparedStatementGroupDeletion.setInt(1, id);
			lPreparedStatementGroupDeletion.setInt(2, idGroup);
			lPreparedStatementGroupDeletion.executeUpdate();

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
