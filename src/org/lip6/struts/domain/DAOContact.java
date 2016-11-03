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

public class DAOContact {

	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/gestioncontacts";

	public String addContact(final long id, final String firstName, final String lastName, final String email,
			final long idAddress, final String street, final String city, final String zip, final String country) {

		System.out.println("Entre dans creation contact DAO");

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			// On regarde si la combinaison email/nom existe
			final PreparedStatement lPreparedStatementContact =

					lConnection.prepareStatement("SELECT ID FROM contact WHERE LASTNAME = ? AND EMAIL = ?");

			lPreparedStatementContact.setString(1, lastName);
			lPreparedStatementContact.setString(2, email);

			ResultSet rsContact = lPreparedStatementContact.executeQuery();
			if (rsContact.next()) {
				return "La combinaison email/nom existe déjà !";
			}

			// Contact
			final PreparedStatement lPreparedStatementCreation =

					lConnection
							.prepareStatement("INSERT INTO CONTACT(ID, LASTNAME, FIRSTNAME, EMAIL) VALUES(?, ?, ?, ?)");

			lPreparedStatementCreation.setLong(1, id);
			lPreparedStatementCreation.setString(2, lastName);
			lPreparedStatementCreation.setString(3, firstName);
			lPreparedStatementCreation.setString(4, email);
			lPreparedStatementCreation.executeUpdate();

			// Address

			// Si l'un des attributs est non vide cela veut dire que les autres
			// non plus, c'est pourquoi on ne vérifie que la rue
			if (!street.isEmpty()) {
				PreparedStatement lPreparedStatementAddressCreation =

						lConnection.prepareStatement(
								"INSERT INTO ADDRESS(ID, STREET, CITY, ZIP, COUNTRY) VALUES(?, ?, ?, ?, ?)");

				lPreparedStatementAddressCreation.setLong(1, idAddress);
				lPreparedStatementAddressCreation.setString(2, street);
				lPreparedStatementAddressCreation.setString(3, city);
				lPreparedStatementAddressCreation.setString(4, zip);
				lPreparedStatementAddressCreation.setString(5, country);
				lPreparedStatementAddressCreation.executeUpdate();
			}

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

	public DisplayAllContact displayAllContacts() {

		System.out.println("Entre dans affichage tous les contact DAO");

		Connection lConnection = null;
		final DisplayAllContact display = new DisplayAllContact();

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			final List<Contact> contacts = new LinkedList<Contact>();

			final PreparedStatement lPreparedStatementContact =

					lConnection.prepareStatement("SELECT ID, LASTNAME, FIRSTNAME, EMAIL FROM contact");

			ResultSet rsContact = lPreparedStatementContact.executeQuery();

			while (rsContact.next()) {
				final Long id = rsContact.getLong("ID");
				final String lastName = rsContact.getString("LASTNAME");
				final String firstName = rsContact.getString("FIRSTNAME");
				final String email = rsContact.getString("EMAIL");

				contacts.add(new Contact(id, lastName, firstName, email, null, null, null));
			}

			display.setContacts(contacts);

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

	public DisplayAllContact displayContact(int idContact) {

		System.out.println("Entre dans affichage contact DAO : " + idContact);

		Connection lConnection = null;
		final DisplayAllContact display = new DisplayAllContact();

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			final List<Contact> contacts = new LinkedList<Contact>();

			final PreparedStatement lPreparedStatementContact =

					lConnection.prepareStatement("SELECT ID, LASTNAME, FIRSTNAME, EMAIL FROM contact WHERE ID=?");

			lPreparedStatementContact.setLong(1, idContact);
			ResultSet rsContact = lPreparedStatementContact.executeQuery();

			while (rsContact.next()) {
				final int id = rsContact.getInt("ID");
				final String lastName = rsContact.getString("LASTNAME");
				final String firstName = rsContact.getString("FIRSTNAME");
				final String email = rsContact.getString("EMAIL");

				final List<Address> address = new LinkedList<Address>();

				final PreparedStatement lPreparedStatementAddress =

						lConnection.prepareStatement("SELECT STREET, CITY, ZIP, COUNTRY FROM address WHERE ID=?");

				lPreparedStatementAddress.setLong(1, idContact);
				ResultSet rsAddress = lPreparedStatementAddress.executeQuery();

				while (rsAddress.next()) {

					final String street = rsAddress.getString("STREET");
					final String city = rsAddress.getString("CITY");
					final String zip = rsAddress.getString("ZIP");
					final String country = rsAddress.getString("COUNTRY");

					address.add(new Address(id, street, city, zip, country));
				}

				final List<ContactGroup> groups = new LinkedList<ContactGroup>();

				final PreparedStatement lPreparedStatementGroup =

						lConnection.prepareStatement(
								"SELECT GROUPID, GROUPNAME FROM contactgroup INNER JOIN groupcomposition "
										+ "ON groupcomposition.IDGROUP = contactgroup.GROUPID AND groupcomposition.IDCONTACT = ?");

				lPreparedStatementGroup.setInt(1, id);

				ResultSet rsGroup = lPreparedStatementGroup.executeQuery();

				while (rsGroup.next()) {
					final Long groupId = rsGroup.getLong("GROUPID");
					final String groupName = rsGroup.getString("GROUPNAME");

					groups.add(new ContactGroup(groupId, groupName));
				}

				final List<PhoneNumber> phones = new LinkedList<PhoneNumber>();

				final PreparedStatement lPreparedStatementPhone =

						lConnection.prepareStatement(
								"SELECT ID, PHONEKIND, PHONENUMBER FROM PHONENUMBER WHERE IDCONTACT = ?");

				lPreparedStatementPhone.setInt(1, id);

				ResultSet rsPhone = lPreparedStatementPhone.executeQuery();

				while (rsPhone.next()) {
					final int idPhone = rsPhone.getInt("ID");
					final String phoneKind = rsPhone.getString("PHONEKIND");
					final String phoneNumber = rsPhone.getString("PHONENUMBER");

					phones.add(new PhoneNumber(idPhone, id, phoneKind, phoneNumber, null));
				}

				contacts.add(new Contact(id, firstName, lastName, email, address, phones, groups));
			}

			display.setContacts(contacts);

		} catch (

		NamingException e) {

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

	public String deleteContact(long id) {

		System.out.println("Entre dans deleteContact");

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			// deleting a contact
			PreparedStatement lPreparedStatementDeletion =

					lConnection.prepareStatement("DELETE FROM contact WHERE ID=?");

			lPreparedStatementDeletion.setLong(1, id);
			lPreparedStatementDeletion.executeUpdate();

			PreparedStatement lPreparedStatementDeletionComposition = lConnection
					.prepareStatement("DELETE FROM GROUPCOMPOSITION WHERE IDCONTACT=?");

			lPreparedStatementDeletionComposition.setLong(1, id);
			lPreparedStatementDeletionComposition.executeUpdate();

			PreparedStatement lPreparedStatementDeletionAddress = lConnection
					.prepareStatement("DELETE FROM ADDRESS WHERE ID=?");

			lPreparedStatementDeletionAddress.setLong(1, id);
			lPreparedStatementDeletionAddress.executeUpdate();

			PreparedStatement lPreparedStatementDeletionPhone = lConnection
					.prepareStatement("DELETE FROM PHONENUMBER WHERE IDCONTACT=?");

			lPreparedStatementDeletionPhone.setLong(1, id);
			lPreparedStatementDeletionPhone.executeUpdate();

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

	public String updateContact(final long id, final String lastName, final String firstName, final String email,
			final String street, final String city, final String zip, final String country) {

		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			PreparedStatement lPreparedStatementUpdate =

					lConnection.prepareStatement("UPDATE contact SET LASTNAME=?, FIRSTNAME=?, EMAIL=? WHERE id=?");

			lPreparedStatementUpdate.setString(1, lastName);
			lPreparedStatementUpdate.setString(2, firstName);
			lPreparedStatementUpdate.setString(3, email);
			lPreparedStatementUpdate.setLong(4, id);
			lPreparedStatementUpdate.executeUpdate();

			PreparedStatement lPreparedStatementAddressExist =

					lConnection.prepareStatement("SELECT * FROM address WHERE id=?");

			lPreparedStatementAddressExist.setLong(1, id);
			ResultSet rsAddress = lPreparedStatementAddressExist.executeQuery();

			if (!street.isEmpty() && rsAddress.next()) {
				PreparedStatement lPreparedStatementUpdateAddress =

						lConnection.prepareStatement(
								"UPDATE address SET address.ID=?, STREET=?, CITY=?, ZIP=?, COUNTRY=? WHERE id=?");

				lPreparedStatementUpdateAddress.setLong(1, id);
				lPreparedStatementUpdateAddress.setString(2, street);
				lPreparedStatementUpdateAddress.setString(3, city);
				lPreparedStatementUpdateAddress.setString(4, zip);
				lPreparedStatementUpdateAddress.setString(5, country);
				lPreparedStatementUpdateAddress.setLong(6, id);
				lPreparedStatementUpdateAddress.executeUpdate();
			} else if (!street.isEmpty() && !rsAddress.next()) {
				PreparedStatement lPreparedStatementUpdateAddress =

						lConnection.prepareStatement(
								"INSERT INTO ADDRESS(ID, STREET, CITY, ZIP, COUNTRY) VALUES(?, ?, ?, ?, ?)");

				lPreparedStatementUpdateAddress.setLong(1, id);
				lPreparedStatementUpdateAddress.setString(2, street);
				lPreparedStatementUpdateAddress.setString(3, city);
				lPreparedStatementUpdateAddress.setString(4, zip);
				lPreparedStatementUpdateAddress.setString(5, country);
				lPreparedStatementUpdateAddress.executeUpdate();
			} else {
				PreparedStatement lPreparedStatementDeletionAddress = lConnection
						.prepareStatement("DELETE FROM ADDRESS WHERE ID=?");

				lPreparedStatementDeletionAddress.setLong(1, id);
				lPreparedStatementDeletionAddress.executeUpdate();
			}

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

	public DisplayAllContact searchContact(String word) {

		System.out.println("Entre dans search contact DAO");

		final DisplayAllContact display = new DisplayAllContact();
		Connection lConnection = null;

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			lConnection = lDataSource.getConnection();

			final List<Contact> contacts = new LinkedList<Contact>();

			word = word.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");

			final PreparedStatement lPreparedStatementContact =

					lConnection.prepareStatement(
							"SELECT ID, LASTNAME, FIRSTNAME, EMAIL FROM contact WHERE ID LIKE ? OR LASTNAME LIKE ? OR FIRSTNAME LIKE ? OR EMAIL LIKE ?");

			lPreparedStatementContact.setString(1, "%" + word + "%");
			lPreparedStatementContact.setString(2, "%" + word + "%");
			lPreparedStatementContact.setString(3, "%" + word + "%");
			lPreparedStatementContact.setString(4, "%" + word + "%");
			ResultSet rsContact = lPreparedStatementContact.executeQuery();

			while (rsContact.next()) {

				final Long id = rsContact.getLong("ID");
				final String lastName = rsContact.getString("LASTNAME");
				final String firstName = rsContact.getString("FIRSTNAME");
				final String email = rsContact.getString("EMAIL");

				contacts.add(new Contact(id, lastName, firstName, email, null, null, null));
			}

			display.setContacts(contacts);

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
}
