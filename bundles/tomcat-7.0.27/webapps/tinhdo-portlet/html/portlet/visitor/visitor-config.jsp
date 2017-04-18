<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>

<portlet:defineObjects />
<liferay-ui:success key="success" message="Configuration saved successfully!" />
<liferay-ui:success key="error" message="Configuration saved fail!" />

<div>
	<form id="<portlet:namespace />configForm" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post">
		<div class="visitor_config">
			<!-- 
			<div class="visitor_config_title"><liferay-ui:message key="portlet.visitor.config.title"/>:</div>
			 -->
			<aui:select name="portletTypeSelect" label="portlet.cultureandtraveler.configuration.selecttype " showEmptyOption="true">
			<c:forEach items="${listType}" var="type">
					<c:if test="${type.key == portletTypeSelect}">
						<aui:option value="${type.key}" label="${type.value}"  selected="true"/>
					</c:if>
					<c:if test="${type.key != portletTypeSelect}">
						<aui:option value="${type.key}" label="${type.value}"  selected="fasle"/>
					</c:if>
				</c:forEach>
			</aui:select>
			
			<input type="submit" id="saveButton" title="Save" value="<liferay-ui:message key="common.button.save"/>">
		</div>
	</form>
</div>