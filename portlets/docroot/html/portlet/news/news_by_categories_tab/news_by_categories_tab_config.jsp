<%@include file="/html/common/init.jsp"%>
<%@include file="/html/common/init_config.jsp"%>
<%@page import="com.fsoft.bn.portlet.news.NewsContants"%>
<liferay-portlet:actionURL portletConfiguration="true" var="action" />
<aui:form id="configAllNewsByTypeForm" name="configAllNewsByTypeForm" action="${action}" method="post" onSubmit="event.preventDefault();">
	<liferay-ui:error />
	<div id="noCategorySelectErrorMessage" style="display: none;" class="portlet-msg-error">
		<liferay-ui:message key="portlet.news.config.please-select-at-least-one-category-to-diplay" />
	</div>


	<aui:fieldset>
		<aui:select name="current_struct" onChange="updateChildrenMoveBox(this.value)" inlineLabel="true" showEmptyOption="true"
			label="portlet.news.config.structure-to-display">
			<c:forEach varStatus="status" var="struct" items="${config.structures}">
				<aui:option value="${struct.id}" selected="${config.currentStruct.id == struct.id}">${struct.name}</aui:option>
			</c:forEach>
		</aui:select>

		<aui:input name="current_category_order" type="hidden" />
		<liferay-ui:input-move-boxes leftList="${config.unselectedCategories}" leftBoxName="available"
			leftTitle="portlet.news.config.available-categories" rightReorder="true" rightBoxName="current" rightList="${config.selectedCategories}"
			rightTitle="portlet.news.config.selected-categories"></liferay-ui:input-move-boxes>
	</aui:fieldset>

	<jsp:include page="/html/portlet/news/news_display_config.jsp"></jsp:include>

	<aui:button-row>
		<aui:button type="submit" onClick='submitConfigAllNewsByTypeForm();' />
	</aui:button-row>
</aui:form>
<aui:script>
var configAllNewsByTypeForm = document.${ns}configAllNewsByTypeForm;
Liferay.provide(
		window,
		'submitConfigAllNewsByTypeForm',
		function() {
			configAllNewsByTypeForm.${ns}current_category_order.value = Liferay.Util.listSelect(configAllNewsByTypeForm.${ns}current);
			
			if ( configAllNewsByTypeForm.${ns}current_category_order.value == ""){
				$("#noCategorySelectErrorMessage").show();
				return;
			}
			
			submitForm(document.${ns}configAllNewsByTypeForm);
		},
		['liferay-util-list-fields']
	);
	
	var config = ${cus:toJson(config)};
	
	function updateChildrenMoveBox(value){
		var left = $("#${ns}available");
		var right = $("#${ns}current");
		right.empty();
		left.empty();
		var currentStruct = _.find(config.structures, function (item){
			return item.id == value;
		});
		console.log(currentStruct);
		_.each(currentStruct.categories, function(item, index){
			left.append("<option value='"+ item.id+"'>"+item.name+ "</option>");
		});
	}
</aui:script>