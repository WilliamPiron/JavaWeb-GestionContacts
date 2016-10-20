package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteContactValidationForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;

	private long id = 0;

	/**
	 * @return ID Returns ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param l
	 *            Sets the ID
	 */
	public void setId(long l) {
		id = l;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.id = 0;

	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		if (getId() < 1) {
			errors.add("id", new ActionMessage("creation.id.error.required"));
		}
		return errors;
	}
}