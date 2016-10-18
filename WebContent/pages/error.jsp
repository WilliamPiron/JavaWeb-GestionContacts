<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<html:html>
<head>
<title><bean:message key="error" /></title>
</head>
<body>
	<html:errors />
	<h1><bean:message key="error.id.exist" /></h1>
	<h4>
		<a href="Main.do"><bean:message
				key="main.redirection" /></a>
	</h4>
</body>
</html:html>