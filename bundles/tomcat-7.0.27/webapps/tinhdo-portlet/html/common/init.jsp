<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="liferay-aui"%>
<%@ taglib uri="http://liferay.com/tld/faces" prefix="liferay-faces"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>

<%@ page import="com.fsoft.bn.constant.*"%>
<%@ page import="com.fsoft.bn.util.*"%>

<%@ page import="com.liferay.portal.kernel.dao.search.*"%>
<%@ page import="com.liferay.portal.kernel.exception.*"%>
<%@ page import="com.liferay.portal.kernel.util.*"%>
<%@ page import="com.liferay.portal.security.permission.*"%>
<%@ page import="com.liferay.portal.service.permission.*"%>

<%@ page import="java.util.*"%>

<%@ page import="javax.portlet.*"%>
<%@ page import="javax.portlet.PortletPreferences"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<!--  random id for instanceable portlet, also prevent lengthy portlet instance id name-->
<c:set var="randomId" value="${cus:randomAlphabetic(4)}" />

<!--  short variable for namespace-->
<c:set var="ns" value="<%=((PortletResponse) request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE)).getNamespace()%>" />
 <%-- <%
	System.out.println("-------------~~~~~~~~~~~~~~--------------" + PortalUtil.getCurrentURL(request));

	String portletid1 = ((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY)).getPortletDisplay().getId();

	String portletid2 = PortalUtil.getPortletId(request);
	String portletid3 = ParamUtil.getString(request, CommonConstants.PORTLET_RESOURCE);
	System.out.println("portletId from theme    : " + portletid1);
	System.out.println("PortalUtil.getPortletId : " + portletid2);
	System.out.println("portlet_resource        : " + portletid3);

	PortletPreferences prefs1 = PortletPreferencesFactoryUtil.getPortletSetup(request, portletid1);
	PortletPreferences prefs2 = PortletPreferencesFactoryUtil.getPortletSetup(request, portletid2);
	PortletPreferences prefs3 = PortletPreferencesFactoryUtil.getPortletSetup(request, portletid3);
	System.out.println("prefs from theme 				   : " + prefs1.getMap());
	System.out.println("prefs from PortalUtil.getPortletId : " + prefs2.getMap());
	System.out.println("prefs from portlet_resource        : " + prefs3.getMap());
	if (!request.getParameterMap().isEmpty()) {
		System.out.println("-------- params : ");
		ParamUtil.print(request);
		System.out.println("--------");
	}
%> --%>
