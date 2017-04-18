<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/html/common/init.jsp"%>
<%@include file="/html/common/init_config.jsp"%>
<script id="" type="text/javascript" src="${contextPath}/public-theme/js/jcarousellite_1.0.1.min.js"></script>
<script id="" type="text/javascript" src="${contextPath}/public-theme/js/jquery.slides.min.js"></script>
<script id="" type="text/javascript" src="${contextPath}/tinhdo-portlet/html/js/common.js"></script>
<script id="" type="text/javascript" src="${contextPath}/tinhdo-portlet/html/js/jquery.tooltip.js"></script>
<aui:script>
Liferay.provide(
	window,
	'submitConfigForm',
	function() {
		var selectedCategories = Liferay.Util.listSelect('#<portlet:namespace/>selectedCategories');
		$('#<portlet:namespace/>categories').val(selectedCategories);
	    submitForm('#<portlet:namespace/>configAudioForm');
	}, ['liferay-util-list-fields']
);
</aui:script>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="${configurationURL}" method="post" id="configHotNewsForm" name="configAudioForm" onSubmit="event.preventDefault();submitConfigForm();">
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
	<aui:fieldset>
		<aui:input name="include_paging" type="checkbox" checked="${includePaging}" label="Bao gồm phân trang"></aui:input>
		<aui:input name="num_per_page" value="${numPerPage}" label="Số dòng tên mỗi trang :" ></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
</aui:form>