<%@include file="/html/common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>

<portlet:defineObjects />
<script type="text/javascript">
	createTooltipHelp('portletTypeSelectHelp', 'portlet.cultureandtraveler.configuration.portlettypeselecthelptooltipcontent');
	createTooltipHelp('isHotNewsHelp', 'portlet.cultureandtraveler.configuration.ishotnewshelptooltipcontent');
	createTooltipHelp('quantityforsliderHelp', 'portlet.cultureandtraveler.configuration.quantityforsliderhelptooltipcontent');
</script>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="${configurationURL}" method="post" name="fm">
	<liferay-ui:success key="success" message="common.configuration.messagesuccess" />
	<aui:fieldset label="preferences">
		<div class="portletTypeSelect">
			<aui:select name="portletTypeSelect" label="portlet.cultureandtraveler.configuration.selecttype " showEmptyOption="true">
			<c:forEach items="${listTypes}" var="type">
				<c:if test="${type.key == portletTypeSelect}">
					<aui:option value="${type.key}" label="${type.value}"  selected="true"/>
				</c:if>
				<c:if test="${type.key != portletTypeSelect}">
					<aui:option value="${type.key}" label="${type.value}"  selected="fasle"/>
				</c:if>
			</c:forEach>
			</aui:select>
			<span class="taglib-icon-help">
				<img id="portletTypeSelectHelp" src="/${theme_display}/images/portlet/help.png" />
			</span>
		</div>
		
		<div class="isHotNews">
			<aui:input name="isHotNews" type="checkbox" label="portlet.cultureandtraveler.configuration.usetotopnews" checked="${isHotNews}"></aui:input>
			<span class="taglib-icon-help">
				<img id="isHotNewsHelp" src="/${theme_display}/images/portlet/help.png" />
			</span>
		</div>
		
		<div class="quantityforslider">
			<aui:input label="portlet.cultureandtraveler.configuration.quantityforslider" name="quantityItemForSlide" value="${quantityItemForSlide}"/>
			<span class="taglib-icon-help">
				<img id="quantityforsliderHelp" src="/${theme_display}/images/portlet/help.png" />
			</span>
		</div>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>