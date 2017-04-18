<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@include file="/html/common/init.jsp"%>
<portlet:defineObjects />
<div  class="box_bg" >
	<h2 class="title_tab">
		<c:if test="${viewMode != 'viewPhoto'}">
			<label>Thư Viện Ảnh</label>
		</c:if>
		<c:if test="${viewMode == 'viewPhoto'}">
			<label><a href="thu-vien-anh">Thư Viện Ảnh &#187; ${folderName}</a></label>
		</c:if>
	</h2>
	<c:if test="${viewMode == 'viewPhoto'}">
		<div id="album-photo">
			<ul>
				<c:forEach var="item" items="${listPhoto}">
					<li>
				    	<a rel="photo_album" href="${item.url}"><img alt="example1" src="${item.url}" /></a>
					</li>
				</c:forEach>
			</ul>
			<div class="photo-header"><span>Album ảnh khác :</span></div>
			
		</div>
	</c:if>
	<!-- TODO GET LIST ALBUM -->
	<div id="listPhotoAlbum">
		<ul class="list_photo">
				<c:forEach var="item" items="${listAlbum}">
					<li class="sigFreeThumb">
						<span class="sigFreeLinkOuterWrapper">
							<span class="sigFreeLinkWrapper" >
								<c:choose>
									<c:when test='${item.imageThumb.url.length() > 0}'>
										<a href="${item.url}"><img src="${item.imageThumb.url}" alt="${item.imageThumb.title}"></a>				
									</c:when>
									<c:otherwise>
										<a href="${item.url}"><img src="${pageContext.request.contextPath}/html/images/no_images.jpg"/></a>
									</c:otherwise>
								</c:choose>
							</span>
						</span>
						<p>
							<a href="${item.url}" >${item.name}</a>
						</p>
					</li>
				</c:forEach>
		</ul>
	</div>
</div>
