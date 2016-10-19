package org.lip6.struts.domain;

import java.io.Serializable;
import java.util.List;

public class DisplayContact implements Serializable {
	
	private static final long serialVersionUID = 1050432583446929484L;
	
	private String error;
	private List<Contact> contacts;

	/**
	 * @return Error
	 */
	public String getError() {
		return error;
	}
	
	/**
	 * @return Liste Contact
	 */
	public List<Contact> getContacts() {
		return contacts;
	}
	
	/**
	 * @param string
	 *            sets error
	 */
	public void setError(String string) {
		error = string;
	}
	
	/**
	 * @param string
	 *            sets the Contacts
	 */
	public void setContacts(List<Contact> list) {
		contacts = list;
	}
}
