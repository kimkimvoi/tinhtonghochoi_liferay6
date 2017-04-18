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
		<h2 <c:if test='${config.currentCat.name != "HOT NOTICE" }'>class="title_tab"</c:if><c:if test='${config.currentCat.name == "HOT NOTICE" }'>class="hot_notice"</c:if>>
			<label><a href="${viewAll}">
					<c:if test='${config.currentCat.name != "" }'>
						<c:if test='${config.currentCat.name != "HOT NOTICE" }'>
							<liferay-ui:message key="${config.currentCat.name}"></liferay-ui:message>
						</c:if>
					</c:if>
					<c:if test='${config.currentCat.name == ""}'>
						<liferay-ui:message key="${config.currentStruct.name}"></liferay-ui:message>
					</c:if>
				</a></label>
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
			</c:otherwise>
		</c:choose>
		<!-- <div class="clear"></div> -->
	</div>
</c:if>
<input id="months_01" 	type="hidden"	value="<liferay-ui:message key="months.01" />"  />
<input id="months_02" 	type="hidden"	value="<liferay-ui:message key="months.02" />"  />
<input id="months_03" 	type="hidden"	value="<liferay-ui:message key="months.03" />"  />
<input id="months_04" 	type="hidden"	value="<liferay-ui:message key="months.04" />"  />
<input id="months_05" 	type="hidden"	value="<liferay-ui:message key="months.05" />"  />
<input id="months_06" 	type="hidden"	value="<liferay-ui:message key="months.06" />"  />
<input id="months_07" 	type="hidden"	value="<liferay-ui:message key="months.07" />"  />
<input id="months_08" 	type="hidden"	value="<liferay-ui:message key="months.08" />"  />
<input id="months_09" 	type="hidden"	value="<liferay-ui:message key="months.09" />"  />
<input id="months_10" 	type="hidden"	value="<liferay-ui:message key="months.10" />"  />
<input id="months_11" 	type="hidden"	value="<liferay-ui:message key="months.11" />"  />
<input id="months_12" 	type="hidden"	value="<liferay-ui:message key="months.12" />"  />
