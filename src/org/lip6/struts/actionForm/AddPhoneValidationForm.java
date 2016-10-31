package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddPhoneValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private long id = 0;
	private String phoneKind = null;
	private String phoneNumber = null;

	/**
	 * @return ID Returns ID
	 */
	public long getId() {
		return id;
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
	 * @param l
	 *            Sets the ID
	 */
	public void setId(long l) {
		id = l;
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

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.id = 0;
		this.phoneKind = null;
		this.phoneNumber = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getId() < 1) {
			errors.add("id", new ActionMessage("creation.id.error.required"));
		}
		if (getPhoneKind().trim() == null || getPhoneKind().trim().length() < 1) {
			errors.add("phoneKind", new ActionMessage("creation.phonekind.error.required"));
		}
		if (getPhoneNumber().trim() == null || getPhoneNumber().trim().length() < 1
				|| !getPhoneNumber().matches("[0-9]+")) {
			errors.add("phoneNumber", new ActionMessage("creation.phonenumber.error.required"));
		}

		return errors;
	}
}
