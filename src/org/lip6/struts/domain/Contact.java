package org.lip6.struts.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

//Bean de nos Contacts
public class Contact implements Serializable {

	private static final long serialVersionUID = 58409687792501803L;
	
	private String error;

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private List<Address> address;
	private List<PhoneNumber> phone;
	private List<ContactGroup> group;

	public Contact(long id, String firstName, String lastName, String email, List<Address> address, List<PhoneNumber> phone,
			List<ContactGroup> group) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.group = group;
	}
	
	public Contact() {}

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
	public List<Address> getAddress() {
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
	 * @return Error
	 */
	public String getError() {
		return error;
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
	public void setAddress(List<Address> address) {
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
	
	/**
	 * @param string
	 *            Sets errors
	 */
	public void setError(String string) {
		error = string;
	}

	@Override
	public String toString() {
		return "Contact [error=" + error + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", address=" + address + ", phone=" + phone + ", group=" + group + "]";
	}
}
