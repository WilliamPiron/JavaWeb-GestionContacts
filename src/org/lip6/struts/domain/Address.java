package org.lip6.struts.domain;

public class Address {

	private long id;
	private String street;
	private String city;
	private String zip;
	private String country;

	/**
	 * @return ID Returns ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return Street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return City
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return Zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @return Country
	 */
	public String getCountry() {
		return country;
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
	 *            sets the Street
	 */
	public void setStreet(String string) {
		street = string;
	}

	/**
	 * @param string
	 *            sets the Zip
	 */
	public void setZip(String string) {
		zip = string;
	}

	/**
	 * @param string
	 *            sets the Country
	 */
	public void setCountry(String string) {
		country = string;
	}
}
