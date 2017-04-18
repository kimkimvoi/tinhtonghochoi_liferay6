<%@ page import="com.fsoft.bn.model.BNContact" %>
<%@ page import="com.fsoft.bn.service.BNContactLocalServiceUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/common/init.jsp" %>
<% PortletURL addNewContact = renderResponse.createActionURL();
   addNewContact.setParameter(ActionRequest.ACTION_NAME, "addNewContact");
%>

<portlet:defineObjects />
<style type="text/css">
.vangndTbl td {
	padding: 2px;
}
</style>
<p style="color: red;">This is new Portlet create by VangND1 :D
	<br> Using manage your contact
</p>
<form id="<portlet:namespace />addNewContact"
    action="<%= addNewContact.toString() %>"
    method="POST">
	<table class="vangndTbl" style="width: 200px;">
		<tr>
			<td>Name</td>
			<td><input name="<portlet:namespace/>name" /></td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><input name="<portlet:namespace/>phoneNumber" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input name="renderURL" type="hidden" value="<%= renderResponse.createActionURL().toString() %>" />
				<input type="submit" value="Save" />
				<input type="button" value="Clear" />
			</td>
		</tr>

	</table>
</form>

<%
	int countContact = BNContactLocalServiceUtil.getBNContactsCount();
 	List<BNContact> listContact = BNContactLocalServiceUtil.getBNContacts(0, countContact);
%>

<table border="1" style="width: 200px;">
	<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Phone Number</td>
	</tr>

	<%
		for (BNContact item : listContact) {
			PortletURL removeContact = renderResponse.createActionURL();
			removeContact.setParameter(ActionRequest.ACTION_NAME, "removeContact");
			removeContact.setParameter("id", String.valueOf(item.getContactId()));
	%>

		<tr>
			<td><%= item.getContactId() %></td>
			<td><%= item.getName() %></td>
			<td><%= item.getPhoneNumber() %></td>
			<td><a href="<%= removeContact.toString() %>">remove</a></td>
		</tr>
	<% } %>
</table>
<br />
<a href="<portlet:renderURL/>">Go back</a>