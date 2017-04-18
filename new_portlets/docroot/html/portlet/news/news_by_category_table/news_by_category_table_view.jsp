<%@page import="com.fsoft.bn.portlet.news.NewsContants"%>
<%@include file="/html/common/init.jsp"%>
<portlet:resourceURL id="<%=NewsContants.RESOURCE_ACTION.LOAD_PAGE%>" var="loadPage"></portlet:resourceURL>
<portlet:actionURL var="viewAll">
	<portlet:param name="categoryId" value="${config.currentCat.id}" />
</portlet:actionURL>
<c:if test="${!config.configured}">
	<div class="portlet-configuration portlet-msg-info">
		<a href="<%=portletDisplay.getURLConfiguration()%>" onClick="<%=portletDisplay.getURLConfigurationJS()%>">
			<liferay-ui:message key="please-configure-this-portlet-to-make-it-visible-to-all-users" />
		</a>
	</div>
</c:if>
<c:if test="${config.configured}">
	<div class="box_bg">
		<h2 class="title_tab">
			<label><a href="#">
					<c:if test='${config.currentCat.name != "" }'>
						<liferay-ui:message key="${config.currentCat.name}"></liferay-ui:message>
					</c:if>
					<c:if test='${config.currentCat.name == ""}'>
						<liferay-ui:message key="${config.currentStruct.name}"></liferay-ui:message>
					</c:if>
				</a></label>
		</h2>
		<div class="list_new" id="${randomId}"></div>
		<c:choose>
			<c:when test="${config.includePaging}">
				<tag:paging renderPageJsFunction="renderListByCategoryPageTable" pageWrapperCSSSelector="#${randomId}" loadPageURL="${loadPage}"></tag:paging>
			</c:when>
			<c:otherwise>
				<aui:script>
				$(function(){
					renderListByCategoryPageTable(${cus:toJson(newsPage)}, "#${randomId}");
				});
				</aui:script>
			</c:otherwise>
		</c:choose>
		<div class="clear"></div>
	</div>
</c:if>
<aui:script>
	function toggleDetailRow(current){
		if ($(current).next().css("display") == "none") {
			$(current).next().slideToggle(500);
		} else{
			$(current).next().css("display", "none");
		}
		$(current).parent().children().filter(".rowDetail").not($(current).next()).each(function () {
			if ($(current).css("display") != "none") {
				$(this).css("display", "none");
			} 
		});
	}
</aui:script>