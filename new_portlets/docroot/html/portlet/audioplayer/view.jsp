<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@page import="com.fsoft.bn.portlet.news.NewsContants"%>
<%@include file="/html/common/init.jsp"%>
<portlet:defineObjects />
<script id="" type="text/javascript" src="${contextPath}/tinhdo-portlet/html/js/common.js"></script>
<script src="${pageContext.request.contextPath}/html/portlet/audioplayer/audioplayerengine/initaudioplayer-1.js"></script>
<script src="${pageContext.request.contextPath}/html/portlet/audioplayer/audioplayerengine/amazingaudioplayer.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/html/portlet/audioplayer/audioplayerengine/initaudioplayer-1.css">
<portlet:resourceURL id="<%=NewsContants.RESOURCE_ACTION.LOAD_PAGE%>" var="loadPage"></portlet:resourceURL>
 <div  class="box_bg" >
	<h2 class="title_tab">
		<label>Thư Viện Audio</label>
	</h2>
	<div id="amazingaudioplayer-1" style="display: block; position: relative; width: 300px; height: auto; margin: 0px auto; opacity: 100; padding-left: 10px;">
    </div>
</div>
<c:choose>
<c:when test="${includePaging}">
<tag:paging renderPageJsFunction="renderListAudio" pageWrapperCSSSelector="#amazingaudioplayer-1" dataObject="${audioPage}"
					loadPageURL="${loadPage}"></tag:paging>
</c:when>
<c:otherwise>
	<aui:script>
	$(function(){
		renderListAudio(${cus:toJson(audioPage)}, "#amazingaudioplayer-1");
	});
	</aui:script>
</c:otherwise>
</c:choose>