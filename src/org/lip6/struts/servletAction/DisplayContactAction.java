package org.lip6.struts.servletAction;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;

public class DisplayContactAction extends Action{
	
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {

		final DAOContact daoContact = new DAOContact();
		List<Contact> display = new LinkedList<Contact>();
		
		display = daoContact.displayContacts();
		
		pRequest.setAttribute("LISTE_CONTACTS", display);
		return pMapping.findForward("succes");
	}
}
