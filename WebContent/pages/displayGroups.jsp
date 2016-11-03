<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
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
	<h1 class="text-center">
		<bean:message key="title.list.group" />
	</h1>

	<br>
	<br>
	<table class="table table-striped">
		<thead>
			<tr>
				<th><bean:message key="add.group.form.id" /></th>
				<th><bean:message key="add.group.form.name" /></th>
				<th><bean:message key="contact.all.delete" /></th>
				<th><bean:message key="contact.all.update" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="LISTEGROUPS" id="groups">
				<tr>
					<td><bean:write name="groups" property="groupId" /></td>
					<td><bean:write name="groups" property="groupName" /></td>
					<td><html:link action="GroupDestroy.do" paramId="groupName"
							paramName="groups" paramProperty="groupName">
							<bean:message key="main.deletecontact.link" />
						</html:link></td>
					<td><html:link action="UpdateG.do" paramId="groupId"
							paramName="groups" paramProperty="groupId">
							<bean:message key="contact.all.update" />
						</html:link></td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>

	<html:form action="/AddGroup">
		<html:errors />
		<table class="table table-striped">
			<thead>
				<tr>
					<th><bean:message key="add.group.form.id" /></th>
					<th><bean:message key="add.group.form.name" /></th>
					<th><bean:message key="form.validation" /></th>
					<th><bean:message key="form.reset" /></th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td><html:text property="id" maxlength="9" /></td>
					<td><html:text property="name" maxlength="50" /></td>
					<td align="right"><html:submit>
							<bean:message key="form.validation" />
						</html:submit></td>
					<td align="right"><html:reset>
							<bean:message key="form.reset" />
						</html:reset></td>
				</tr>
			</tbody>
		</table>
	</html:form>

	<h4>
		<a href="Main.do"><bean:message key="main.redirection" /></a>
	</h4>
</body>
</html>