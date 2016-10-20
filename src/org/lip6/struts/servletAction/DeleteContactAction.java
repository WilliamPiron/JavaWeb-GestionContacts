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
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.DisplayAllContact;

public class DeleteContactAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {

		final String id = pRequest.getParameter("id");

		final DAOContact daoContact = new DAOContact();
		
		final String lError = daoContact.deleteContact(Integer.valueOf(id));
		final DisplayAllContact display = daoContact.displayAllContacts();

		if (lError == null) {
			pRequest.setAttribute("LISTECONTACTS", display.getContacts());
			return pMapping.findForward("success");
		} else {
			System.out.println("Erreur action");
			final ActionMessages lErreurs = getErrors(pRequest);
			final ActionMessage lActionMessage = new ActionMessage(display.getError(), false);
			lErreurs.add(Globals.ERROR_KEY, lActionMessage);
			saveErrors(pRequest, lErreurs);
			return pMapping.findForward("error");
		}
	}

}