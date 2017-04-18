<%@include file="/html/common/init.jsp"%>
<%@include file="/html/common/init_config.jsp"%>
<form id="configAllNewsByTypeForm" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post">
	<liferay-ui:error />
	
	<jsp:include page="/html/portlet/news/news_source_config.jsp"></jsp:include>

	<jsp:include page="/html/portlet/news/news_display_config.jsp"></jsp:include>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</form>
