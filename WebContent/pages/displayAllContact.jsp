<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="css\bootstrap-3.3.7-dist\css\bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="css\bootstrap-3.3.7-dist\css\bootstrap.custom.login.css" />

<title><bean:message key="display.contact.title" /></title>
</head>
<body>
	<h1 class="text-center">
		<bean:message key="title.list.contact" />
	</h1>
	<br>
	<br>
	<table class="table table-striped">
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
					<td><html:link action="ContactDeletion.do?action=delete"
							paramId="id" paramName="contact" paramProperty="id">
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
	<html:form action="/AddContact">
		<html:errors />
		<table class="table table-striped">
			<thead>
				<tr>
					<th><bean:message key="add.contact.form.id" /></th>
					<th><bean:message key="add.contact.form.lastname" /></th>
					<th><bean:message key="add.contact.form.firstname" /></th>
					<th><bean:message key="add.contact.form.email" /></th>
					<th><bean:message key="add.contact.form.street" /></th>
					<th><bean:message key="add.contact.form.city" /></th>
					<th><bean:message key="add.contact.form.zip" /></th>
					<th><bean:message key="add.contact.form.country" /></th>
					<th><bean:message key="form.validation" /></th>
					<th><bean:message key="form.reset" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><html:text property="id" maxlength="9" size="10" /></td>
					<td><html:text property="lastName" maxlength="50" /></td>
					<td><html:text property="firstName" maxlength="50" /></td>
					<td><html:text property="email" maxlength="50" /></td>
					<td><html:text property="street" maxlength="50" /></td>
					<td><html:text property="city" maxlength="50" /></td>
					<td><html:text property="zip" maxlength="25" /></td>
					<td><html:text property="country" maxlength="50" /></td>
					<td><html:submit property="action" value="add">
							<bean:message key="form.validation" />
						</html:submit></td>
					<td><html:reset>
							<bean:message key="form.reset" />
						</html:reset></td>
				</tr>
			</tbody>
		</table>
	</html:form>
	<div class="text-center">
		<h4>
			<a href="Main.do"><bean:message key="main.redirection" /></a>
		</h4>
	</div>
</body>
</html:html>