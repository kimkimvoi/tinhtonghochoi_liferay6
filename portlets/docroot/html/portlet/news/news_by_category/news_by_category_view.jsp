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
			<span><a href="${viewAll}">
					<c:if test='${config.currentCat.name != "" }'>
						<liferay-ui:message key="${config.currentCat.name}"></liferay-ui:message>
					</c:if>
					<c:if test='${config.currentCat.name == ""}'>
						<liferay-ui:message key="${config.currentStruct.name}"></liferay-ui:message>
					</c:if>
				</a></span>
		</h2>
		<div class="clear"></div>
		<div class="list_new" id="${randomId}"></div>
		<c:choose>
			<c:when test="${config.includePaging}">
				<tag:paging renderPageJsFunction="renderListByCategoryPage" pageWrapperCSSSelector="#${randomId}" dataObject="${newsPage}"
					loadPageURL="${loadPage}"></tag:paging>
			</c:when>
			<c:otherwise>
				<aui:script>
				$(function(){
					renderListByCategoryPage(${cus:toJson(newsPage)}, "#${randomId}");
				});
				</aui:script>
				<a class="link_more" href="${viewAll}">
					<liferay-ui:message key="common.link.view.all"></liferay-ui:message>
				</a>
			</c:otherwise>
		</c:choose>
		<!-- <div class="clear"></div> -->
	</div>
</c:if>