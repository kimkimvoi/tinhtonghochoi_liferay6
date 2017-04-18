<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<portlet:defineObjects />
<h2 class="title_tab">
	<label><liferay-ui:message key="portlet.picturegallery.title"/></label>
</h2>
<div class="clear"></div>
<div class="box_content_s">
	<div class="crumbs">
		<ul>
			<c:forEach var="item" items="${breadcumbs}" varStatus="status">
				<c:if test="${!status.last}">
					<li><a href="#" onclick="previewPictureByFolder('${item.key}')">${item.value}</a></li>
				</c:if>
				<c:if test="${status.last}">
					<li><a href="javascript:void(0);">${item.value}</a></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
	<div class="clear"></div>
	<div class="box_photo_detail"><div class="mygallery"><div class="tn3-gallery">
		<div class="clear"></div>
		<div class="tn3-thumbs">
			<ul>
				<c:choose>
					<c:when test="${pictures.size() > 0}">
						<c:forEach var="picture" items="${pictures}">
							<li class="tn3-thumb"><a href="${picture.url}&imagePreview=1">
								<img src="${picture.url}" alt="${picture.title}">
							</a></li>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<li class="tn3-thumb"><a href="${pageContext.request.contextPath}/html/images/no_images.jpg">
							<img src="${pageContext.request.contextPath}/html/images/no_images.jpg">
						</a></li>						
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div></div></div>
	<div class="clear"></div>
	<div>
		<%-- <div class="full_tree_view">${treeview}</div> --%>
		<div class="sub_folders" id="sub_folders_picture">
			<ul class="list_photo">
				<c:forEach var="folder" items="${subFolders}">
					<li>
						<div class="photo">
							<c:choose>
								<c:when test='${folder.imageThumb.url.length() > 0}'>
									<a href="javascript:void(0);" onclick="previewPictureByFolder('${folder.folderId}')"><img src="${folder.imageThumb.url}" alt="${folder.imageThumb.title}"></a>				
								</c:when>
								<c:otherwise>
									<a href="javascript:void(0);" onclick="previewPictureByFolder('${folder.folderId}')"><img src="${pageContext.request.contextPath}/html/images/no_images.jpg"/></a>
								</c:otherwise>
							</c:choose>
						</div>
						<p>
							<a href="javascript:void(0);" onclick="previewPictureByFolder('${folder.folderId}')">${folder.name}</a>
						</p>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	
	<cus:paginator curPageStatusText="${curPageStatusText}" itemsPerPageText="${itemsPerPageText}" numOfPage="${numOfPage}" numPerPage="${numPerPage}" tableId="listPictureModel" />
	<portlet:resourceURL escapeXml="false" id="listPictureModel_LoadPage" var="listPictureModel_LoadPage" />
	<input id="listPictureModel_loadPageURL" type="hidden" value="<%=renderResponse.encodeURL(listPictureModel_LoadPage.toString()) %>" />	
</div>

<portlet:actionURL name="previewPictureByFolder" var="previewPictureByFolder"/>
<form name="pictureGallery_Folder_Form" id="pictureGallery_Folder_Form" action="${previewPictureByFolder}" style="display: none" method="POST">
	<input type="hidden" id="folderId" name="folderId">	
</form>
<div class="clear"></div>
<script type="text/javascript">
	$(document).ready(function(){
		reloadPictureGallery();	
	});
</script>