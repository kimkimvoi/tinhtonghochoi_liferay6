<%@include file="/html/common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>

<portlet:defineObjects />
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="${configurationURL}" method="post" name="fm">
	<liferay-ui:success key="success" message="Configuration saved successfully!" />
	<aui:fieldset label="preferences">
		<aui:input label="News Box Title" name="newsBoxTitle" value="${newsBoxTypeSelect}" disabled="true"/>
		<aui:select name="newsBoxTypeSelect" id="newsBoxTypeSelect" label="Select a News Box Type: " showEmptyOption="true">
			<c:forEach items="${listTypes}" var="type">
				<aui:option value="${type.key}" label="${type.value}" selected="${newsBoxTypeSelect == type.value}"/>
			</c:forEach>
		</aui:select>
		<aui:input name="displayFullSize" type="checkbox" label="Display full size" checked="${displayFullSize}"></aui:input>
		<aui:input name="displayImage" type="checkbox" label="Display News image" checked="${displayImage}"></aui:input>
		<aui:input name="displaySummary" type="checkbox" label="Display summary" checked="${displaySummary}"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>