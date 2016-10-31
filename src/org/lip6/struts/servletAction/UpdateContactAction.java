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
import org.lip6.struts.actionForm.UpdateContactValidationForm;
import org.lip6.struts.domain.DAOContact;

public class UpdateContactAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {

		System.out.println("Entre dans action form update contact");

		final UpdateContactValidationForm lForm = (UpdateContactValidationForm) pForm;

		final long id = lForm.getId();
		final String firstName = lForm.getFirstName().trim().replaceAll(" +", " ");
		final String lastName = lForm.getLastName().trim().replaceAll(" +", " ");
		final String email = lForm.getEmail();

		final String street = lForm.getStreet().trim().replaceAll(" +", " ");
		final String city = lForm.getCity().trim().replaceAll(" +", " ");
		final String zip = lForm.getZip().trim().replaceAll(" +", " ");
		final String country = lForm.getCountry().trim().replaceAll(" +", " ");

		final String phoneKind = lForm.getPhoneKind().trim().replaceAll(" +", " ");
		final String phoneNumber = lForm.getPhoneNumber().trim().replaceAll(" +", " ");

		final DAOContact lDAOContact = new DAOContact();

		final String lError = lDAOContact.updateContact(id, firstName, lastName, email, street, city, zip, country,
				phoneKind, phoneNumber);

		if (lError == null) {

			return pMapping.findForward("success");
		} else {

			final ActionMessages lErreurs = getErrors(pRequest);
			final ActionMessage lActionMessage = new ActionMessage(lError, false);
			lErreurs.add(Globals.ERROR_KEY, lActionMessage);
			saveErrors(pRequest, lErreurs);
			return pMapping.findForward("error");
		}
	}
}
