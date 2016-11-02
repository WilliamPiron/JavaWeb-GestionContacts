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
<title><bean:message key="group.all.update" /></title>
</head>
<body>
<html:form action="/UpdateGroup">
		<html:errors />
		<table>
			<tr>
				<td align="center" colspan="2"><font size="4"><bean:message
							key="form.info" /></font>
			</tr>
			<tr>
				<td align="right"><bean:message key="add.group.form.id" /></td>
				<td align="left"><html:text property="groupId" size="30"
						maxlength="9" readonly="true"/></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="add.group.form.name" /></td>
				<td align="left"><html:text property="name" size="30"
						maxlength="50" /></td>
			</tr>
			<tr>
				<td align="right"><html:submit>
						<bean:message key="form.validation" />
					</html:submit></td>
			</tr>
			<tr>
				<td align="right"><html:reset>
						<bean:message key="form.reset" />
					</html:reset></td>
			</tr>
		</table>
	</html:form>
</body>
</html>