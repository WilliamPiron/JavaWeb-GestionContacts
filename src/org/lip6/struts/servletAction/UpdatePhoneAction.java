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
import org.lip6.struts.actionForm.UpdatePhoneValidationForm;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.DAOPhone;
import org.lip6.struts.domain.DisplayAllContact;
import org.lip6.struts.domain.PhoneNumber;

public class UpdatePhoneAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {

		System.out.println("Entre dans action update phone");

		final UpdatePhoneValidationForm lForm = (UpdatePhoneValidationForm) pForm;
		
		final String PhoneKind = lForm.getPhoneKind().trim().replaceAll(" +", " ");
		final String PhoneNumber = lForm.getPhoneNumber().trim().replaceAll(" +", " ");
		final int idPhone = lForm.getId();

		final DAOPhone lDAOPhone = new DAOPhone();
		final PhoneNumber phone = lDAOPhone.getPhone(idPhone);
		final DAOContact daoContact = new DAOContact();
		final String lError = lDAOPhone.updatePhone(idPhone, PhoneKind, PhoneNumber);
		final DisplayAllContact display = daoContact.displayContact(phone.getIdContact());
		
		if (display.getError() == null && lError == null) {

			pRequest.setAttribute("CONTACT", display.getContacts());
			return pMapping.findForward("success");
		} else if (lError == null) {
			final ActionMessages lErreurs = getErrors(pRequest);
			final ActionMessage lActionMessage = new ActionMessage(display.getError(), false);
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