package org.lip6.struts.domain;

import java.io.Serializable;
import java.util.List;

public class DisplayGroups implements Serializable {
	
	private static final long serialVersionUID = 1050432583446929484L;
	
	private String error;
	private List<ContactGroup> groups;

	/**
	 * @return Error
	 */
	public String getError() {
		return error;
	}
	
	/**
	 * @return Liste Groups
	 */
	public List<ContactGroup> getGroups() {
		return groups;
	}
	
	/**
	 * @param string
	 *            sets error
	 */
	public void setError(String string) {
		error = string;
	}
	
	/**
	 * @param string
	 *            sets the Groups
	 */
	public void setGroups(List<ContactGroup> list) {
		groups = list;
	}
}
