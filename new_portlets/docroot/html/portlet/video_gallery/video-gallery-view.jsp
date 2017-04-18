<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@include file="/html/common/init.jsp"%>
<portlet:defineObjects />
<script
	src="${pageContext.request.contextPath}/html/portlet/video_gallery/css/sliderengine/amazingslider.js"></script>
<script
	src="${pageContext.request.contextPath}/html/portlet/video_gallery/css/sliderengine/initslider-1.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/html/portlet/video_gallery/css/sliderengine/amazingslider-1.css">
<div class="box_bg">
	<h2 class="title_tab">
		<label><a href="thu-vien-video">Video</a></label>
	</h2>
	<c:if test="${not empty listVideo}">
		<div id="amazingslider-wrapper-1"
			style="display: block; position: relative; max-width: 660px; margin: 0px auto 86px;">
			<div id="amazingslider-1"
				style="display: block; position: relative; margin: 0 auto;">
				<ul class="amazingslider-slides" style="display: none;">
					<c:forEach var="item" items="${listVideo}" varStatus="index">
						<li><img
							src="https://img.youtube.com/vi/${item.id}/sddefault.jpg" alt="${item.title}" /> <video
								preload="none"
								src="https://www.youtube.com/embed/${item.id}?v=${item.id}"></video>
						</li>
					</c:forEach>
				</ul>
				<ul class="amazingslider-thumbnails" style="display: none;">
					<c:forEach var="item" items="${listVideo}" varStatus="index">
						<li><img
							src="https://img.youtube.com/vi/${item.id}/sddefault.jpg" /></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div style="display: inline-block; text-align: left; width: 100%;">
			<a href="thu-vien-video" style="font-weight: bold; float: right;">Xem
				thêm video &#62;&#62;</a>
		</div>
	</c:if>
	<c:if test="${empty listVideo}">
		Dữ liệu đang cập nhật
	</c:if>
</div>