package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddContactValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	// Contact
	private long id = 0;
	private String lastName = null;
	private String firstName = null;
	private String email = null;

	// Address
	private long idAddress = 0;
	private String street = null;
	private String city = null;
	private String zip = null;
	private String country = null;

	// Phone
	private long idPhone = 0;
	private String phoneKind = null;
	private String phoneNumber = null;

	// Company
	private long numSiret = 0;

	// Group
	private long idGroup = 0;
	private String groupName = null;

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
	 * @return ID Returns ID
	 */
	public long getIdAddress() {
		return idAddress;
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
	 * @return ID Returns ID
	 */
	public long getIdPhone() {
		return idPhone;
	}

	/**
	 * @return Phone kind
	 */
	public String getPhoneKind() {
		return phoneKind;
	}

	/**
	 * @return Phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return ID Returns Numéro siret
	 */
	public long getNumSiret() {
		return numSiret;
	}

	/**
	 * @return ID Returns ID
	 */
	public long getIdGroup() {
		return idGroup;
	}

	/**
	 * @return Group Name
	 */
	public String getGroupName() {
		return groupName;
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
	 * @param l
	 *            Sets the ID for address
	 */
	public void setIdAddress(long l) {
		idAddress = l;
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
	 *            sets the City
	 */
	public void setCity(String string) {
		city = string;
	}

	/**
	 * @param string
	 *            sets the Zip code
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

	/**
	 * @param l
	 *            Sets the ID for phone
	 */
	public void setIdPhone(long l) {
		idPhone = l;
	}

	/**
	 * @param string
	 *            sets the Phone kind
	 */
	public void setPhoneKind(String string) {
		phoneKind = string;
	}

	/**
	 * @param string
	 *            sets the Phone number
	 */
	public void setPhoneNumber(String string) {
		phoneNumber = string;
	}

	/**
	 * @param l
	 *            Sets the ID for company
	 */
	public void setNumSiret(long l) {
		numSiret = l;
	}

	/**
	 * @param l
	 *            Sets the ID for group
	 */
	public void setIdGroup(long l) {
		idGroup = l;
	}

	/**
	 * @param string
	 *            sets the Group name
	 */
	public void setGroupName(String string) {
		groupName = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Contact
		this.id = 0;
		this.firstName = null;
		this.lastName = null;
		this.email = null;

		// Address
		this.idAddress = 0;
		this.street = null;
		this.city = null;
		this.zip = null;
		this.country = null;

		// Phone
		this.idPhone = 0;
		this.phoneKind = null;
		this.phoneNumber = null;

		// Company
		this.numSiret = 0;

		// Group
		this.idGroup = 0;
		this.groupName = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		// Contact
		if (getId() < 1) {
			errors.add("id", new ActionMessage("creation.id.error.required"));
		}

		// matches permet de voir si notre string contient des nombres
		if (getFirstName() == null || getFirstName().length() < 1 || getFirstName().matches(".*\\d.*")) {
			errors.add("first name", new ActionMessage("creation.firstname.error.required"));
		}
		if (getLastName() == null || getLastName().length() < 1 || getLastName().matches(".*\\d.*")) {
			errors.add("last name", new ActionMessage("creation.lastname.error.required"));
		}

		// Pour le matches on regarde que l'email est bien de la forme
		// string@string.string et on invalide toutes les autres formes
		if (getEmail() == null || getEmail().length() < 1 || !getEmail().matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			errors.add("email", new ActionMessage("creation.email.error.required"));
		}

		// Address
		if (getIdAddress() < 1) {
			errors.add("idAddress", new ActionMessage("creation.id.address.error.required"));
		}
		if (getStreet() == null || getStreet().length() < 1) {
			errors.add("street", new ActionMessage("creation.street.error.required"));
		}
		if (getCity() == null || getCity().length() < 1) {
			errors.add("city", new ActionMessage("creation.city.error.required"));
		}
		if (getZip() == null || getZip().length() < 1) {
			errors.add("zip", new ActionMessage("creation.zip.error.required"));
		}
		if (getCountry() == null || getCountry().length() < 1) {
			errors.add("country", new ActionMessage("creation.country.error.required"));
		}

		// Phone
		if (getIdPhone() < 1) {
			errors.add("idPhone", new ActionMessage("creation.id.phone.error.required"));
		}
		if (getPhoneKind() == null || getPhoneKind().length() < 1) {
			errors.add("phoneKind", new ActionMessage("creation.phonekind.error.required"));
		}
		if (getPhoneNumber() == null || getPhoneNumber().length() < 1) {
			errors.add("phoneNumber", new ActionMessage("creation.phonenumber.error.required"));
		}

		// Company
		if (getNumSiret() < 1) {
			errors.add("numSiret", new ActionMessage("creation.numsiret.error.required"));
		}

		// Group
		if (getIdGroup() < 1) {
			errors.add("idGroup", new ActionMessage("creation.id.group.error.required"));
		}
		if (getGroupName() == null || getGroupName().length() < 1) {
			errors.add("groupName", new ActionMessage("creation.groupname.error.required"));
		}

		return errors;
	}
}
