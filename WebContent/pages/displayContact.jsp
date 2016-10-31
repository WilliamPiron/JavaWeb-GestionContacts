<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
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
				<logic:present name="ADDRESS">
					<th><bean:message key="add.contact.form.street" /></th>
					<th><bean:message key="add.contact.form.city" /></th>
					<th><bean:message key="add.contact.form.zip" /></th>
					<th><bean:message key="add.contact.form.country" /></th>
				</logic:present>
			</tr>
		</thead>
		<tbody>
			<tr>
				<logic:iterate name="CONTACT" id="contact">
					<td><bean:write name="contact" property="id" /></td>
					<td><bean:write name="contact" property="firstName" /></td>
					<td><bean:write name="contact" property="lastName" /></td>
					<td><bean:write name="contact" property="email" /></td>
				</logic:iterate>

				<logic:present name="ADDRESS">
					<logic:iterate name="ADDRESS" id="address">
						<td><bean:write name="address" property="street" /></td>
						<td><bean:write name="address" property="city" /></td>
						<td><bean:write name="address" property="zip" /></td>
						<td><bean:write name="address" property="country" /></td>
					</logic:iterate>
				</logic:present>
			</tr>
		</tbody>
	</table>

	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="add.contact.form.phonekind" /></th>
				<th><bean:message key="add.contact.form.phonenumber" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="CONTACT" id="contact">
				<logic:iterate name="contact" property="phone" id="phones">
					<tr>
						<td><bean:write name="phones" property="phoneKind" /></td>
						<td><bean:write name="phones" property="phoneNumber" /></td>
					</tr>
				</logic:iterate>
			</logic:iterate>
		</tbody>
	</table>

	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="add.contact.form.groupname" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="CONTACT" id="contact">
				<logic:iterate name="contact" property="group" id="groups">
					<tr>
						<td><bean:write name="groups" property="groupName" /></td>
					</tr>
				</logic:iterate>
			</logic:iterate>
		</tbody>
	</table>

	<h4>
		<a href="Main.do"><bean:message key="main.redirection" /></a>
	</h4>
</body>
</html:html>