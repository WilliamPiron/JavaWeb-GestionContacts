package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.DAOPhone;
import org.lip6.struts.domain.PhoneNumber;

public class UpdatePhoneValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private int id = 0;
	private String phoneKind = null;
	private String phoneNumber = null;
	
	/**
	 * @return ID Returns ID
	 */
	public int getId() {
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
	public void setId(int l) {
		id = l;
	}

	/**
	 * @param string
	 *            Sets the Phone kind
	 */
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	/**
	 * @param string
	 *            Sets the Phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		DAOPhone daoPhone = new DAOPhone();
		PhoneNumber phoneNumber = daoPhone.getPhone(Integer.valueOf(request.getParameter("id")));
		
		this.id = phoneNumber.getId();
		this.phoneKind = phoneNumber.getPhoneKind();
		this.phoneNumber = phoneNumber.getPhoneNumber();
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
