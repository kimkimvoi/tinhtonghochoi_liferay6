<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>
<%@include file="/html/common/init_config.jsp"%>
<%@page import="com.fsoft.bn.portlet.news.NewsContants"%>
<c:set var="sortbyOptions" value="<%=NewsContants.SORTBY_OPTIONS%>" />
<c:set var="sortbyTypes" value="<%=NewsContants.SORTBY_TYPES%>" />
<portlet:defineObjects />
<div>
	<div id="noCategorySelectErrorMessage" style="display: none;" class="portlet-msg-error">
		<liferay-ui:message key="portlet.news.config.please-select-at-least-one-category-to-diplay" />
	</div>
	<liferay-ui:success key="success" message="Configuration saved successfully!" />
	<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
	<aui:form action="${configurationURL}" method="post" id="configHotNewsForm2" name="configHotNewsForm2" onSubmit="event.preventDefault();submitConfigHotNewsForm();">
		<aui:fieldset label="portlet.news.config.video.structure-to-display">
			<aui:input name="current_category_order" type="hidden" />
			<liferay-ui:input-move-boxes leftList="${categoriesUnselect}" leftBoxName="available"
				leftTitle="portlet.news.config.available-categories" rightReorder="false" rightBoxName="current" rightList="${categoriesSelected}"
				rightTitle="portlet.news.config.selected-categories"></liferay-ui:input-move-boxes>
			<aui:select inlineField="true" inlineLabel="left" label="order-by" name="sortBys">
			<c:forEach items="${sortbyOptions}" var="sortbyOption">
					<aui:option label="${sortbyOption.value}" selected='${sortBy == sortbyOption.key}' value="${sortbyOption.key}" />
				</c:forEach>
			</aui:select>
			<aui:select inlineField="true" label="" name="sortTypes">
				<c:forEach items="${sortbyTypes}" var="sortbyType">
					<aui:option label="${sortbyType.value}" selected='${sortType == sortbyType.key}' value="${sortbyType.key}" />
				</c:forEach>
			</aui:select>
		</aui:fieldset>
		<input type="submit" id="saveButton" title="Save" value="<liferay-ui:message key="common.button.save"/>">
</aui:form>
</div>
<aui:script>
     
var configHotNewsForm2 = document.${ns}configHotNewsForm2;
Liferay.provide(
		window,
		'submitConfigHotNewsForm',
		function() {
			configHotNewsForm2.${ns}current_category_order.value = Liferay.Util.listSelect(configHotNewsForm2.${ns}current);
		    if (configHotNewsForm2.${ns}current_category_order.value == ""){
				$("#noCategorySelectErrorMessage").show();
				return;
			}
			submitForm(document.${ns}configHotNewsForm2);
		},
		['liferay-util-list-fields']
	);
</aui:script>
