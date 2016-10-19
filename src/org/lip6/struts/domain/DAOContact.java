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
			final long idAddress, final String street, final String city, final String zip, final String country,
			final long idPhone, final String phoneKind, final String phoneNumber) {

		System.out.println("Entre dans creation contact DAO");

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();

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

			// Phone
			if (!phoneKind.isEmpty()) {
				PreparedStatement lPreparedStatementPhoneCreation =

						lConnection.prepareStatement(
								"INSERT INTO PHONENUMBER(ID, PHONEKIND, PHONENUMBER) VALUES(?, ?, ?)");

				lPreparedStatementPhoneCreation.setLong(1, idPhone);
				lPreparedStatementPhoneCreation.setString(2, phoneKind);
				lPreparedStatementPhoneCreation.setString(3, phoneNumber);
				lPreparedStatementPhoneCreation.executeUpdate();
			}
			
			return null;
		} catch (NamingException e) {

			return "NamingException : " + e.getMessage();

		} catch (SQLException e) {

			return "SQLException : " + e.getMessage();

		}
	}
	
	public List<Contact> displayContacts() {

		System.out.println("Entre dans affichage contact DAO");
		final List<Contact> lListeContact = new LinkedList<Contact>();

		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();

			final PreparedStatement lPreparedStatementCreation =

					lConnection
							.prepareStatement("SELECT ID, LASTNAME, FIRSTNAME, EMAIL FROM contact");
			
			ResultSet rs = lPreparedStatementCreation.executeQuery();
			
			while(rs.next()) {
				final Long id = rs.getLong("ID");
				final String lastName = rs.getString("LASTNAME");
				final String firstName = rs.getString("FIRSTNAME");
				final String email = rs.getString("EMAIL");
				
				System.out.println(id + " " + lastName + " " + firstName + " " + email);
				
				final Contact contact = new Contact(id, lastName, firstName, email, null, null, null);
				lListeContact.add(contact);
			}
			
			return null;
		} catch (NamingException e) {

			System.out.println(e.getMessage());
			//return "NamingException : " + e.getMessage();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			//return "SQLException : " + e.getMessage();

		}
		return lListeContact;
	}
}
