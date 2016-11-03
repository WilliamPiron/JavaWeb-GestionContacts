<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="css\bootstrap-3.3.7-dist\css\bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="css\bootstrap-3.3.7-dist\css\bootstrap.custom.login.css" />

<title><bean:message key="display.contact.title" /></title>
</head>
<body>

	<!-- CONTACT -->
	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="add.contact.form.id" /></th>
				<th><bean:message key="add.contact.form.lastname" /></th>
				<th><bean:message key="add.contact.form.firstname" /></th>
				<th><bean:message key="add.contact.form.email" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="CONTACT" id="contact">
				<tr>
					<td><bean:write name="contact" property="id" /></td>
					<td><bean:write name="contact" property="firstName" /></td>
					<td><bean:write name="contact" property="lastName" /></td>
					<td><bean:write name="contact" property="email" /></td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>

	<!-- ADDRESS -->
	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="add.contact.form.street" /></th>
				<th><bean:message key="add.contact.form.city" /></th>
				<th><bean:message key="add.contact.form.zip" /></th>
				<th><bean:message key="add.contact.form.country" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="ADDRESS" id="address">
				<tr>
					<td><bean:write name="address" property="street" /></td>
					<td><bean:write name="address" property="city" /></td>
					<td><bean:write name="address" property="zip" /></td>
					<td><bean:write name="address" property="country" /></td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>

	<!-- PHONE -->
	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="add.group.form.id" /></th>
				<th><bean:message key="add.contact.form.id" /></th>
				<th><bean:message key="add.contact.form.phonekind" /></th>
				<th><bean:message key="add.contact.form.phonenumber" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="PHONE" id="phone">
				<tr>
					<td><bean:write name="phone" property="id" /></td>
					<td><bean:write name="phone" property="idContact" /></td>
					<td><bean:write name="phone" property="phoneKind" /></td>
					<td><bean:write name="phone" property="phoneNumber" /></td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>

	<!-- GROUP -->
	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="add.group.form.id" /></th>
				<th><bean:message key="add.group.form.name" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="GROUP" id="group">
				<tr>
					<td><bean:write name="group" property="groupId" /></td>
					<td><bean:write name="group" property="groupName" /></td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>
</body>
</html>