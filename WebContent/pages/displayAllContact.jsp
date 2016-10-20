<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="display.contact.title" /></title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="add.contact.form.id" /></th>
				<th><bean:message key="add.contact.form.lastname" /></th>
				<th><bean:message key="add.contact.form.firstname" /></th>
				<th><bean:message key="add.contact.form.email" /></th>
				<th><bean:message key="contact.all.display" /></th>
				<th><bean:message key="contact.all.delete" /></th>
				<th><bean:message key="contact.all.update" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="LISTECONTACTS" id="contact">
				<tr>
					<td><bean:write name="contact" property="id" /></td>
					<td><bean:write name="contact" property="firstName" /></td>
					<td><bean:write name="contact" property="lastName" /></td>
					<td><bean:write name="contact" property="email" /></td>
					<td><html:link action="ContactDisplay.do" paramId="id"
							paramName="contact" paramProperty="id">
							<bean:message key="contact.display.link" />
						</html:link></td>
					<td><html:link action="ContactDeletion.do" paramId="id"
							paramName="contact" paramProperty="id">
							<bean:message key="main.deletecontact.link" />
						</html:link></td>
					<td><html:link action="UpdateC.do" paramId="id"
							paramName="contact" paramProperty="id">
							<bean:message key="contact.all.update" />
						</html:link></td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>
	<h4>
		<a href="Main.do"><bean:message
				key="main.redirection" /></a>
	</h4>
</body>
</html:html>