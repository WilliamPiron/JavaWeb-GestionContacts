package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.LoginValidationForm;

public class LoginAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {

		final LoginValidationForm lForm = (LoginValidationForm) pForm;

		if (lForm.getUsername().equals(lForm.getPassword())) {
			return pMapping.findForward("connexion");
		} else {
			return pMapping.findForward("error");
		}
	}
}
