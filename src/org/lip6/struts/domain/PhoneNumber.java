package org.lip6.struts.domain;

public class PhoneNumber {

	private long id;
	private long idContact;
	private String phoneKind;
	private String phoneNumber;
	
	public PhoneNumber(long id, long idContact, String phoneKind, String phoneNumber){
		this.id = id;
		this.idContact = idContact;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return ID Returns ID
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return ID Returns ID
	 */
	public long getIdContact() {
		return idContact;
	}

	/**
	 * @return Phone Kind
	 */
	public String getPhoneKind() {
		return phoneKind;
	}

	/**
	 * @return Phone Number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param l
	 *            Sets the ID
	 */
	public void setId(long l) {
		id = l;
	}
	
	/**
	 * @param l
	 *            Sets the ID
	 */
	public void setIdContact(long l) {
		idContact = l;
	}

	/**
	 * @param string
	 *            sets the Phone Kind
	 */
	public void setPhoneKind(String string) {
		phoneKind = string;
	}

	/**
	 * @param string
	 *            sets the Phone Number
	 */
	public void setPhoneNumber(String string) {
		phoneNumber = string;
	}

	@Override
	public String toString() {
		return "PhoneNumber [id=" + id + ", idContact=" + idContact + ", phoneKind=" + phoneKind + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
