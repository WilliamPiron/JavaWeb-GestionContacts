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
import org.lip6.struts.actionForm.AddContactValidationForm;
import org.lip6.struts.domain.DAOContact;

public class AddContactAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {

		final AddContactValidationForm lForm = (AddContactValidationForm) pForm;

		// Contact
		final long id = lForm.getId();
		// La fonction trim permet de supprimer les espaces en début et en fin
		// de chaîne
		// s'il y a plusieurs espaces entre les mots, replaceAll les remplacent
		// par un seul espace

		final String firstName = lForm.getFirstName().trim().replaceAll(" +", " ");
		final String lastName = lForm.getLastName().trim().replaceAll(" +", " ");
		final String email = lForm.getEmail();

		// Address
		final String street = lForm.getStreet().trim().replaceAll(" +", " ");
		final String city = lForm.getCity().trim().replaceAll(" +", " ");
		final String zip = lForm.getZip().trim().replaceAll(" +", " ");
		final String country = lForm.getCountry().trim().replaceAll(" +", " ");

		// Phone
		final String phoneKind = lForm.getPhoneKind().trim().replaceAll(" +", " ");
		final String phoneNumber = lForm.getPhoneNumber().trim().replaceAll(" +", " ");

		// create a new Contact
		final DAOContact lDAOContact = new DAOContact();
		final String lError = lDAOContact.addContact(id, firstName, lastName, email, id, street, city, zip, country,
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
