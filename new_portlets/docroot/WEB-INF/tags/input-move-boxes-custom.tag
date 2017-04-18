<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ attribute name="cssClass" description="Loading indicator CSS class"%>
<%@ attribute name="leftList" description="Loading indicator CSS class" required="true" type="java.util.List"%>
<%@ attribute name="leftBoxName" description="Loading indicator CSS class" required="true"%>
<%@ attribute name="leftTitle" description="Loading indicator CSS class" required="true"%>
<%@ attribute name="leftOnChange" description="Loading indicator CSS class"%>
<%@ attribute name="leftReorder" description="Loading indicator CSS class"%>
<%@ attribute name="rightList" description="Loading indicator CSS class" required="true" type="java.util.List"%>
<%@ attribute name="rightBoxName" description="Loading indicator CSS class" required="true"%>
<%@ attribute name="rightTitle" description="Loading indicator CSS class" required="true"%>
<%@ attribute name="rightOnChange" description="Loading indicator CSS class"%>
<%@ attribute name="rightReorder" description="Loading indicator CSS class"%>

<liferay-ui:input-move-boxes leftList="${config.unselectedCategories}" leftBoxName="available"
	leftTitle="portlet.news.config.available-categories" rightReorder="true" rightBoxName="current" rightList="${config.selectedCategories}"
	rightTitle="portlet.news.config.selected-categories" rightOnChange="onRightBoxChange()" cssClass="" leftOnChange="" leftReorder="">
</liferay-ui:input-move-boxes>