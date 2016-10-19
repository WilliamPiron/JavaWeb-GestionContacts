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
<title><bean:message key="main.page.title" /></title>
</head>
<body>
	<h1>
		<bean:message key="main.page.menu" />
	</h1>

	<h4>
		<a href="ContactCreation.do"><bean:message
				key="main.addcontact.link" /></a>
	</h4>
	<h4>
		<a href="GroupCreation.do"><bean:message
				key="main.addgroup.link" /></a>
	</h4>
	<h4>
		<a href="ContactDisplay.do"><bean:message
				key="main.contactdisplay.link" /></a>
	</h4>
</body>
</html:html>