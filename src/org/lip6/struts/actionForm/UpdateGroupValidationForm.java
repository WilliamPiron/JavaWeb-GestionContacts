package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.DAOGroup;
import org.lip6.struts.domain.DisplayGroups;

public class UpdateGroupValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private long groupId = 0;
	private String name = null;
	
	/**
	 * @return ID Returns ID
	 */
	public long getGroupId() {
		return groupId;
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
	public void setGroupId(long l) {
		groupId = l;
	}

	/**
	 * @param string
	 *            sets the Name
	 */
	public void setName(String string) {
		name = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		DAOGroup daoGroup = new DAOGroup();
		
		//On ne gère pas les erreurs avec la BDD !
		final DisplayGroups display = daoGroup.displayGroup(Integer.valueOf(request.getParameter("groupId")));
		
		this.groupId = display.getGroups().get(0).getGroupId();
		this.name = display.getGroups().get(0).getGroupName();
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (getName().trim() == null || getName().trim().length() < 1) {
			errors.add("name", new ActionMessage("creation.group.name.error.required"));
		}
		
		return errors;
	}
}