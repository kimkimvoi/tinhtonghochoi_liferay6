<%@page import="com.fsoft.bn.portlet.news.NewsContants"%>
<%@include file="/html/common/init.jsp"%>
<%@include file="/html/common/init_config.jsp"%>
<c:set var="sortbyOptions" value="<%=NewsContants.SORTBY_OPTIONS%>" />
<c:set var="sortbyTypes" value="<%=NewsContants.SORTBY_TYPES%>" />
<c:set var="recordPerPageVals" value="<%=NewsContants.NUM_PER_PAGE_VALUES%>" />

<form id="configAllNewsByTypeForm" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post">
	<liferay-ui:error />

	<jsp:include page="/html/portlet/news/news_source_config.jsp"></jsp:include>

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

	<aui:select name="num_per_page" helpMessage="" inlineLabel="true" label="portlet.news.config.record-to-display">
		<c:forEach items="${recordPerPageVals}" var="val">
			<aui:option value="${val}" selected="${config.numPerPage == val }">${val}</aui:option>
		</c:forEach>
	</aui:select>

	<aui:input label="portlet.news.config.include-paging" inlineLabel="left" name="include_paging" type="checkbox"
		checked="${config.includePaging }" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</form>
