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

<title><bean:message key="group.all.update" /></title>
</head>
<body>
	<h1 class="text-center">
		<bean:message key="form.info" />
	</h1>

	<br>
	<br>
	<html:form action="/UpdateGroup">
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
					<td><html:text property="groupId" maxlength="9"
							readonly="true" /></td>
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

	<div class="text-center">
		<h4>
			<a href="Main.do"><bean:message key="main.redirection" /></a>
		</h4>
	</div>
</body>
</html>