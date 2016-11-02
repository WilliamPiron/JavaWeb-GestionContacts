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
<title><bean:message key="main.search" /></title>
</head>
<body>
<h2><bean:message key="main.search.info" /></h2>
<html:form action="/SearchAll">
		<html:errors />
		<table border="1">
			<thead>
				<tr>
					<th><bean:message key="main.search" /></th>
					<th><bean:message key="form.validation" /></th>
					<th><bean:message key="form.reset" /></th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td><html:text property="word" maxlength="9" /></td>
					<td><html:submit>
							<bean:message key="form.validation" />
						</html:submit></td>
					<td><html:reset>
							<bean:message key="form.reset" />
						</html:reset></td>
				</tr>
			</tbody>
		</table>
	</html:form>
</body>
</html>