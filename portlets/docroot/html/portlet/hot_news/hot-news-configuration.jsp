<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/html/common/init.jsp"%>
<%@include file="/html/common/init_config.jsp"%>
<script id="" type="text/javascript" src="${contextPath}/public-theme/js/jcarousellite_1.0.1.min.js"></script>
<script id="" type="text/javascript" src="${contextPath}/public-theme/js/jquery.slides.min.js"></script>
<script id="" type="text/javascript" src="${contextPath}/tinhdo-portlet/html/js/common.js"></script>
<script id="" type="text/javascript" src="${contextPath}/tinhdo-portlet/html/js/jquery.tooltip.js"></script>

<script type="text/javascript">
	createTooltipHelp('topViewHelp', 'portlet.hotnews.config.portlettopviewhelptooltipcontent');
	createTooltipHelp('latestnewsHelp', 'portlet.hotnews.config.portletlatestnewshelptooltipcontent');
	createTooltipHelp('isHotNewsHelp', 'portlet.hotnews.config.is_hot_news_help_content');
	createTooltipHelp('startTimeHelp', 'portlet.hotnews.config.portletstarttimehelptooltipcontent');
	createTooltipHelp('endTimeHelp', 'portlet.hotnews.config.portletendtimehelptooltipcontent');
	createTooltipHelp('quantityforsliderHelp', 'portlet.hotnews.config.portletquantityforsliderHelptooltipcontent');
</script>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="${configurationURL}" method="post" id="configHotNewsForm" name="configHotNewsForm" onSubmit="event.preventDefault();submitConfigHotNewsForm();">
	<liferay-ui:success key="success" message="common.configuration.messagesuccess" />
	<liferay-ui:error />
	
	<!-- choose source news from structure and categories -->
	<div id="noCategorySelectErrorMessage" style="display: none;" class="portlet-msg-error">
		<liferay-ui:message key="portlet.news.config.please-select-at-least-one-category-to-diplay" />
	</div>
	
	<div id="compareDateErrorMessage" style="display: none;" class="portlet-msg-error">
		<liferay-ui:message key="portlet.hot.news.please-enter-the-end-date-greater-than-the-start-date" />
	</div>

	<aui:fieldset label="portlet.news.config.structure-to-display">
		<aui:select name="current_struct" onChange="updateChildrenMoveBox(this.value)" inlineLabel="false" showEmptyOption="true">
			<c:forEach varStatus="status" var="struct" items="${config.structures}">
				<aui:option value="${struct.id}" selected="${config.currentStruct.id == struct.id}">${struct.name}</aui:option>
			</c:forEach>
		</aui:select>

		<aui:input name="current_category_order" type="hidden" />
		<liferay-ui:input-move-boxes leftList="${config.unselectedCategories}" leftBoxName="available"
			leftTitle="portlet.news.config.available-categories" rightReorder="false" rightBoxName="current" rightList="${config.selectedCategories}"
			rightTitle="portlet.news.config.selected-categories"></liferay-ui:input-move-boxes>
	</aui:fieldset>

	<!-- others configuration -->	
	<aui:fieldset label="portlet.hotnews.config.displaynewsfollow">
		<div class="news_config">
			<aui:field-wrapper name="displayTypeListNews">
				<div class="latestNews">
					<aui:input type="radio" id="radLatestNews" onClick="clickLatest()"  inlineLabel="right" name="displayTypeListNews" 
							checked="${config.displayMode == 'latest_news'}"	label="portlet.hotnews.config.latestnews" value="1" />
					<span class="taglib-icon-help">
						<img id="latestnewsHelp" src="/public-theme/images/portlet/help.png" />
					</span>
				</div>
				<div class="topviews">
					<aui:input id="radTopViews"  onClick="clickViewcount()" inlineLabel="right" label="portlet.hotnews.config.topview" name="displayTypeListNews" 
							checked="${config.displayMode == 'top_views'}" type="radio" value="2"  />
					<span class="taglib-icon-help">
						<img id="topViewHelp" src="/public-theme/images/portlet/help.png" />
					</span>
				</div>
				<div class="isHotNews">
					<aui:input id="radHotViews" onClick="clickViewHotNews()" inlineLabel="right" label="portlet.hotnews.config.isHotNews" name="displayTypeListNews" 
							checked="${config.displayMode == 'hot_news'}" type="radio" value="3"  />	
					<span class="taglib-icon-help">
						<img id="isHotNewsHelp" src="/public-theme/images/portlet/help.png" />
					</span>
				</div>
			</aui:field-wrapper>
		</div>
	</aui:fieldset>
	<aui:fieldset label="portlet.hotnews.config.quantitynewsdisplayforslide">
		<div class="quantityItemForSlide">
			<aui:input name="quantityItemForSlide" value="${quantityItemForSlide}" helpMessage="">
				<aui:validator name="required" errorMessage="portlet.news.config.required.number_of_news"></aui:validator>
				<aui:validator name="digits" errorMessage="portlet.news.config.required.number_of_news"/>
				<aui:validator name="range" errorMessage="portlet.news.config.required.number_of_news">[1,20]</aui:validator>
			</aui:input>
		</div>
	</aui:fieldset> 
	<c:if test="${!hideRangeDate eq true}">
		<div id="topViewFixTime">
	</c:if>
	<c:if test="${hideRangeDate eq true}">
		<div id="topViewFixTime" hidden="true">
	</c:if>
		<aui:fieldset label="portlet.hotnews.config.topviewfixtime">	
		<div class="topViewFixTime">
			<div class="startTime">
				<div class="textAlignRight"> 
					<label><liferay-ui:message key="portlet.hotnews.config.starttime" /></label>
				</div>
				<div>
					<liferay-ui:input-date formName="startTime" yearRangeStart="1950" yearRangeEnd="2100" dayParam="startDay" monthParam="startMonth"
						dayNullable="<%=true%>" monthNullable="<%=true%>" yearNullable="<%=true%>"
						yearParam="startYear" yearValue="${startYear}" dayValue="${startDay}" monthValue="${startMonth}" />
				</div>
				<span class="taglib-icon-help">
					<img id="startTimeHelp" src="/public-theme/images/portlet/help.png" />
				</span>
				
				<!-- date picker use AUI tag -->
				</div>
			<div class="endTime">
				<div class="textAlignRight">
					<label><liferay-ui:message key="portlet.hotnews.config.endtime" /></label>
				</div>
				<div>
					<liferay-ui:input-date  formName="endTime" yearRangeStart="1950" yearRangeEnd="2100" dayParam="endDay" monthParam="endMonth" 
						dayNullable="<%=true%>" monthNullable="<%=true%>" yearNullable="<%=true%>" 
						yearParam="endYear" yearValue="${endYear}" dayValue="${endDay}" monthValue="${endMonth}" />
				</div>
				<span class="taglib-icon-help">
					<img id="endTimeHelp" src="/public-theme/images/portlet/help.png" />
				</span>
			</div>
		</div>
	</aui:fieldset>
	</div>
	
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
</aui:form>

<aui:script>
     
var configHotNewsForm = document.${ns}configHotNewsForm;
Liferay.provide(
		window,
		'submitConfigHotNewsForm',
		function() {
			configHotNewsForm.${ns}current_category_order.value = Liferay.Util.listSelect(configHotNewsForm.${ns}current);
		    if (configHotNewsForm.${ns}current_category_order.value == ""){
				$("#noCategorySelectErrorMessage").show();
				return;
			}
			
			var checkDate = compareDate();

			console.log('The end date must be greater than the start date! '+ checkDate);
			if (!checkDate) {
				$("#compareDateErrorMessage").show();
				return;
			}			
			
			submitForm(document.${ns}configHotNewsForm);
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
		_.each(currentStruct.categories, function(item, index){
			left.append("<option value='"+ item.id+"'>"+item.name+ "</option>");
		});
	}
	
	function compareDate() {
		var startDay = $("#${ns}startDay").val();
		var startMonth = $("#${ns}startMonth").val();
		var startYear = $("#${ns}startYear").val();
		
		var endDay = $("#${ns}endDay").val();
		var endMonth = $("#${ns}endMonth").val();
		var endYear = $("#${ns}endYear").val();
		
		var startDate = new Date(startYear, startMonth - 1, startDay);
		var endDate   = new Date(endYear, endMonth - 1, endDay);
		return endDate >= startDate;
	}
</aui:script>
