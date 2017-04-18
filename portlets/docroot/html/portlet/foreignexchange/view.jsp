<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/common/init.jsp" %>

<portlet:defineObjects />
<div id="foreign_exchange_porlet_div" class="foreign_exchang_porlet">
	<div class="foreign_exchang_wapper">
		<h2 class="title_tab">
			<span><liferay-ui:message key="portlet.foreignexchane-title"></liferay-ui:message></span>
		</h2>
		<div class="clear"></div>
		<h3 class="foreign_exchange_porlet_title-h3">
			<liferay-ui:message key="portlet.foreignexchane-title"></liferay-ui:message>
		</h3>
		<div id="foreign_exchange_table" class="foreign_exchange_table_content">
			<table border="1" class="table-foreignexchange" style="width: 100%;">
					<tr class="tr-title-foreignexchange">
						<td width="20%" height="30" align="center" >
							<liferay-ui:message key="portlet.foreignexchange-exchangecode"/>
						</td>
						<td width="20%" align="center" >
							<liferay-ui:message key="portlet.foreignexchange-exchangname"/>
						</td>
						<td width="20%" align="center" >
							<liferay-ui:message key="portlet.foreignexchange-exchangebuy"/>
						</td>
						<td width="20%" align="center" >
							<liferay-ui:message key="portlet.foreignexchange-exchangetransfer"/>
						</td>
						<td width="20%" align="center" >
							<liferay-ui:message key="portlet.foreignexchange-exchangesell"/>
						</td>
					</tr>
					<tr class="tr-content-foreignexchange" height="30">
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td> 
					</tr>
			</table>
		</div>
		<div id ="foreign_exchange_porlet_error">
				<liferay-ui:message key="portlet.foreignexchange-loaderror"/>
		</div>
	</div>
</div>