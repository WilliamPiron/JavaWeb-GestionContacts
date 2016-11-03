package org.lip6.struts.servletAction;

import java.util.LinkedList;
import java.util.List;

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
import org.lip6.struts.domain.Address;
import org.lip6.struts.domain.ContactGroup;
import org.lip6.struts.domain.DAOContact;
import org.lip6.struts.domain.DAOGroup;
import org.lip6.struts.domain.DAOPhone;
import org.lip6.struts.domain.DisplayAllContact;
import org.lip6.struts.domain.PhoneNumber;

public class SearchAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {

		System.out.println("Entre dans action search");

		final SearchValidationForm lForm = (SearchValidationForm) pForm;

		final String word = lForm.getWord().trim().replaceAll(" +", " ");

		final DAOContact daoContact = new DAOContact();
		final DisplayAllContact display = daoContact.searchContact(word);
		
		final List<Address> displayAddress = daoContact.searchAddress(word);

		final DAOPhone daoPhone = new DAOPhone();
		List<PhoneNumber> phones = new LinkedList<PhoneNumber>();
		phones = daoPhone.searchPhone(word);

		final DAOGroup daoGroup = new DAOGroup();
		List<ContactGroup> contactGroup = new LinkedList<ContactGroup>();
		contactGroup = daoGroup.searchGroup(word);

		if (phones.isEmpty()) {
			phones.add(new PhoneNumber(0, 0, null, null, null));
		}

		if (contactGroup.isEmpty()) {
			contactGroup.add(new ContactGroup(0, null));
		}
		
		if (displayAddress.isEmpty()) {
			displayAddress.add(new Address(0, null, null, null, null));
		}

		if (display.getError() == null && phones.get(0).getErrors() == null) {

			pRequest.setAttribute("CONTACT", display.getContacts());
			
			if (displayAddress.get(0).getId() == 0) {
				displayAddress.clear();
				pRequest.setAttribute("ADDRESS", displayAddress);
			} else {
				pRequest.setAttribute("ADDRESS", displayAddress);
			}

			if (contactGroup.get(0).getGroupId() == 0) {
				contactGroup.clear();
				pRequest.setAttribute("GROUP", contactGroup);
			} else {
				pRequest.setAttribute("GROUP", contactGroup);
			}

			System.out.println("Group : " + contactGroup);

			if (phones.get(0).getId() != 0) {
				pRequest.setAttribute("PHONE", phones);
			} else {
				phones.clear();
				pRequest.setAttribute("PHONE", phones);
			}

			return pMapping.findForward("success");
		} else if (display.getError() == null) {
			final ActionMessages lErreurs = getErrors(pRequest);
			final ActionMessage lActionMessage = new ActionMessage(phones.get(0).getErrors(), false);
			lErreurs.add(Globals.ERROR_KEY, lActionMessage);
			saveErrors(pRequest, lErreurs);
			return pMapping.findForward("error");
		} else {
			final ActionMessages lErreurs = getErrors(pRequest);
			final ActionMessage lActionMessage = new ActionMessage(display.getError(), false);
			lErreurs.add(Globals.ERROR_KEY, lActionMessage);
			saveErrors(pRequest, lErreurs);
			return pMapping.findForward("error");
		}
	}
}