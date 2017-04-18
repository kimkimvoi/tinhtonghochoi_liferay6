<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/html/common/init.jsp"%>
<%@page contentType="text/html;charset=UTF-8"%>
<portlet:defineObjects />
<!--cac so ban nganh-->
<div class="box_bg" id="tabs_sobannganh">
	<ul class="tab_box_mn">
		<c:forEach items="${listType}" var="item">
		<li class=""><a href="#0${item.key}">${item.value}</a></li>
		</c:forEach>
	</ul>
	<div class="clear"></div>
	<c:forEach items="${listLinkPage}" var="item">
		<div id="${item.type}" class="padding_left">
			<c:forEach items="${item.links}" varStatus="sts"  var="link">
			<c:if test="${sts.index%10==0}">
				<ul class="list_sbn">
			</c:if>
				<li><a target="_blank" href="${link.url}">${link.title}</a></li>
			<c:if test="${sts.index%10==9}">
				</ul>
			</c:if>
			</c:forEach>
		</div>
	</c:forEach>
	<c:forEach items="${listTypeEmptyData}" var="item">
		<div id="0${item.key}">
			<p class="updating_data"><liferay-ui:message key="portlet.common.data.updating" /></p>
		</div>
	</c:forEach>
</div>
<!--end cac so ban nganh-->