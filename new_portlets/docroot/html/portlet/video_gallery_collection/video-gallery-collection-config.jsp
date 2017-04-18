<%@include file="/html/common/init.jsp"%>
<%@include file="/html/common/init_config.jsp"%>
<form id="configVideoGalleryCollection" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post">
	<liferay-ui:error />
	
	<aui:fieldset>
		<aui:input name="numberOfItemsPerPage" label="videocollection.numberOfItemsPerPage" value="${numberOfItemsPerPage}" helpMessage="">
		</aui:input>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</form>
