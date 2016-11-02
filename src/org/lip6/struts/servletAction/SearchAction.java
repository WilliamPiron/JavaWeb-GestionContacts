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
import org.lip6.struts.actionForm.SearchValidationForm;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.DisplayAllContact;

public class SearchAction extends Action {
	
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
		
		System.out.println("Entre dans action search");

		final SearchValidationForm lForm = (SearchValidationForm) pForm;

		final String word = lForm.getWord().trim().replaceAll(" +", " ");
		
		final DAOContact daoContact = new DAOContact();
		final DisplayAllContact display = daoContact.searchContact(word);

		if (display.getError() == null) {
			
			System.out.println("Envoi données action search");
			pRequest.setAttribute("CONTACT", display.getContacts());
			return pMapping.findForward("success");
		} else {
			final ActionMessages lErreurs = getErrors(pRequest);
			final ActionMessage lActionMessage = new ActionMessage(display.getError(), false);
			lErreurs.add(Globals.ERROR_KEY, lActionMessage);
			saveErrors(pRequest, lErreurs);
			return pMapping.findForward("error");
		} 
	}
}