<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ page import="org.lip6.struts.domain.Contact"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.LinkedList"%>
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
	<h2 class="text-center">
		<bean:message key="main.search.info" />
	</h2>

	<br>
	<br>

	<h4 class="text-center">
		<bean:message key="title.contact" />
	</h4>


	<!-- CONTACT -->
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
			<logic:iterate name="CONTACT" id="contact">
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

	<br>
	<br>

	<h4 class="text-center">
		<bean:message key="add.contact.title.address" />
	</h4>

	<!-- ADDRESS -->
	<table class="table table-striped">
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

	<br>
	<br>

	<h4 class="text-center">
		<bean:message key="title.phone" />
	</h4>

	<!-- PHONE -->
	<table class="table table-striped">
		<thead>
			<tr>
				<th><bean:message key="add.group.form.id" /></th>
				<th><bean:message key="add.contact.form.id" /></th>
				<th><bean:message key="add.contact.form.phonekind" /></th>
				<th><bean:message key="add.contact.form.phonenumber" /></th>
				<th><bean:message key="contact.all.update" /></th>
				<th><bean:message key="contact.all.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="PHONE" id="phone">
				<tr>
					<td><bean:write name="phone" property="id" /></td>
					<td><bean:write name="phone" property="idContact" /></td>
					<td><bean:write name="phone" property="phoneKind" /></td>
					<td><bean:write name="phone" property="phoneNumber" /></td>
					<td><html:link action="UpdateP.do" paramId="id"
							paramName="phone" paramProperty="id">
							<bean:message key="contact.all.update" />
						</html:link></td>
					<td>
						<%
							@SuppressWarnings("unchecked")
								List<Contact> c = (List<Contact>) request.getAttribute("CONTACT");
								session.setAttribute("id", c.get(0).getId());
								Map<String, Long> params = new HashMap<String, Long>();
								params.put("id", c.get(0).getId());
								pageContext.setAttribute("paramsMap", params);
						%> <html:link action="PhoneDeletion.do" name="paramsMap"
							scope="page" paramId="phoneNumber" paramName="phone"
							paramProperty="phoneNumber">
							<bean:message key="contact.all.delete" />
						</html:link>
					</td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>

	<br>
	<br>

	<h4 class="text-center">
		<bean:message key="title.group" />
	</h4>

	<!-- GROUP -->
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
			<logic:iterate name="GROUP" id="group">
				<tr>
					<td><bean:write name="group" property="groupId" /></td>
					<td><bean:write name="group" property="groupName" /></td>
					<td><html:link action="GroupDestroy.do" paramId="groupName"
							paramName="group" paramProperty="groupName">
							<bean:message key="main.deletecontact.link" />
						</html:link></td>
					<td><html:link action="UpdateG.do" paramId="groupId"
							paramName="group" paramProperty="groupId">
							<bean:message key="contact.all.update" />
						</html:link></td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>

	<div class="text-center">
		<h4>
			<a href="Main.do"><bean:message key="main.redirection" /></a>
		</h4>
	</div>
</body>
</html>