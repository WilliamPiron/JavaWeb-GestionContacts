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
<title><bean:message key="welcome.page.title" /></title>
<html:base />
</head>
<body>
	<html:form action="/Login">
		<html:errors />
		<table>
			<tr>
				<td align="center" colspan="2"><font size="4"><bean:message
							key="form.login.info" /></font>
			</tr>
			<tr>
				<td align="right"><bean:message key="contact.form.username" /></td>
				<td align="left"><html:text property="username" size="30"
						maxlength="50" value="admin" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="contact.form.password" /></td>
				<td align="left"><html:password property="password" size="30"
						maxlength="50" value="admin"/></td>
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