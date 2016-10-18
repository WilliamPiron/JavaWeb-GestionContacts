package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.AddGroupValidationForm;
import org.lip6.struts.domain.DAOGroup;

public class AddGroupAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {

		final AddGroupValidationForm lForm = (AddGroupValidationForm) pForm;

		final long id = lForm.getId();
		final String name = lForm.getName().trim().replaceAll(" +", " ");
		
		final DAOGroup lDAOGroup = new DAOGroup();
		
		final String lError = lDAOGroup.addGroup(id, name);

		if (lError == null) {
			// if no exception is raised, forward "success"
			return pMapping.findForward("success");
		} else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}
