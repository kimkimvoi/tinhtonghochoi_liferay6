<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.sun.org.apache.xpath.internal.operations.Bool"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.fsoft.bn.domain.Visitor"%>

<%@include file="/html/common/init.jsp"%>
<c:if test="${not empty lstVisitorNews}">
	<div class="box_visitor_new_more">
		<h2 class="headerPortlet"><a href="${portletTitle}"><liferay-ui:message key="${portletTitle}"/></a></h2>
		<div class="visitor_news">
			<a href="${lstVisitorNews[0].urlDetail}">
				<img class="img" src="${lstVisitorNews[0].imageURL}" />
			</a>
			<div class="boxtext">
				<h3 class="title">
					<a href="${lstVisitorNews[0].urlDetail}">${lstVisitorNews[0].title}</a>
				</h3>
				<div class="text">${lstVisitorNews[0].summary}</div>
			</div>
		</div>
		<ul class="related_news">
			<c:forEach items="${lstVisitorNews}" begin="1" end="3" var="item"
				varStatus="status">
				<li class="title"><a href="${item.urlDetail}">${item.title}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</c:if>
<c:if test="${empty lstVisitorNews}">
	LIST EMPTY
</c:if>
