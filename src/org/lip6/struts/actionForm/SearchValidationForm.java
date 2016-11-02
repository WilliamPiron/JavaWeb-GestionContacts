package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SearchValidationForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private String word = null;

	/**
	 * @return Word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param string
	 *            sets the Word
	 */
	public void setWord(String string) {
		word = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		this.word = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (getWord().trim() == null || getWord().trim().length() < 1) {
			
			errors.add("word", new ActionMessage("search.word.required"));
		}
		
		return errors;
	}
}
