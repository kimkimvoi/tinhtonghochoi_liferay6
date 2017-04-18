<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>

<portlet:defineObjects />
<div>
	<form id="<portlet:namespace />configForm" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post">
		<div class="schedule_config">
			<div class="schedule_config_title"><liferay-ui:message key="portlet.investmentanddevelopment.header.title"/>:</div>
			<div>
				<select name="ViewModeSelect" class="ViewModeSelect" id="ViewModeSelected">
					<aui:option value="${investmentViewMode.defaultCombobox.key}"
	    				label="${investmentViewMode.defaultCombobox.value}"
	            		selected="${investmentViewMode.defaultModeSelected == investmentViewMode.defaultCombobox.key}" />
					<c:forEach items="${investmentViewMode.listViewModel}" var="item">
			            <aui:option value="${item.key}" label="${item.value}"
			           		selected="${investmentViewMode.defaultModeSelected == item.key}" />
			        </c:forEach>
				</select>
			</div>
			<input type="submit" id="saveButton" class="saveButtonViewMode" title="Save" value="<liferay-ui:message key="common.button.save"/>">
		</div>
	</form>
</div>
