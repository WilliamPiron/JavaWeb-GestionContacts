package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.lip6.struts.actionForm.AddGroupValidationForm;
import org.lip6.struts.domain.DAOGroup;
import org.lip6.struts.domain.DisplayGroups;

public class AddGroupAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {

		final AddGroupValidationForm lForm = (AddGroupValidationForm) pForm;

		final long id = lForm.getId();
		final String name = lForm.getName().trim().replaceAll(" +", " ");

		final DAOGroup lDAOGroup = new DAOGroup();
		final String lError = lDAOGroup.addGroup(id, name);
		final DAOGroup daoGroup = new DAOGroup();
		final DisplayGroups displayGroups = daoGroup.displayAllGroups();

		if (displayGroups.getError() == null && lError == null) {

			pRequest.setAttribute("LISTEGROUPS", displayGroups.getGroups());
			return pMapping.findForward("success");
		} else if (lError == null) {
			final ActionMessages lErreurs = getErrors(pRequest);
			final ActionMessage lActionMessage = new ActionMessage(displayGroups.getError(), false);
			lErreurs.add(Globals.ERROR_KEY, lActionMessage);
			saveErrors(pRequest, lErreurs);
			return pMapping.findForward("error");
		} else {
			final ActionMessages lErreurs = getErrors(pRequest);
			final ActionMessage lActionMessage = new ActionMessage(lError, false);
			lErreurs.add(Globals.ERROR_KEY, lActionMessage);
			saveErrors(pRequest, lErreurs);
			return pMapping.findForward("error");
		}
	}
}
