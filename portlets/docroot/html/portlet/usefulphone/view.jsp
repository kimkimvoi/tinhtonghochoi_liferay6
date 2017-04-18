<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/common/init.jsp" %>
<portlet:defineObjects />

<div class="useful_phone_porlet">
	<div class="useful_phone_wapper">
		<h2 class="title_tab">
			<span><liferay-ui:message key="portlet.userfull_info.userfulphone"></liferay-ui:message></span>
		</h2>
		<div class="clear"></div>
		<h3 class="useful-phone-title-h3">
			<liferay-ui:message key="portlet.userfull_info.userfulphone"></liferay-ui:message>
		</h3>
		<div class="useful_phone_table_content">
			<c:choose>
				<c:when test="${listContact != null}">
					<table border="1" class="table-userfullcontact" style="width: 100%;">
						<tr class="tr-title-userfullcontact">
							<td width="20%" height="30" align="center" >
								<liferay-ui:message key="portlet.userfull_phone.useful-contact-name"/>
							</td>
							<td width="20%" align="center" >
								<liferay-ui:message key="portlet.userfull_phone.useful-contact-phone"/>
							</td>
							<td width="20%" align="center" >
								<liferay-ui:message key="portlet.userfull_phone.useful-contact-email"/>
							</td>
							<td width="20%" align="center" >
								<liferay-ui:message key="portlet.userfull_phone.useful-contact-works"/>
							</td>
							<td width="20%" align="center" >
								<liferay-ui:message key="portlet.userfull_phone.useful-contact-address"/>
							</td>
						</tr>
						<c:forEach items="${listContact}" var="contact">  
							<tr class="tr-content-userfullcontact" height="30"> 
								<td>${contact.userful_contact_name}</td>
								<td>${contact.userful_contact_phone}</td>
								<td>${contact.userful_contact_email}</td>
								<td>${contact.userful_contact_position}</td>
								<td>${contact.userful_contact_address}</td>
							</tr>				
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<div><liferay-ui:message key="portlet.userfull_phone.get-data-error"/></div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
