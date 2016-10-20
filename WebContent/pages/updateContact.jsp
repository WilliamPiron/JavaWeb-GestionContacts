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
<title><bean:message key="contact.all.update" /></title>
<html:base />
</head>
<body>
	<html:form action="/UpdateContact">
		<html:errors />
		<table>
			<tr>
				<td align="center" colspan="2"><font size="4"><bean:message
							key="form.info" /></font>
			</tr>
			<tr>
				<td align="right"><bean:message key="add.contact.form.id" /></td>
				<td align="left"><html:text property="id" size="30"
						maxlength="9" value='<%= request.getParameter("id") %>' readonly="true"/></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="add.contact.form.lastname" /></td>
				<td align="left"><html:text property="lastName" size="30"
						maxlength="50" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message
						key="add.contact.form.firstname" /></td>
				<td align="left"><html:text property="firstName" size="30"
						maxlength="50" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="add.contact.form.email" /></td>
				<td align="left"><html:text property="email" size="30"
						maxlength="50" /></td>
			</tr>
			<tr>
				<td><bean:message key="add.contact.title.address" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="add.contact.form.street" /></td>
				<td align="left"><html:text property="street" size="30"
						maxlength="50" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="add.contact.form.city" /></td>
				<td align="left"><html:text property="city" size="30"
						maxlength="50" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="add.contact.form.zip" /></td>
				<td align="left"><html:text property="zip" size="30"
						maxlength="50" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="add.contact.form.country" /></td>
				<td align="left"><html:text property="country" size="30"
						maxlength="50" /></td>
			</tr>
			<tr>
				<td><bean:message key="add.contact.title.phone" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message
						key="add.contact.form.phonekind" /></td>
				<td align="left"><html:text property="phoneKind" size="30"
						maxlength="50" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message
						key="add.contact.form.phonenumber" /></td>
				<td align="left"><html:text property="phoneNumber" size="30"
						maxlength="50" /></td>
			</tr>
			<tr>
				<td align="right"><html:submit>
						<bean:message key="form.validation" />
					</html:submit></td>
			</tr>
		</table>
	</html:form>
</body>
</html:html>