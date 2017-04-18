<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>

<portlet:defineObjects />
<div>
	<form id="<portlet:namespace />configForm" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post">
		<div class="schedule_config">
			<div class="schedule_config_title"><liferay-ui:message key="portlet.schedule.config.title"/>:</div>
			<div><input type="radio" name="ViewMode" <c:if test="${schedule.viewMode == 'CurrentWeek'}">checked="checked"</c:if> id="CurrentWeek" value="CurrentWeek"><label for="CurrentWeek"><liferay-ui:message key="portlet.schedule.viewmode.currentweek"/></label></div>
			<div><input type="radio" name="ViewMode" <c:if test="${schedule.viewMode == 'All'}">checked="checked"</c:if> id="All" value="All"><label for="All"><liferay-ui:message key="portlet.schedule.viewmode.all"/></label></div>
			
			<div class="schedule_config_title"><liferay-ui:message key="portlet.schedule.config.search.title"/>:</div>		
			<div><input type="checkbox" name="SearchMode" <c:if test="${schedule.searchCondition == 'AllowSearch'}">checked="checked"</c:if> id="AllowSearch" value="AllowSearch"><label for="AllowSearch"><liferay-ui:message key="portlet.schedule.viewmode.allowsearch"/></label></div>
			
			<input type="submit" id="saveButton" title="Save" value="<liferay-ui:message key="common.button.save"/>">
		</div>
	</form>
</div>
