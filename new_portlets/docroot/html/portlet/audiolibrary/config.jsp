<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/html/common/init.jsp"%>
<%@include file="/html/common/init_config.jsp"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects/>

<aui:script>
Liferay.provide(
	window,
	'submitConfigForm',
	function() {
		var selectedCategories = Liferay.Util.listSelect('#<portlet:namespace/>selectedCategories');
		$('#<portlet:namespace/>categories').val(selectedCategories);
	    submitForm('#<portlet:namespace/>fm');
	}, ['liferay-util-list-fields']
);
</aui:script>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" id="configForm" method="POST" onSubmit="event.preventDefault();submitConfigForm();">
	<liferay-ui:success key="success" message="common.configuration.messagesuccess" />
	<liferay-ui:error />
	
	<aui:input name="categories" type="hidden" />
	<liferay-ui:input-move-boxes 
			leftList="${config.availableCategoryList}" leftBoxName="availableCategories"
			leftTitle="portlet.audiolibrary.config.available-categories" rightReorder="false" 
			rightList="${config.selectedCategoryList}" rightBoxName="selectedCategories" 
			rightTitle="portlet.audiolibrary.config.selected-categories">
	</liferay-ui:input-move-boxes>
	<br>
	<aui:select name="author" showEmptyOption="true" inlineField="true">
		<c:forEach var="author" items="${audioAuthorList}">
			<aui:option value="${author}" selected="${fn:contains(config.selectedAuthor, author)}">${author}</aui:option>
		</c:forEach>
	</aui:select>
	<br>
	<aui:select name="sortByName" label="Gọi ra theo" inlineField="true">
		<aui:option value="title" selected="${config.selectedSortByName == 'title'}">Tiêu đề</aui:option>
		<aui:option value="createdDate" selected="${config.selectedSortByName == 'createdDate'}">Ngày đăng</aui:option>
		<aui:option value="viewCount" selected="${config.selectedSortByName == 'viewCount'}">Số lượt xem</aui:option>
	</aui:select>
	<aui:select name="sortByType" label="" inlineField="true">
		<aui:option value="asc" selected="${config.selectedSortByType == 'asc'}">Tăng dần</aui:option>
		<aui:option value="desc" selected="${config.selectedSortByType == 'desc'}">Giảm dần</aui:option>
	</aui:select>
	<br>

	<aui:select name="numPerPage" label="Số lượng hiển thị" inlineField="true">
		<c:forEach var="index" begin="5" end="50" step="5">
			<aui:option value="${index}" selected="${config.selectedNumPerPage == index}">${index}</aui:option>
		</c:forEach>
	</aui:select>
	
	<aui:input type="checkbox" name="isPaging" label="Bao gồm phân trang" inlineLabel="left" checked="${config.isPaging}"></aui:input>
	<br>
	<aui:input type="checkbox" name="byCategory" label="Theo album" inlineLabel="left" checked="${config.byCategory}"></aui:input>
	<br>
	<input type="submit" value="Ghi lại" />
</aui:form>