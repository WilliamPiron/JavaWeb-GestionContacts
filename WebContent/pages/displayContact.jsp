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
				<th>id</th>
				<th>lastname</th>
				<th>firstname</th>
				<th>email</th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate id="contact" name="LISTE_CONTACTS"
				type="org.lip6.struts.domain.Contact">
				<tr>
					<td><bean:write name="contact" property="id" /></td>
					<td><bean:write name="contact" property="lastName" /></td>
					<td><bean:write name="contact" property="firstName" /></td>
					<td><bean:write name="contact" property="email" /></td>
				</tr>
			</logic:iterate>
		</tbody>
	</table>
</body>
</html:html>