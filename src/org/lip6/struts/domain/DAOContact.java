package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOContact {

	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/gestioncontacts";

	public String addContact(final long id, final String firstName, final String lastName, final String email,
			final long idAddress, final String street, final String city, final String zip, final String country,
			final long idPhone, final String phoneKind, final String phoneNumber, final long numSiret,
			final long idGroup, final String groupName) {

		System.out.println("Entre dans contact DAO !");
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
			PreparedStatement lPreparedStatementAddressCreation =

					lConnection.prepareStatement(
							"INSERT INTO ADDRESS(ID, STREET, CITY, ZIP, COUNTRY) VALUES(?, ?, ?, ?, ?)");

			lPreparedStatementAddressCreation.setLong(1, idAddress);
			lPreparedStatementAddressCreation.setString(2, street);
			lPreparedStatementAddressCreation.setString(3, city);
			lPreparedStatementAddressCreation.setString(4, zip);
			lPreparedStatementAddressCreation.setString(5, country);
			lPreparedStatementAddressCreation.executeUpdate();

			// Phone
			PreparedStatement lPreparedStatementPhoneCreation =

					lConnection.prepareStatement("INSERT INTO PHONENUMBER(ID, PHONEKIND, PHONENUMBER) VALUES(?, ?, ?)");

			lPreparedStatementPhoneCreation.setLong(1, idPhone);
			lPreparedStatementPhoneCreation.setString(2, phoneKind);
			lPreparedStatementPhoneCreation.setString(3, phoneNumber);
			lPreparedStatementPhoneCreation.executeUpdate();

			// Company
			PreparedStatement lPreparedStatementCompanyCreation =

					lConnection.prepareStatement("INSERT INTO ENTREPRISE(NUMSIRET) VALUES(?)");

			lPreparedStatementCompanyCreation.setLong(1, numSiret);
			lPreparedStatementCompanyCreation.executeUpdate();

			// Group
			PreparedStatement lPreparedStatementGroupCreation =

					lConnection.prepareStatement("INSERT INTO CONTACTGROUP(GROUPID, GROUPNAME) VALUES(?, ?)");

			lPreparedStatementGroupCreation.setLong(1, idGroup);
			lPreparedStatementGroupCreation.setString(2, groupName);
			lPreparedStatementGroupCreation.executeUpdate();

			return null;
		} catch (NamingException e) {

			return "NamingException : " + e.getMessage();

		} catch (SQLException e) {

			return "SQLException : " + e.getMessage();

		}
	}
}
