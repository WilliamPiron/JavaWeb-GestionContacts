package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CompositionGroupContactValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private long idContact = 0;
	private long idGroup = 0;

	/**
	 * @return idContact
	 */
	public long getIdContact() {
		return idContact;
	}

	/**
	 * @return idGroup
	 */
	public long getIdGroup() {
		return idGroup;
	}

	/**
	 * @param l
	 *            Sets the idContact
	 */
	public void setIdContact(long l) {
		idContact = l;
	}

	/**
	 * @param string
	 *            sets the idGroup
	 */
	public void setIdGroup(long l) {
		idGroup = l;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.idContact = 0;
		this.idGroup = 0;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (getIdContact() < 1) {
			errors.add("idContact", new ActionMessage("creation.id.error.required"));
		}
		if (getIdGroup() < 1) {
			errors.add("idGroup", new ActionMessage("creation.id.error.required"));
		}
		return errors;
	}
}
