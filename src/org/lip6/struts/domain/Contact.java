package org.lip6.struts.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

//Bean de nos Contacts
public class Contact implements Serializable {

	private static final long serialVersionUID = 58409687792501803L;

	private long id;
	private String firstName;
	private String lastName;
	private String email;

	private Address address;
	private List<PhoneNumber> phone;
	private List<ContactGroup> group;

	public Contact(long id, String firstName, String lastName, String email, Address address, List<PhoneNumber> phone,
			List<ContactGroup> group) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.group = group;
	}

	/**
	 * @return ID Returns ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return Last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return First Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return Address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @return Phone list
	 */
	public List<PhoneNumber> getPhone() {
		return phone;
	}

	/**
	 * @return Group list
	 */
	public List<ContactGroup> getGroup() {
		return group;
	}

	/**
	 * @param l
	 *            Sets the ID
	 */
	public void setId(long l) {
		id = l;
	}

	/**
	 * @param string
	 *            sets the Last Name
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param string
	 *            Sets the First Name
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 *            Sets the Email
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string
	 *            Sets the Address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @param string
	 *            Sets the Phones
	 */
	public void setPhone(LinkedList<PhoneNumber> phone) {
		this.phone = phone;
	}

	/**
	 * @param string
	 *            Sets the Phones
	 */
	public void setGroup(LinkedList<ContactGroup> group) {
		this.group = group;
	}
}
