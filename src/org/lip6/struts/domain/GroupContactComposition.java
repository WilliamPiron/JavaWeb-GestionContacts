package org.lip6.struts.domain;

import java.io.Serializable;
import java.util.List;

public class GroupContactComposition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String error;
	private List<Contact> contacts;
	private List<ContactGroup> groups;
	
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
	 * @return Liste Group
	 */
	public List<ContactGroup> getGroups() {
		return groups;
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
	
	/**
	 * @param string
	 *            sets the Groups
	 */
	public void setGroups(List<ContactGroup> list) {
		groups = list;
	}
}
