<%@include file="/html/common/init.jsp"%>
<%@page import="com.fsoft.bn.portlet.news.NewsContants"%>
<c:set var="summaryMaxLengths" value="<%=NewsContants.SUMMARY_MAX_LENGTH_VALUES%>" />
<c:set var="recordPerPageVals" value="<%=NewsContants.NUM_PER_PAGE_VALUES%>" />
<c:set var="displayTypes" value="<%=NewsContants.DISPLAY_TYPES%>" />
<c:set var="sortbyOptions" value="<%=NewsContants.SORTBY_OPTIONS%>" />
<c:set var="sortbyTypes" value="<%=NewsContants.SORTBY_TYPES%>" />
<c:set var="summaryType" value="<%=NewsContants.DISPLAY_TYPE_SUMMARY%>" />
<aui:fieldset>
	<c:choose>
		<c:when test="${config.sortbys.isEmpty()}">
			<span class="aui-field-row"> <aui:select inlineField="true" inlineLabel="left" label="order-by" name="sortbyName0">
					<c:forEach items="${sortbyOptions}" var="sortbyOption">
						<aui:option selected='${sortbyOption.key == "createdDate"}' label="${sortbyOption.value}" value="${sortbyOption.key}" />
					</c:forEach>
				</aui:select> <aui:select inlineField="true" label="" name="sortbyType0">
					<c:forEach items="${sortbyTypes}" var="sortbyType">
						<aui:option label="${sortbyType.value}" value="${sortbyType.key}" />
					</c:forEach>
				</aui:select>
			</span>
		</c:when>
		<c:otherwise>
			<c:forEach items="${config.sortbys}" varStatus="status" var="sortby">
				<span class="aui-field-row"> <aui:select inlineField="true" inlineLabel="left" label="order-by" name="sortbyName${status.count}">
						<c:forEach items="${sortbyOptions}" var="sortbyOption">
							<aui:option label="${sortbyOption.value}" selected='${sortby.key == sortbyOption.key}' value="${sortbyOption.key}" />
						</c:forEach>
					</aui:select> <aui:select inlineField="true" label="" name="sortbyType${status.count}">
						<c:forEach items="${sortbyTypes}" var="sortbyType">
							<aui:option label="${sortbyType.value}" selected='${sortby.key == sortbyType.key}' value="${sortbyType.key}" />
						</c:forEach>
					</aui:select>
				</span>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	
	<aui:select name="display_type" label="portlet.news.config.display-type" inlineLabel="true" onChange="updateDisplayOptions(this.value)">
		<c:forEach items="${displayTypes}" var="val">
			<aui:option value="${val}" selected="${config.displayType == val }">
				<liferay-ui:message key="${val}" />
			</aui:option>
		</c:forEach>
	</aui:select>

	<div id="${ns}summary_max_lengthWrp">
		<aui:select name="summary_max_length" helpMessage="" inlineLabel="true" label="portlet.news.config.summary-max-length">
			<c:forEach items="${summaryMaxLengths}" var="val">
				<aui:option value="${val}" selected="${config.summaryMaxLength == val }">${val}</aui:option>
			</c:forEach>
		</aui:select>
	</div>
	<aui:select name="num_per_page" helpMessage="" inlineLabel="true" label="portlet.news.config.record-to-display">
		<c:forEach items="${recordPerPageVals}" var="val">
			<aui:option value="${val}" selected="${config.numPerPage == val }">${val}</aui:option>
		</c:forEach>
	</aui:select>

	<aui:input label="portlet.news.config.include-paging" inlineLabel="left" name="include_paging" type="checkbox"
		checked="${config.includePaging }" />

</aui:fieldset>
<script type="text/javascript">
	var summary_max_length_id = "#${ns}summary_max_lengthWrp";
	
	<c:if test="${config.displayType != summaryType}">
			$(summary_max_length_id).hide();
	</c:if>

	function updateDisplayOptions(val){
		console.log(updateDisplayOptions);
		
		if (val == "<%=NewsContants.DISPLAY_TYPE_SUMMARY%>"){
			$(summary_max_length_id).show();
		}else{
			$(summary_max_length_id).hide();
		}
	}
</script>