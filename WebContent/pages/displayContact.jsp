<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.lip6.struts.domain.Contact"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.LinkedList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="display.contact.title" /></title>
</head>
<body>

	<!-- On divise les infos d'un contact en 3 tableaux : contact + adresse, phones et groups -->
	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="add.contact.form.id" /></th>
				<th><bean:message key="add.contact.form.lastname" /></th>
				<th><bean:message key="add.contact.form.firstname" /></th>
				<th><bean:message key="add.contact.form.email" /></th>

				<!-- On affiche les colonnes seulement si l'adresse existe -->
				<logic:present name="ADDRESS">
					<th><bean:message key="add.contact.form.street" /></th>
					<th><bean:message key="add.contact.form.city" /></th>
					<th><bean:message key="add.contact.form.zip" /></th>
					<th><bean:message key="add.contact.form.country" /></th>
				</logic:present>
			</tr>
		</thead>
		<tbody>
			<tr>
				<logic:iterate name="CONTACT" id="contact">
					<td><bean:write name="contact" property="id" /></td>
					<td><bean:write name="contact" property="firstName" /></td>
					<td><bean:write name="contact" property="lastName" /></td>
					<td><bean:write name="contact" property="email" /></td>
				</logic:iterate>

				<logic:present name="ADDRESS">
					<logic:iterate name="ADDRESS" id="address">
						<td><bean:write name="address" property="street" /></td>
						<td><bean:write name="address" property="city" /></td>
						<td><bean:write name="address" property="zip" /></td>
						<td><bean:write name="address" property="country" /></td>
					</logic:iterate>
				</logic:present>
			</tr>
		</tbody>
	</table>

	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="add.contact.form.phonekind" /></th>
				<th><bean:message key="add.contact.form.phonenumber" /></th>
				<th><bean:message key="contact.all.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="CONTACT" id="contact">
				<logic:iterate name="contact" property="phone" id="phones">
					<tr>
						<td><bean:write name="phones" property="phoneKind" /></td>
						<td><bean:write name="phones" property="phoneNumber" /></td>

						<!-- Voir juste en dessous ce que l'on a fait pour group pour plus d'explications.
						Ici on veut juste récupérer l'id du group pour améliorer la gestion d'erreur dans la classe Action. -->
						<td>
							<%
								@SuppressWarnings("unchecked")
											List<Contact> c = (List<Contact>) request.getAttribute("CONTACT");
											session.setAttribute("id", c.get(0).getId());
											Map<String, Long> params = new HashMap<String, Long>();
											params.put("id", c.get(0).getId());
											pageContext.setAttribute("paramsMap", params);
							%> <html:link action="PhoneDeletion.do" name="paramsMap"
								scope="page" paramId="phoneNumber" paramName="phones"
								paramProperty="phoneNumber">
								<bean:message key="contact.all.delete" />
							</html:link>
						</td>
					</tr>
				</logic:iterate>
			</logic:iterate>
		</tbody>
	</table>

	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="add.contact.form.groupname" /></th>
				<th><bean:message key="contact.all.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="CONTACT" id="contact">
				<logic:iterate name="contact" property="group" id="groups">
					<tr>
						<td><bean:write name="groups" property="groupName" /></td>

						<!-- Problème : envoyer plusieurs valeurs à notre Action, sachant qu'on ne peut pas récupérer certaines infos pour les mettre dans une map.
						On ne peut pas créer de map pour envoyer le nom du groupe et l'id du contact (on ne peut pas récupérer le nom du groupe courant).
						On crée une map pour l'id du contact, et on envoie le nom du groupe avec html link.  -->
						<td>
							<%
								@SuppressWarnings("unchecked")
											List<Contact> c = (List<Contact>) request.getAttribute("CONTACT");
											session.setAttribute("id", c.get(0).getId());
											Map<String, Long> params = new HashMap<String, Long>();
											params.put("id", c.get(0).getId());
											pageContext.setAttribute("paramsMap", params);
							%> <html:link action="GroupDeletion.do" name="paramsMap"
								scope="page" paramId="groupName" paramName="groups"
								paramProperty="groupName">
								<bean:message key="contact.all.delete" />
							</html:link>
						</td>
					</tr>
				</logic:iterate>
			</logic:iterate>
		</tbody>
	</table>
	<h4>
		<a href="Main.do"><bean:message key="main.redirection" /></a>
	</h4>
</body>
</html:html>