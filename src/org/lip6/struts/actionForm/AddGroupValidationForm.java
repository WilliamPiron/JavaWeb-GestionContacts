package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.DAOGroup;
import org.lip6.struts.domain.DisplayAllContact;
import org.lip6.struts.domain.DisplayGroups;

public class AddGroupValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private long id = 0;
	private String name = null;

	/**
	 * @return ID Returns ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return Name
	 */
	public String getName() {
		return name;
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
	 *            sets the Name
	 */
	public void setName(String string) {
		name = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.id = 0;
		this.name = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (getId() < 1) {
			errors.add("id", new ActionMessage("creation.id.error.required"));
		}
		if (getName().trim() == null || getName().trim().length() < 1) {
			errors.add("name", new ActionMessage("creation.group.name.error.required"));
		}
		
		final DAOGroup daoGroup = new DAOGroup();
		final DisplayGroups displayGroups = daoGroup.displayAllGroups();

		// On ne gère pas les erreurs s'il y a un problème avec la BDD !
		if (displayGroups.getError() == null) {
			
			request.setAttribute("LISTEGROUPS", displayGroups.getGroups());
		}
		
		return errors;
	}
}
