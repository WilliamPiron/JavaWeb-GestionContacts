package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

			// On regarde si l'id du groupe existe déjà
			final PreparedStatement lPreparedStatementGoupId =

					lConnection.prepareStatement("SELECT GROUPID FROM contactgroup WHERE GROUPID = ?");

			lPreparedStatementGoupId.setLong(1, id);
			ResultSet rsGroupID = lPreparedStatementGoupId.executeQuery();

			if (rsGroupID.next()) {
				return "L'id du groupe existe déjà !";
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

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			PreparedStatement lPreparedStatementGetGroupId =

					lConnection.prepareStatement("SELECT GROUPID FROM contactgroup WHERE GROUPNAME = ?");

			lPreparedStatementGetGroupId.setString(1, groupName);
			ResultSet rsGroup = lPreparedStatementGetGroupId.executeQuery();

			int idGroup = 0;
			while (rsGroup.next()) {
				idGroup = rsGroup.getInt("GROUPID");
			}

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

	public DisplayGroups displayAllGroups() {

		System.out.println("Entre dans affichage tous les groups DAO");

		Connection lConnection = null;
		final DisplayGroups display = new DisplayGroups();

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			final List<ContactGroup> groups = new LinkedList<ContactGroup>();

			final PreparedStatement lPreparedStatementGroups =

					lConnection.prepareStatement("SELECT GROUPID, GROUPNAME FROM contactgroup");

			ResultSet rsGroup = lPreparedStatementGroups.executeQuery();

			while (rsGroup.next()) {
				final Long id = rsGroup.getLong("GROUPID");
				final String groupName = rsGroup.getString("GROUPNAME");

				groups.add(new ContactGroup(id, groupName));
			}

			display.setGroups(groups);

		} catch (NamingException e) {

			System.out.println(e.getMessage());
			display.setError("NamingException : " + e.getMessage());

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			display.setError("SQLException : " + e.getMessage());

		} finally {
			try {
				if (lConnection != null)
					lConnection.close();
			} catch (SQLException e) {
				display.setError("Erreur : " + e.getMessage());
			}
		}
		return display;
	}

	public DisplayGroups displayGroup(final int id) {

		Connection lConnection = null;
		final DisplayGroups display = new DisplayGroups();

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			final List<ContactGroup> groups = new LinkedList<ContactGroup>();

			final PreparedStatement lPreparedStatementGroups =

					lConnection.prepareStatement("SELECT GROUPNAME FROM contactgroup WHERE GROUPID = ?");

			lPreparedStatementGroups.setInt(1, id);
			ResultSet rsGroup = lPreparedStatementGroups.executeQuery();

			while (rsGroup.next()) {
				final String groupName = rsGroup.getString("GROUPNAME");

				groups.add(new ContactGroup(id, groupName));
			}

			display.setGroups(groups);

		} catch (NamingException e) {

			System.out.println(e.getMessage());
			display.setError("NamingException : " + e.getMessage());

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			display.setError("SQLException : " + e.getMessage());

		} finally {
			try {
				if (lConnection != null)
					lConnection.close();
			} catch (SQLException e) {
				display.setError("Erreur : " + e.getMessage());
			}
		}
		return display;
	}

	public String destroyGroup(String groupName) {

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			PreparedStatement lPreparedStatementGetGroupId =

					lConnection.prepareStatement("SELECT GROUPID FROM contactgroup WHERE GROUPNAME = ?");

			lPreparedStatementGetGroupId.setString(1, groupName);
			ResultSet rsGroup = lPreparedStatementGetGroupId.executeQuery();

			int idGroup = 0;
			while (rsGroup.next()) {
				idGroup = rsGroup.getInt("GROUPID");
			}

			PreparedStatement lPreparedStatementGroup =

					lConnection.prepareStatement("DELETE FROM contactgroup WHERE GROUPID = ?");

			lPreparedStatementGroup.setInt(1, idGroup);
			lPreparedStatementGroup.executeUpdate();

			PreparedStatement lPreparedStatementGroupDeletion =

					lConnection.prepareStatement("DELETE FROM groupcomposition WHERE IDGROUP = ?");

			lPreparedStatementGroupDeletion.setInt(1, idGroup);
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

	public String updateGroup(final long id, final String groupName) {

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			// On regarde si le nom du groupe existe déjà
			final PreparedStatement lPreparedStatementGoupName =

					lConnection.prepareStatement("SELECT GROUPID FROM contactgroup WHERE GROUPNAME = ?");

			lPreparedStatementGoupName.setString(1, groupName);
			ResultSet rsGroup = lPreparedStatementGoupName.executeQuery();
			
			if (rsGroup.next()) {
				
				final int idGroup = rsGroup.getInt("GROUPID");
				if (idGroup != id) {
					return "Le nom du groupe existe déjà !";
				}
			}

			PreparedStatement lPreparedStatementUpdate =

					lConnection.prepareStatement("UPDATE contactgroup SET GROUPNAME=? WHERE GROUPID=?");

			lPreparedStatementUpdate.setString(1, groupName);
			lPreparedStatementUpdate.setLong(2, id);
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

	public List<ContactGroup> searchGroup(String word) {

		System.out.println("Entre dans search group DAO");

		Connection lConnection = null;

		final List<ContactGroup> contactGroup = new LinkedList<ContactGroup>();

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			word = word.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");

			final PreparedStatement lPreparedStatementGroup =

					lConnection.prepareStatement(
							"SELECT GROUPID, GROUPNAME FROM contactgroup WHERE GROUPID LIKE ? OR GROUPNAME LIKE ?");

			lPreparedStatementGroup.setString(1, "%" + word + "%");
			lPreparedStatementGroup.setString(2, "%" + word + "%");
			ResultSet rsGroup = lPreparedStatementGroup.executeQuery();

			while (rsGroup.next()) {

				final int id = rsGroup.getInt("GROUPID");
				final String groupName = rsGroup.getString("GROUPNAME");

				contactGroup.add(new ContactGroup(id, groupName));
			}

		} catch (NamingException e) {

			System.out.println(e.getMessage());
			contactGroup.add(new ContactGroup(0, "NamingException : " + e.getMessage()));

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			contactGroup.add(new ContactGroup(0, "SQLException : " + e.getMessage()));

		} finally {
			try {
				if (lConnection != null)
					lConnection.close();
			} catch (SQLException e) {
				contactGroup.add(new ContactGroup(0, "Erreur : " + e.getMessage()));
			}
		}
		return contactGroup;
	}
}
