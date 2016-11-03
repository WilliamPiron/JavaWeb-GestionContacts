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
	href="css\bootstrap-3.3.7-dist\css\bootstrap.custom.login.css" />
<link rel="stylesheet" type="text/css"
	href="css\bootstrap-3.3.7-dist\css\bootstrap.min.css" />

<title><bean:message key="welcome.page.title" /></title>
<html:base />
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<html:form action="/Login" styleClass="form-signin">
				<h3 class="form-signin-heading">Please Sign In</h3>
				<hr class="colorgraph">
				<br>

				<html:text property="username" size="30" maxlength="50"
					value="admin" styleClass="form-control" />
				<html:password property="password" size="30" maxlength="50"
					value="admin" styleClass="form-control" />
				<td align="right"><html:submit
						styleClass="btn btn-lg btn-primary btn-block">
						<bean:message key="form.validation" />
					</html:submit></td>
				<html:errors />
			</html:form>
		</div>
	</div>
</body>
</html:html>