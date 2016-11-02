package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.DisplayAllContact;

public class CompositionGroupContactValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private long id = 0;
	private long idGroup = 0;

	/**
	 * @return id du contact
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return idGroup
	 */
	public long getIdGroup() {
		return idGroup;
	}

	/**
	 * @param l
	 *            Sets the contact id
	 */
	public void setIdContact(long l) {
		id = l;
	}

	/**
	 * @param string
	 *            sets the idGroup
	 */
	public void setIdGroup(long l) {
		idGroup = l;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.idGroup = 0;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		System.out.println("Entre dans valide group contact : " + id);

		ActionErrors errors = new ActionErrors();
		
		if (getIdGroup() < 1) {
			errors.add("idGroup", new ActionMessage("creation.id.error.required"));
		}
		
		final DAOContact daoContact = new DAOContact();
		final DisplayAllContact display = daoContact.displayContact((int) id);

		// On ne gère pas les erreurs s'il y a un problème avec la BDD !
		if (display.getError() == null) {
			
			request.setAttribute("CONTACT", display.getContacts());
		}
		
		return errors;
	}
}
