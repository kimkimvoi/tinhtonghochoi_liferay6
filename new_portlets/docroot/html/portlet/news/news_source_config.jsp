<%@include file="/html/common/init.jsp"%>
<aui:fieldset>
	<aui:select name="current_struct" onChange="updateChildrenSelectBox(this.value)" helpMessage="" inlineLabel="true" showEmptyOption="true"
		label="portlet.news.config.structure-to-display">
		<c:forEach varStatus="status" var="struct" items="${config.structures}">
			<aui:option value="${struct.id}" selected="${config.currentStruct.id == struct.id}">${struct.name}</aui:option>
		</c:forEach>
	</aui:select>

	<c:if test="${config.categories.size() == 0}">
		<aui:select name="current_category" id="category" helpMessage="" inlineLabel="true" showEmptyOption="true"
			label="portlet.news.config.category-to-display" disabled="true">
		</aui:select>
	</c:if>
	<c:if test="${config.categories.size() > 0}">
		<aui:select name="current_category" id="category" helpMessage="" inlineLabel="true" showEmptyOption="true"
			label="portlet.news.config.category-to-display">
			<c:forEach varStatus="status" var="category" items="${config.categories}">
				<aui:option value="${category.id}" selected="${config.currentCat.id == category.id}">${category.name}</aui:option>
			</c:forEach>
		</aui:select>
	</c:if>
</aui:fieldset>
<aui:script>
	var config =  ${cus:toJson(config)};
	function updateChildrenSelectBox( value) {
		var childComboBox = $('#${ns}category');
		if (value == ""){
			childComboBox.empty();
			return;
		}
		var currentStruct = _.find(config.structures, function (item){
			return item.id == value;
		});
		childComboBox.empty();
		if (currentStruct.categories.length ==0 ){
			childComboBox.attr("disabled", "");
		} else {
			childComboBox.removeAttr("disabled");
			$.each(currentStruct.categories, function(index,item ){
				childComboBox.append("<option value='"+ item.id+"'>"+item.name+ "</option>");
			});
		}
	}
</aui:script>