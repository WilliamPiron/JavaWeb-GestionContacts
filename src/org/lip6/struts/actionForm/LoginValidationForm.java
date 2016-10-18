package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String username = null;
	private String password = null;

	/**
	 * @return Username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param string
	 *            sets the Username
	 */
	public void setUsername(String string) {
		username = string;
	}

	/**
	 * @param string
	 *            sets the Password
	 */
	public void setPassword(String string) {
		password = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.username = null;
		this.password = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getUsername() == null || getUsername().length() < 1) {
			errors.add("username", new ActionMessage("username.error.required"));
		}
		if (getPassword() == null || getPassword().length() < 1) {
			errors.add("password", new ActionMessage("password.error.required"));
		}
		if (!getPassword().equals(getUsername())) {
			errors.add("different", new ActionMessage("login.error.required"));
		}
		return errors;
	}
}
