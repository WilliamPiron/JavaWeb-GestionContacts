package org.lip6.struts.domain;

public class ContactGroup {

	private long groupId;
	private String groupName;

	/**
	 * @return ID Returns ID
	 */
	public long getGroupId() {
		return groupId;
	}

	/**
	 * @return GroupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param l
	 *            Sets the Group Id
	 */
	public void setGroupId(long l) {
		groupId = l;
	}

	/**
	 * @param string
	 *            sets the Group Name
	 */
	public void setGroupName(String string) {
		groupName = string;
	}
}
