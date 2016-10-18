package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.AddContactValidationForm;
import org.lip6.struts.domain.DAOContact;

public class AddContactAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {

		final AddContactValidationForm lForm = (AddContactValidationForm) pForm;

		final long id = lForm.getId();
		// La fonction trim permet de supprimer les espaces en début et en fin
		// de chaîne
		// s'il y a plusieurs espaces entre les mots, replaceAll les remplacent
		// par un seul espace

		// Contact
		final String firstName = lForm.getFirstName().trim().replaceAll(" +", " ");
		final String lastName = lForm.getLastName().trim().replaceAll(" +", " ");
		final String email = lForm.getEmail();

		// Address
		final long idAddress = lForm.getIdAddress();
		final String street = lForm.getStreet().trim().replaceAll(" +", " ");
		final String city = lForm.getCity().trim().replaceAll(" +", " ");
		final String zip = lForm.getZip().trim().replaceAll(" +", " ");
		final String country = lForm.getCountry().trim().replaceAll(" +", " ");

		// Phone
		final long idPhone = lForm.getIdPhone();
		final String phoneKind = lForm.getPhoneKind().trim().replaceAll(" +", " ");
		final String phoneNumber = lForm.getPhoneNumber().trim().replaceAll(" +", " ");

		// Company
		final long numSiret = lForm.getNumSiret();

		// Group
		final long idGroup = lForm.getIdGroup();
		final String groupName = lForm.getGroupName().trim().replaceAll(" +", " ");

		// create a new Contact
		final DAOContact lDAOContact = new DAOContact();
		final String lError = lDAOContact.addContact(id, firstName, lastName, email, idAddress, street, city, zip,
				country, idPhone, phoneKind, phoneNumber, numSiret, idGroup, groupName);

		if (lError == null) {
			// if no exception is raised, forward "success"
			return pMapping.findForward("success");
		} else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}
