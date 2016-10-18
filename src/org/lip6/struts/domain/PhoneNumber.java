package org.lip6.struts.domain;

public class PhoneNumber {

	private long id;
	private String phoneKind;
	private String phoneNumber;

	/**
	 * @return ID Returns ID
	 */
	public long getId() {
		return id;
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
}
