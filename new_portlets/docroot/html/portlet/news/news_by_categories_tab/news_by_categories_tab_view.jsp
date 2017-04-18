<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="/html/common/init.jsp"%>
<portlet:resourceURL escapeXml="false" id="loadPage" var="loadPage"></portlet:resourceURL>
<input id="switchTab_URL" type="hidden" value="${switchTabURL}" />
<c:if test="${!config.configured}">
	<div class="portlet-configuration portlet-msg-info">
		<a href="<%=portletDisplay.getURLConfiguration()%>" onClick="<%=portletDisplay.getURLConfigurationJS()%>">
			<liferay-ui:message key="please-configure-this-portlet-to-make-it-visible-to-all-users" />
		</a>
	</div>
</c:if>
<c:if test="${config.configured}">
	<div class="box_bg" id="${ns}tabs_new">
		<ul class="tab_box_mn">
			<c:forEach items="${config.catOrders}" var="category" varStatus="status">
				<li class="news_category_tab_anchor" onclick="loadCategoryPageTab('${category.key}', '${ns}${status.count}','${loadPage}', ${config.includePaging})">
					<a href="#${ns}${status.count}">${category.value}</a>
				</li>
			</c:forEach>
		</ul>
		<div class="clear"></div>

		<c:forEach items="${config.catOrders}" var="category" varStatus="status">
			<div id="${ns}${status.count}">
				<div class="list_new"></div>
				<div class="paging"></div>
				<c:if test="${status.count == 1}">
					<aui:script>
					$(function (){
						loadCategoryPageTab(${category.key}, "${ns}${status.count}", "${loadPage}", ${config.includePaging});
					});
					</aui:script>
				</c:if>

				<div class="clear"></div>
				<portlet:actionURL var="viewAllByCategoryActionURL">
					<portlet:param name="id" value="${category.key}" />
				</portlet:actionURL>
				<a class="link_more" href="${viewAllByCategoryActionURL}">
					<liferay-ui:message key="common.link.view.all"></liferay-ui:message>
				</a>
			</div>
		</c:forEach>
	</div>
</c:if>
<aui:script>
	$(function() {
		$("#${ns}tabs_new").tabs();
	});
</aui:script>

