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

<link rel="stylesheet" type="text/css"
	href="css\bootstrap-3.3.7-dist\css\bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="css\bootstrap-3.3.7-dist\css\bootstrap.custom.login.css" />

<title><bean:message key="main.page.title" /></title>
</head>
<body>
	<h1>
		<bean:message key="main.page.menu" />
	</h1>
	<h4>
		<a href="GroupsDisplay.do"><bean:message key="main.group" /></a>
	</h4>
	<h4>
		<a href="AllContactDisplay.do"><bean:message
				key="main.contactdisplay.link" /></a>
	</h4>
	<h4>
		<a href="Search.do"><bean:message key="main.search" /></a>
	</h4>
</body>
</html:html>